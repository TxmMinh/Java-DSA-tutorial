package com.completedsa.dsa.graphs;

public class DirectedGraph extends Graph{

    public DirectedGraph(int size) {
        super(size);
    }

    @Override
    public void addEdge(int u, int v) {
        // Directed Graph
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = 1;
        }
    }

    @Override
    public void addEdge(int u, int v, int weight) {
        // Directed and Weighted Graph
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
        }
    }


    private boolean cyclicDepthFirstSearchUtil(int v, boolean[] visited, boolean[] recStack) {
        visited[v] = true;
        recStack[v] = true;
        System.out.println("Current vertex: " + vertexData[v]);

        for (int i = 0; i < size; i++) {
            if (adjMatrix[v][i] != 0) {
                System.out.println("  Checking edge " + vertexData[v] + " -> " + vertexData[i]);
                if (!visited[i]) {
                    if (cyclicDepthFirstSearchUtil(i, visited, recStack)) {
                        return true;
                    }
                } else if (recStack[i]) {
                    return true;
                }
            }
        }

        recStack[v] = false;
        return false;
    }

    @Override
    public boolean isCyclicDFS() {
        boolean[] visited = new boolean[size];
        boolean[] recStack = new boolean[size]; // backtracking

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                if (cyclicDepthFirstSearchUtil(i, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(7);

        g.addVertexData(0, 'A');
        g.addVertexData(1, 'B');
        g.addVertexData(2, 'C');
        g.addVertexData(3, 'D');
        g.addVertexData(4, 'E');
        g.addVertexData(5, 'F');
        g.addVertexData(6, 'G');

        g.addEdge(3, 0, 6); // D -> A
        g.addEdge(0, 2, 3); // A -> C
        g.addEdge(2, 1, 5); // C -> B
        g.addEdge(2, 4, 2); // C -> E
        g.addEdge(1, 5, 4); // B -> F
        g.addEdge(4, 0, 1); // E -> A
        g.addEdge(2, 6, 7); // C -> G

        g.printGraph();

        System.out.println("\nDepth First Search starting from vertex D:");
        g.depthFirstSearch('D');

        System.out.println("\nBreadth First Search starting from vertex D:");
        g.breadthFirstSearch('D');

        System.out.println("\n");
        System.out.println("\nGraph has cycle: " + g.isCyclicDFS());

        // Dijkstra's algorithm from D to all vertices
        System.out.println("Dijkstra's Algorithm starting from vertex D:\n");
        int[] distances = g.dijkstra('D');
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Shortest distance from D to " + g.vertexData[i] + ": " + distances[i]);
        }

        System.out.println("Dijkstra's Algorithm starting from vertex D: \n");
        for (int i = 0; i < g.size; i++) {
            System.out.println(g.getShortestPathDijkstra(3, i));
        }

        System.out.println("\nDijkstra's Algorithm, from vertex D to C:\n");
        String result = g.dijkstraSingleDestinationVertex('D', 'C');
        System.out.println(result);

        // Find the shortest path use Bellman-Ford
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

        Graph g3 = new DirectedGraph(5);

        g3.addVertexData(0, 'A');
        g3.addVertexData(1, 'B');
        g3.addVertexData(2, 'C');
        g3.addVertexData(3, 'D');
        g3.addVertexData(4, 'E');

        // Add edges
        g3.addEdge(3, 0, 4);
        g3.addEdge(3, 2, 7);
        g3.addEdge(3, 4, 3);
        g3.addEdge(0, 2, 4);
        g3.addEdge(2, 0, -9);
        g3.addEdge(0, 4, 5);
        g3.addEdge(4, 2, 3);
        g3.addEdge(1, 2, -4);
        g3.addEdge(4, 1, 2);

        // Running the Bellman-Ford algorithm from D to all vertices
        System.out.println("\nThe Bellman-Ford Algorithm starting from vertex D:");
        findShortestPathBellmanFord(g3, 'D');
    }


}
