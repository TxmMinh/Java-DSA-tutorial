package com.completedsa.dsa.graphs.minimumSpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kruskal's algorithm finds the Minimum Spanning Tree (MST), or Minimum Spanning Forest, in an undirected graph.
 * The MST found by Kruskal's algorithm is the collection of edges that connect all vertices (or as many as possible) with the minimum total edge weight.
 */
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    static class Graph {
        int V;
        List<Edge> edges;
        String[] vertexNames;

        public Graph(int v) {
            V = v;
            edges = new ArrayList<>();
            vertexNames = new String[V];
        }

        public void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge();
            edge.src = src;
            edge.dest = dest;
            edge.weight = weight;
            edges.add(edge);
        }

        public void addVertexName(int vertex, String name) {
            vertexNames[vertex] = name;
        }

        private int findRoot(Subset[] subsets, int i) {
            if (subsets[i].parent != i) {
                subsets[i].parent = findRoot(subsets, subsets[i].parent);
            }

            return subsets[i].parent;
        }

        public void union(Subset[] subsets, int x, int y) {
            int xRoot = findRoot(subsets, x);
            int yRoot = findRoot(subsets, y);

            if (subsets[xRoot].rank < subsets[yRoot].rank) {
                subsets[xRoot].parent = yRoot;
            } else if (subsets[xRoot].rank > subsets[yRoot].rank) {
                subsets[yRoot].parent = xRoot;
            } else {
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        /**
         * How it works:
         *  Sort the edges in the graph from the lowest to the highest edge weight.
         *  For each edge, starting with the one with the lowest edge weight:
         *      Will this edge create a cycle in the current MST?
         *          If no: Add the edge as an MST edge.
         */
        public void KruskalMST() {
            ArrayList<Edge> result = new ArrayList<>();
            Collections.sort(edges);

            Subset[] subsets = new Subset[V];
            for (int i = 0; i < V; i++) {
                subsets[i] = new Subset();
                subsets[i].parent = i;
                subsets[i].rank = 0;
            }

            int i = 0;

            while (i < edges.size()) {
                Edge nextEdge = edges.get(i++);
                int x = findRoot(subsets, nextEdge.src);
                int y = findRoot(subsets, nextEdge.dest);

                if (x != y) {
                    result.add(nextEdge);
                    union(subsets, x, y);
                }
            }

            System.out.println("Edge \tWeight");
            for (Edge e : result)
                System.out.println(vertexNames[e.src] + "-" + vertexNames[e.dest] + " \t" + e.weight);
        }
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices in graph
        Graph graph = new Graph(V);

        // add edges
        graph.addEdge(0, 1, 4);  // A-B, weight  4
        graph.addEdge(0, 6, 10); // A-G, weight 10
        graph.addEdge(0, 2, 9);  // A-C, weight  9
        graph.addEdge(1, 2, 8);  // B-C, weight  8
        graph.addEdge(2, 3, 5);  // C-D, weight  5
        graph.addEdge(2, 4, 2);  // C-E, weight  2
        graph.addEdge(2, 6, 7);  // C-G, weight  7
        graph.addEdge(3, 4, 3);  // D-E, weight  3
        graph.addEdge(3, 5, 7);  // D-F, weight  7
        graph.addEdge(4, 6, 6);  // E-G, weight  6
        graph.addEdge(5, 6, 11); // F-G, weight 11

        // adding names
        graph.addVertexName(0, "A");
        graph.addVertexName(1, "B");
        graph.addVertexName(2, "C");
        graph.addVertexName(3, "D");
        graph.addVertexName(4, "E");
        graph.addVertexName(5, "F");
        graph.addVertexName(6, "G");

        System.out.println("Kruskal's Algorithm MST:");
        graph.KruskalMST();
    }
}
