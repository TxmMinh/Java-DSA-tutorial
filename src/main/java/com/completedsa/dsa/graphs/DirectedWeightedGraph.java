package com.completedsa.dsa.graphs;

public class DirectedWeightedGraph extends Graph{

    public DirectedWeightedGraph(int size) {
        super(size);
    }

    @Override
    public void addEdge(int u, int v) {
        // Directed Graph
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = 1;
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

    public void addEdge(int u, int v, int weight) {
        // Directed and Weighted Graph
        if (u >= 0 && u < size && v >= 0 && v < size) {
            adjMatrix[u][v] = weight;
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraph g = new DirectedWeightedGraph(7);

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
    }
}
