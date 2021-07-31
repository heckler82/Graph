package com.foley.graph.path;

import com.foley.graph.core.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides the basic functions of a pathfinder, but no pathfinding logic
 *
 * @param <V> the type of objects to navigate
 * @param <E> the type of cost connecting the objects
 */
public abstract class AbstractPathfinder<V, E> implements Pathfinder<V, E> {
    private Map<V, PathfindingNode<V, E>> pfg;
    private Graph<V, E> g;

    /**
     * Creates a new abstract pathfinder instance
     *
     * @param g
     */
    public AbstractPathfinder(Graph<V, E> g) {
        // Error check
        if(g == null || g.isEmpty()) {
            throw new IllegalArgumentException("cannot build a pathfinder for a null or empty graph");
        }
        this.g = g;
        // Fill map
        pfg = new HashMap<>();
        for(V v : g.getVertices()) {
            pfg.put(v, new PathfindingNode(v));
        }
        // Set up edges here
        for(var e : g.getAllEdges()) {
            pfg.get(e.getSource()).addNeighbor(pfg.get(e.getDestination()));
        }
    }

    public boolean findPath(V start, V end) {
        if(start == null) {
            throw new IllegalArgumentException("starting node cannot be null for pathfinding");
        }
        // Start initial pathfinding
        return false;
    }

    public List<V> getPathFrom(V start, V end) {
        if(start == null || end == null) {
            throw new IllegalArgumentException("both nodes must be non-null to get a path between them");
        }
        return List.of();
    }

    public E getPathCost(V start, V end) {
        if(start == null || end == null) {
            throw new IllegalArgumentException("both nodes must be non-null to get a path cost");
        }

        return null;
    }
}
