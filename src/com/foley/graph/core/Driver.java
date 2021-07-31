package com.foley.graph.core;

import java.util.Random;

/**
 * Runs tests on graphs
 */
public class Driver {
    /**
     * Main entry-point for the program
     *
     * @param args CLI arguments passed to the program
     */
    public static void main(String[] args) {
        Graph<Integer, Integer> g = new BasicHashGraph<>();
        System.out.println("Basic Graph");
        naiveProfile(g, 1000, 200, 46);
        g = new BasicHashGraph<>();
        System.out.println("Basic Hash Graph");
        naiveProfile(g, 1000, 200, 46);
        GraphPrinter.printGraph(g);
    }

    /**
     * Gets a naive benchmark running operations on a graph
     *
     * @param g the graph to benchmark
     * @param cycles how many times to benchmark
     * @param numVertices the number of vertices to add into the graph
     * @param numEdges the number of edges to create
     */
    private static void naiveProfile(Graph<Integer, Integer> g, int cycles, int numVertices, int numEdges) {
        long start = System.nanoTime();
        for(int i = 0; i < cycles; i++) {
            g.clear();
            for(int j = 0; j < numVertices; j++) {
                g.addVertex(j);
            }
            Random rand = new Random();
            for(int w = 0; w < numEdges; w++) {
                g.addEdge(rand.nextInt(numVertices), rand.nextInt(numVertices), rand.nextInt(500));
            }
        }
        start = System.nanoTime() - start;
        System.out.printf("Total time taken: %fms\n", start / 1000.0 / 1000.0);
    }
}
