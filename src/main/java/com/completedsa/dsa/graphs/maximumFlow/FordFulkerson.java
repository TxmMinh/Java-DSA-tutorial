package com.completedsa.dsa.graphs.maximumFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * The Ford-Fulkerson algorithm solves the maximum flow problem for a directed graph.
 * Algorithm works by looking for a path with available capacity from the source to the sink (called an augmented path), and then sends as much flow as possible through that path.
 * Algorithm use Depth-First-Search to find the paths.
 */
public class FordFulkerson {
    static class Graph {
        private int[][] adjMatrix;
        private String[] vertexData;
        private int size;

        public Graph(int size) {
            this.size = size;
            this.adjMatrix = new int[size][size];
            this.vertexData = new String[size];
        }

        public void addEdge(int u, int v, int capacity) {
            adjMatrix[u][v] = capacity;
        }

        public void addVertexData(int vertex, String data) {
            vertexData[vertex] = data;
        }

        private List<Integer> dfs(int s, int t, boolean[] visited) {
            if (s == t) {
                List<Integer> path = new ArrayList<>();
                path.add(s);
                return path;
            }

            visited[s] = true;

            for (int v = 0; v < size; v++) {
                if (!visited[v] && adjMatrix[s][v] > 0) {
                    List<Integer> subPath = dfs(v, t, visited);
                    if (subPath != null) {
                        subPath.add(0, s);
                        return subPath;
                    }
                }
            }

            return null;
        }

        /**
         * How it works:
         *  Start with zero flow on all edges.
         *  Find an augmented path where more flow can be sent.
         *  Do a bottleneck calculation to find out how much flow can be sent through that augmented path.
         *  Increase the flow found from the bottleneck calculation for each edge in the augmented path.
         *  Repeat steps 2-4 until max flow is found. This happens when a new augmented path can no longer be found.
         */
        public int fordFulkerson(int source, int sink) {
            int maxFlow = 0;
            List<Integer> path;

            while((path = dfs(source, sink, new boolean[size])) != null) {
                int pathFlow = Integer.MAX_VALUE;
                for (int i = 0; i < path.size() - 1; i++) {
                    int u = path.get(i);
                    int v = path.get(i + 1);
                    pathFlow = Math.min(pathFlow, adjMatrix[u][v]);
                }

                for (int i = 0; i < path.size() - 1; i++) {
                    int u = path.get(i);
                    int v = path.get(i + 1);
                    adjMatrix[u][v] -= pathFlow; // residual capacity
                    adjMatrix[v][u] += pathFlow; // reversed edge
                }

                maxFlow += pathFlow;

                // Convert path from vertex indices to names
                List<String> pathNames = new ArrayList<>();
                for (int vertex : path) {
                    pathNames.add(vertexData[vertex]);
                }
                System.out.println("Path: " + String.join(" -> ", pathNames) + ", Flow: " + pathFlow);
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
        int maxFlow = g.fordFulkerson(source, sink);

        System.out.println("The maximum possible flow is " + maxFlow);
    }
}
