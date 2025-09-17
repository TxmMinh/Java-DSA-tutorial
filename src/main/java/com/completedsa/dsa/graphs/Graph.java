package com.completedsa.dsa.graphs;

import java.util.Arrays;

public abstract class Graph {
    protected int[][] adjMatrix;
    protected char[] vertexData;
    protected int size;

    public Graph(int size) {
        this.size = size;
        this.adjMatrix = new int[size][size];
        this.vertexData = new char[size];
    }

    public abstract void addEdge(int u, int v);

    public abstract void addEdge(int u, int v, int w);

    public void addVertexData(int vertex, char data) {
        if (vertex >= 0 && vertex < size) {
            vertexData[vertex] = data;
        }
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : adjMatrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println("\nVertex Data:");
        for (int i = 0; i < size; i++) {
            System.out.println("Vertex " + i + ": " + vertexData[i]);
        }
    }

    /**
     * Depth First Search Traversal
     * DFS is usually implemented using a Stack or by the use of recursion (which utilizes the call stack)
     * Depth First Search is said to go "deep" because it visits a vertex, then an adjacent vertex, and then that vertex' adjacent vertex, and so on,
     * and in this way the distance from the starting vertex increases for each recursive iteration.
     */
    private void depthFirstSearchUitl(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(vertexData[v] + " ");

        for (int i = 0; i < size; i++) {
            if (adjMatrix[v][i] != 0 && !visited[i]) {
                depthFirstSearchUitl(i, visited);
            }
        }
    }

    /**
     * How it works:
     *  Start DFS traversal on a vertex.
     *  Do a recursive DFS traversal on each of the adjacent vertices as long as they are not already visited.
     */
    public void depthFirstSearch(char startVertexData) {
        boolean[] visited = new boolean[size];
        int startVertex = new String(vertexData).indexOf(startVertexData);
        depthFirstSearchUitl(startVertex, visited);
    }

