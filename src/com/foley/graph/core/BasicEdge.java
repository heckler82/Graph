package com.foley.graph.core;

import java.util.Objects;

/**
 * A basic {@code Edge} implementation that relates two vertices together
 *
 * @param <V> the type of source and destination vertices
 * @param <E> the type of cost to travel on the edge
 */
public class BasicEdge<V, E> implements Edge<V, E>{
    private V source;
    private V destination;
    private E cost;

    /**
     * Creates a new edge between source and destination worth cost
     *
     * @param source the source vertex
     * @param destination the destination vertex
     * @param cost the cost to travel the edge
     */
    private BasicEdge(V source, V destination, E cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    /**
     * Gets the source vertex
     *
     * @return the source vertex
     */
    public V getSource() {
        return source;
    }

    /**
     * Gets the destination vertex
     *
     * @return the destination vertex
     */
    public V getDestination() {
        return destination;
    }

    /**
     * Gets the cost to travel along the edge
     *
     * @return the cost to travel along the edge
     */
    public E getCost() {
        return cost;
    }

    @Override
    /**
     * Returns the hash code of the edge
     *
     * @return the hash code of the edge
     */
    public int hashCode() {
        return Objects.hash(source, destination, cost);
    }

    /**
     * Builds a new edge between two vertices with the specified cost
     *
     * @param source the source vertex
     * @param destination the destination vertex
     * @param cost the cost to travel along the edge
     * @param <V> the type of source and destination vertices
     * @param <E> the type of cost to travel along the edge
     * @return an edge connecting {@code source} and {@code destination} that takes {@code cost} to travel on
     */
    public static <V, E> Edge<V, E> buildEdge(V source, V destination, E cost) {
        if(source == null) {
            throw new IllegalArgumentException("source vertex cannot be null");
        }
        if(destination == null) {
            throw new IllegalArgumentException("destination vertex cannot be null");
        }
        return new BasicEdge(source, destination, cost);
    }
}