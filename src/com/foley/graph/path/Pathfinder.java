package com.foley.graph.path;

import java.util.List;

/**
 * Abstract template for pathfinding
 *
 * @param <V> the type of objects to navigate
 * @param <E> the type of cost connecting the objects
 */
public interface Pathfinder<V, E> {
    /**
     * Attempts to find a path between {@code start} and {@code end}
     *
     * @param start the starting node
     * @param end the ending node
     * @return {@code true} if a path was found between the two nodes
     */
    boolean findPath(V start, V end);

    /**
     * Gets the ordered path of nodes between {@code start} and {@code end}
     *
     * @param start the starting node
     * @param end the ending node
     * @return the path of nodes between {@code start} and {@code end}
     */
    List<V> getPathFrom(V start, V end);

    /**
     * Gets the cost of the path between {@code start} and {@code end}
     *
     * @param start the starting node
     * @param end the ending node
     * @return the cost of the path between {@code start} and {@code end}
     */
    E getPathCost(V start, V end);
}