    /**
     * Breadth First Search Traversal
     * Breadth First Search visits all adjacent vertices of a vertex before visiting neighboring vertices to the adjacent vertices.
     * This means that vertices with the same distance from the starting vertex are visited before vertices further away from the starting vertex are visited.
     * How it works:
     *  Put the starting vertex into the queue.
     *  For each vertex taken from the queue, visit the vertex, then put all unvisited adjacent vertices into the queue.
     *  Continue as long as there are vertices in the queue.
     */
    public void breadthFirstSearch(char startVertexData) {
        boolean[] visited = new boolean[size];
        int[] queue = new int[size];
        int queueStart = 0; // queueStart points to the "front" (for dequeue operation)
        int queueEnd = 0; // queueEnd points to the "rear" (for enqueue operation)

        // Find index of the start vertex in vertexData array
        int startVertex = new String(vertexData).indexOf(startVertexData);
        queue[queueEnd++] = startVertex;
        visited[startVertex] = true;

        while (queueStart < queueEnd) {
            // Dequeue (take front element from queue)
            int currentVertex = queue[queueStart++];
            System.out.print(vertexData[currentVertex] + " ");

            // Check all possible neighbors of currentVertex
            for (int i = 0; i < size; i++) {
                if (adjMatrix[currentVertex][i] != 0 && !visited[i]) {
                    // Enqueue this neighbor
                    queue[queueEnd++] = i;
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * A cycle in a Graph is a path that starts and ends at the same vertex, where no edges are repeated.
     */
    public abstract boolean isCyclicDFS();

    /**
     * Dijkstra's algorithm finds the shortest path from one vertex to all other vertices.
     * Dijkstra's algorithm does not work for graphs with negative edges
     * How it works:
     *  Set initial distances for all vertices: 0 for the source vertex, and infinity for all the other.
     *  Choose the unvisited vertex with the shortest distance from the start to be the current vertex. So the algorithm will always start with the source as the current vertex.
     *  For each of the current vertex's unvisited neighbor vertices, calculate the distance from the source and update the distance if the new, calculated, distance is lower.
     *  We are now done with the current vertex, so we mark it as visited. A visited vertex is not checked again.
     *  Go back to step 2 to choose a new current vertex, and keep repeating these steps until all vertices are visited.
     *  In the end we are left with the shortest path from the source vertex to every other vertex in the graph.
     */
    public int[] dijkstra(char startVertexData) {
        int startVertex = findIndex(startVertexData);
        int[] distances = new int[size];
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[startVertex] = 0;

        for (int i = 0; i < size; i++) {
            int u = minDistance(distances, visited);

            if (u == -1) {
                break;
            }

            visited[u] = true;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDistance = distances[u] + adjMatrix[u][v];
                    if (newDistance < distances[v]) {
                        distances[v] = newDistance;
                    }
                }
            }
        }

        return distances;
    }

    private int findIndex(char data) {
        for (int i = 0; i < size; i++) {
            if (vertexData[i] == data) {
                return i;
            }
        }

        return -1;
    }

    private int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < size; v++) {
            if (!visited[v] && distances[v] < min) {
                min = distances[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Returning The Paths from Dijkstra's Algorithm.
     * To return the path, create a predecessors array to keep the previous vertex in the shortest path for each vertex.
     * The predecessors array can be used to backtrack to find the shortest path for every vertex.
     */
    public String getShortestPathDijkstra(int startVertex, int endVertex) {
        int[] distances = new int[size];
        int[] predecessors = new int[size];
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }

        distances[startVertex] = 0;

        for (int i = 0; i < size; i++) {
            int u = minDistance(distances, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDistance = distances[u] + adjMatrix[u][v];
                    if (newDistance < distances[v]) {
                        distances[v] = newDistance;
                        predecessors[v] = u;
                    }
                }
            }
        }

        String shortestPath = getPathDijkstra(startVertex, endVertex, distances, predecessors);
        return "Path: " + shortestPath + ", Distance: " + distances[endVertex];
    }

    private String getPathDijkstra(int startVertex, int endVertex, int[] distances, int[] predecessors) {
        if (endVertex == -1 || distances[endVertex] == Integer.MAX_VALUE) {
            return "No path from " + vertexData[startVertex] + " to " + vertexData[endVertex];
        }

        StringBuilder path = new StringBuilder();
        for (int vertex = endVertex; vertex != -1; vertex = predecessors[vertex]) {
            path.insert(0, vertexData[vertex] + (!path.isEmpty() ? "->" : ""));
        }

        return path.toString();
    }


    /**
     * Dijkstra's Algorithm with a Single Destination Vertex.
     * Dijkstra's algorithm will stop after visiting the destination vertex, before visiting other vertices
     */
    public String dijkstraSingleDestinationVertex(char startVertexData, char endVertexData) {
        int[] predecessors = new int[size];
        Arrays.fill(predecessors, -1);
        int startVertex = findIndex(startVertexData);
        int endVertex = findIndex(endVertexData);
        int[] distances = new int[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;
        boolean[] visited = new boolean[size];

        for (int i = 0; i < size - 1; i++) {
            int u = minDistance(distances, visited);
            if (u == -1) break;
            if (u == endVertex) {
                System.out.println("Breaking out of loop. Current vertex: " + vertexData[u]);
                System.out.println("Distances: " + Arrays.toString(distances));
                break;
            }

            visited[u] = true;
            System.out.println("Visited vertex: " + vertexData[u]);

            for (int v = 0; v < size; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                    int newDistance = distances[u] + adjMatrix[u][v];
                    if (newDistance < distances[v]) {
                        distances[v] = newDistance;
                        predecessors[v] = u;
                    }
                }
            }
        }

        String shortestPath = getPathDijkstra(startVertex, endVertex, distances, predecessors);
        return "Path: " + shortestPath + ", Distance: " + distances[endVertex];
    }

    /**
     * The Bellman-Ford Algorithm
     * How it works:
     *  Set initial distance to zero for the source vertex, and set initial distances to infinity for all other vertices.
     *  For each edge, check if a shorter distance can be calculated, and update the distance if the calculated distance is shorter.
     *  Check all edges (step 2) V − 1 times. This is as many times as there are vertices (V), minus one.
     *  Check for negative cycles.
     */
    private ResultBellmanFord bellmanFord(char startVertexData) {
        int startVertex = findIndex(startVertexData);
        if (startVertex == -1) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        int[] distances = new int[size];
        Integer[] predecessors = new Integer[size];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(predecessors, null);
        distances[startVertex] = 0;

        // Relax edges size - 1 times
        for (int i = 0; i < size - 1; i++) {
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + adjMatrix[u][v] < distances[v]) {
                        distances[v] = distances[u] + adjMatrix[u][v];
                        predecessors[v] = u;
                        System.out.println("Relaxing edge " + vertexData[u] + "->" + vertexData[v] + ", Updated distance to " + vertexData[v] + ": " + distances[v]);
                    }
                }
            }
        }

