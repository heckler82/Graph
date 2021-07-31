package com.foley.graph.core;

/**
 * An abstract, weighted relationship between two pieces of data
 *
 * @param <V> the type of data that is related
 * @param <E> the type of weight that relates the data
 */
public interface Edge<V, E> {
    /**
     * Gets the source of the edge
     *
     * @return the source of the edge
     */
    V getSource();

    /**
     * Gets the destination of the edge
     *
     * @return the destination of the edge
     */
    V getDestination();

    /**
     * Gets the weight to travel along the edge
     *
     * @return the weight to travel along the edge
     */
    E getCost();
}
