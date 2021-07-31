package com.foley.graph.path;

import java.util.ArrayList;
import java.util.List;

/**
 * A container for pathfinding data between vertices of a graph
 *
 * @param <V> the type of data stored in a graph
 * @param <E> the type of weight to travel between data
 */
public class PathfindingNode<V, E> {
    private V v;
    private List<PathfindingNode<V, E>> neighbors;

    /**
     * Creates a new pathfinding node
     *
     * @param v the graph vertex this node represents
     */
    public PathfindingNode(V v) {
        this.v = v;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(PathfindingNode<V, E> pfn) {
        neighbors.add(pfn);
    }

    public List<PathfindingNode<V,E>> getNeighbors() {
        return neighbors;
    }
}