        // Check for negative weight cycle
        // After checking all edges V − 1 times, we just need to check all edges one more time, and if we find a shorter distance this last time, we can conclude that a negative cycle must exist.
        for (int u = 0; u < size; u++) {
            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + adjMatrix[u][v] < distances[v]) {
                    return new ResultBellmanFord(true, null, null);
                }
            }
        }

        return new ResultBellmanFord(false, distances, predecessors);
    }

    static class ResultBellmanFord {
        boolean hasNegativeCycle;
        int[] distances;
        Integer[] predecessors;

        public ResultBellmanFord(boolean hasNegativeCycle, int[] distances, Integer[] predecessors) {
            this.hasNegativeCycle = hasNegativeCycle;
            this.distances = distances;
            this.predecessors = predecessors;
        }
    }

    private String getPathBellmanFord(Integer[] predecessors, char startVertex, char endVertex) {
        if (predecessors == null) {
            return "Path not available";
        }

        StringBuilder path = new StringBuilder();
        int current = findIndex(endVertex);

        // Handle cases where endVertex is not found or has no path
        if (current == -1 || predecessors[current] == null) {
            return "No path from " + startVertex + " to " + endVertex;
        }

        while (current != -1) {
            path.insert(0, this.vertexData[current]);
            Integer pred = predecessors[current];

            if (pred != null && pred != findIndex(startVertex)) {
                path.insert(0, "->");
                current = pred;
            } else {
                if (pred != null) {
                    path.insert(0, startVertex + "->");
                }
                break;
            }
        }

        return path.toString();
    }

    /**
     * The Bellman-Ford algorithm is best suited to find the shortest paths in a directed graph, with one or more negative edge weights, from the source vertex to all other vertices.
     * A negative cycle is a path we can follow in circles, where the sum of the edge weights is negative.
     * Using the Bellman-Ford algorithm on a graph with negative cycles will not produce a result of shortest paths because in a negative cycle we can always go one more round and get a shorter path.
     */
    public static void findShortestPathBellmanFord(Graph g, char startVertexData) {
        ResultBellmanFord resultBellmanFord = g.bellmanFord(startVertexData);
        if (!resultBellmanFord.hasNegativeCycle) {
            for (int i = 0; i < resultBellmanFord.distances.length; i++) {
                if (resultBellmanFord.distances[i] != Integer.MAX_VALUE) {
                    char endVertexData = g.vertexData[i]; // Convert end vertex index to char
                    String path = g.getPathBellmanFord(resultBellmanFord.predecessors, startVertexData, endVertexData);
                    System.out.println(path + ", Distance: " + resultBellmanFord.distances[i]);
                } else {
                    System.out.println("No path from D to " + g.vertexData[i] + ", Distance: Infinity");
                }
            }
        } else {
            System.out.println("Negative weight cycle detected. Cannot compute shortest paths.");
        }
    }
}
