package com.completedsa.dsa.graphs.minimumSpanningTree;

import java.util.Arrays;

public class Prims {

    static class Graph {
        private int size;
        private int[][] adjMatrix;
        private String[] vertexData;
        boolean[] inMST;
        int[] edgeValues;
        int[] parents;

        public Graph(int size) {
            this.size = size;
            adjMatrix = new int[size][size];
            vertexData = new String[size];
            this.inMST = new boolean[size];
            this.edgeValues = new int[size];
            this.parents = new int[size];
            Arrays.fill(this.edgeValues, Integer.MAX_VALUE);
            Arrays.fill(this.parents, -1);
        }

        public void addEdge(int u, int v, int weight) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight;
        }

        public void addVertexData(int vertex, String data) {
            vertexData[vertex] = data;
        }

        /**
         * Prim's algorithm finds the Minimum Spanning Tree (MST) in a connected and undirected graph.
         * How it works:
         *  Choose a random vertex as the starting point, and include it as the first vertex in the MST.
         *  Compare the edges going out from the MST. Choose the edge with the lowest weight that connects a vertex among the MST vertices to a vertex outside the MST.
         *  Add that edge and vertex to the MST.
         *  Keep doing step 2 and 3 until all vertices belong to the MST.
         * Note: Since the starting vertex is chosen at random, it is possible to have different edges included in the MST for the same graph, but the total edge weight of the MST will still have the same minimum value.
         */
        public void primsAlgorithm() {
            edgeValues[0] = 0;

            System.out.println("Edge \tWeight");
            for (int count = 0; count < size; count++) {
                int u = -1;
                int min = Integer.MAX_VALUE;

                for (int v = 0; v < size; v++) {
                    if (!inMST[v] && edgeValues[v] < min) {
                        min = edgeValues[v];
                        u = v;
                    }
                }

                if (u == -1) {
                    System.out.println("Graph is disconnected, MST not complete.");
                    break;
                }

                inMST[u] = true;

                if (parents[u] != -1) {
                    System.out.println(vertexData[parents[u]] + "-" + vertexData[u] + " \t" + adjMatrix[u][parents[u]]);
                }

                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && !inMST[v] && adjMatrix[u][v] < edgeValues[v]) {
                        parents[v] = u;
                        edgeValues[v] = adjMatrix[u][v];
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");
        g.addVertexData(6, "G");
        g.addVertexData(7, "H");

        g.addEdge(0, 1, 4); // A - B
        g.addEdge(0, 3, 3); // A - D
        g.addEdge(1, 2, 3); // B - C
        g.addEdge(1, 3, 5); // B - D
        g.addEdge(1, 4, 6); // B - E
        g.addEdge(2, 4, 4); // C - E
        g.addEdge(2, 7, 2); // C - H
        g.addEdge(3, 4, 7); // D - E
        g.addEdge(3, 5, 4); // D - F
        g.addEdge(4, 5, 5); // E - F
        g.addEdge(4, 6, 3); // E - G
        g.addEdge(5, 6, 7); // F - G
        g.addEdge(6, 7, 5); // G - H

        System.out.println("\nPrim's Algorithm MST:");
        g.primsAlgorithm();
    }
}
