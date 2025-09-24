package com.completedsa.dsa.graphs;

import java.util.Arrays;

public class UndirectedGraph extends Graph {
    // use for Union-Find Cycle Detection
    private int[] parent;

    public UndirectedGraph(int size) {
        super(size);

        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void addEdge(int u, int v) {
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        // Directed and Weighted Graph
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;
        }
    }

    private boolean cyclicDepthFirstSearchUtil(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (int i = 0; i < size; i++) {
            if (adjMatrix[v][i] == 1) {
                if (!visited[i]) {
                    if (cyclicDepthFirstSearchUtil(i, visited, v)) {
                        return true;
                    }
                } else if (i != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * How it works:
     *  Start DFS traversal on each unvisited vertex (in case the Graph is not connected).
     *  During DFS, mark vertices as visited, and run DFS on the adjacent vertices (recursively).
     *  If an adjacent vertex is already visited and is not the parent   of the current vertex, a cycle is detected, and True is returned.
     *  If DFS traversal is done on all vertices and no cycles are detected, False is returned.
     */
    @Override
    public boolean isCyclicDFS() {
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                if (cyclicDepthFirstSearchUtil(i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Union-Find Cycle Detection
     * How it works:
     *  First putting each node in its own subset
     *  Then, for every edge, the subsets belonging to each vertex are merged.
     *  For an edge, if the vertices already belong to the same subset, it means that we have found a cycle.
     */
    public boolean isCyclicUnionFind() {
        for (int i= 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (adjMatrix[i][j] == 1) {
                    int x = findRoot(i);
                    int y = findRoot(j);

                    if (x == y) {
                        return true;
                    }

                    union(x, y);
                }
            }
        }

        return false;
    }

    private int findRoot(int i) {
        if (parent[i] == i) {
            return i;
        }

        return findRoot(parent[i]);
    }

    private void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        System.out.println("Union: " + vertexData[x] + " + " + vertexData[y]);
        parent[xRoot] = yRoot;
        System.out.println(Arrays.toString(parent) + "\n");
    }

    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(7);

        g.addVertexData(0, 'A');
        g.addVertexData(1, 'B');
        g.addVertexData(2, 'C');
        g.addVertexData(3, 'D');
        g.addVertexData(4, 'E');
        g.addVertexData(5, 'F');
        g.addVertexData(6, 'G');

        g.addEdge(3, 0); // D - A
        g.addEdge(0, 2); // A - C
        g.addEdge(0, 3); // A - D
        g.addEdge(0, 4); // A - E
        g.addEdge(4, 2); // E - C
        g.addEdge(2, 5); // C - F
        g.addEdge(2, 1); // C - B
        g.addEdge(2, 6); // C - G
        g.addEdge(1, 5); // B - F

        g.printGraph();

        System.out.println("\nDepth First Search starting from vertex D:");
        g.depthFirstSearch('D');

        System.out.println("\nBreadth First Search starting from vertex D:");
        g.breadthFirstSearch('D');

        System.out.println("\nGraph has cycle: " + g.isCyclicDFS());

        System.out.println();
        System.out.println("\nGraph has cycle: " + g.isCyclicUnionFind());

        // Dijkstra's algorithm from D to all vertices
        System.out.println("Dijkstra's Algorithm starting from vertex D:\n");
        int[] distances = g.dijkstra('D');
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Shortest distance from D to " + g.vertexData[i] + ": " + distances[i]);
        }

        System.out.println("\nDijkstra's Algorithm starting from vertex D: \n");
        for (int i = 0; i < g.size; i++) {
            System.out.println(g.getShortestPathDijkstra(3, i));
        }

        System.out.println("\nDijkstra's Algorithm, from vertex D to C:\n");
        String result = g.dijkstraSingleDestinationVertex('D', 'C');
        System.out.println(result);

        Graph g2 = new DirectedGraph(5);

        g2.addVertexData(0, 'A');
        g2.addVertexData(1, 'B');
        g2.addVertexData(2, 'C');
        g2.addVertexData(3, 'D');
        g2.addVertexData(4, 'E');

        g2.addEdge(3, 0, 4);  // D -> A, weight 4
        g2.addEdge(3, 2, 7);  // D -> C, weight 7
        g2.addEdge(3, 4, 3);  // D -> E, weight 3
        g2.addEdge(0, 2, 4);  // A -> C, weight 4
        g2.addEdge(2, 0, -3); // C -> A, weight -3
        g2.addEdge(0, 4, 5);  // A -> E, weight 5
        g2.addEdge(4, 2, 3);  // E -> C, weight 3
        g2.addEdge(1, 2, -4); // B -> C, weight -4
        g2.addEdge(4, 1, 2);  // E -> B, weight 2

        // Running the Bellman-Ford algorithm from D to all vertices
        System.out.println("\nThe Bellman-Ford Algorithm starting from vertex D:");
        findShortestPathBellmanFord(g2, 'D');
    }

}
