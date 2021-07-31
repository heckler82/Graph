package com.foley.graph.core;

/**
 * Provides methods for printing graphs
 */
public class GraphPrinter {
    /**
     * Prints a text representation of a graph
     *
     * @param g the graph to print
     */
    public static void printGraph(Graph g) {
        StringBuilder sb = new StringBuilder();
        sb.append("========== Graph Visualizer ==========\n");
        sb.append("(V):\t|\t(E):\n");
        for(Object o : g.getVertices()) {
            sb.append(o.toString() + "\t\t|\t");
            StringBuilder adjBuilder = new StringBuilder();
            for(Object adj : g.getAdjacent(o)) {
                if(adjBuilder.length() > 0) {
                    adjBuilder.append(", ");
                }
                adjBuilder.append(adj.toString());
                adjBuilder.append("(" + g.getEdgeCost(o, adj) + ")");
            }
            sb.append(adjBuilder.toString() + "\n");
        }
        System.out.println(sb.toString());
    }
}
