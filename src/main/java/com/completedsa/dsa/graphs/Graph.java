package com.completedsa.dsa.graphs;

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
}
