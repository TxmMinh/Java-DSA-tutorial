package com.completedsa.dsa.graphs.maximumFlow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Edmonds-Karp algorithm solves the maximum flow problem for a directed graph.
 * Algorithm uses Breadth First Search (BFS) to find augmented paths to increase flow.
 */
public class EdmondsKarp {
    static class Graph {
        private int size;
        private int[][] adjMatrix;
        private String[] vertexData;

        public Graph(int size) {
            this.size = size;
            adjMatrix = new int[size][size];
            vertexData = new String[size];
        }

        public void addEdge(int u, int v, int capacity) {
            adjMatrix[u][v] = capacity;
        }

        public void addVertexData(int vertex, String data) {
            vertexData[vertex] = data;
        }

        private boolean bfs(int s, int t, int[] parent) {
            boolean[] visited = new boolean[size];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            visited[s] = true;
            parent[s] = -1;

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v = 0; v < size; v++) {
                    if (!visited[v] && adjMatrix[u][v] > 0) {
                        queue.add(v);
                        parent[v] = u;
                        visited[v] = true;
                    }
                }
            }

            return visited[t];
        }

        /**
         * How it works:
         *  Start with zero flow on all edges.
         *  Use BFS to find an augmented path where more flow can be sent.
         *  Do a bottleneck calculation to find out how much flow can be sent through that augmented path.
         *  Increase the flow found from the bottleneck calculation for each edge in the augmented path.
         *  Repeat steps 2-4 until max flow is found. This happens when a new augmented path can no longer be found.
         */
        public int edmondsKarp(int source, int sink) {
            int u, v;
            int[] parent = new int[size];
            int maxFlow = 0;

            while (bfs(source, sink, parent)) {
                int pathFlow = Integer.MAX_VALUE;
                for (v = sink; v != source; v = parent[v]) {
                    u = parent[v];
                    pathFlow = Math.min(pathFlow, adjMatrix[u][v]);
                }

                for (v = sink; v != source; v = parent[v]) {
                    u = parent[v];
                    adjMatrix[u][v] -= pathFlow;
                    adjMatrix[v][u] += pathFlow;
                }

                maxFlow += pathFlow;

                // Printing the path
                LinkedList<String> path = new LinkedList<>();
                for (v = sink; v != source; v = parent[v]) {
                    path.addFirst(vertexData[v]);
                }

                path.addFirst(vertexData[source]);
                System.out.println("Path: " + String.join(" -> ", path) + ", Flow: " + pathFlow);
            }

            return maxFlow;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        String[] vertexNames = {"s", "v1", "v2", "v3", "v4", "t"};
        for (int i = 0; i < vertexNames.length; i++) {
            g.addVertexData(i, vertexNames[i]);
        }

        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 7);
        g.addEdge(1, 3, 3);
        g.addEdge(1, 4, 4);
        g.addEdge(2, 1, 5);
        g.addEdge(2, 4, 3);
        g.addEdge(3, 4, 3);
        g.addEdge(3, 5, 2);
        g.addEdge(4, 5, 6);

        int source = 0, sink = 5;
        System.out.println("The maximum possible flow is " + g.edmondsKarp(source, sink));
    }
}
