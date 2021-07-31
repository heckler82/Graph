package com.foley.graph.core;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a skeletal impmlementation of the {@code Graph} interface. It provides a backing {@code Set} for
 * storing the vertices belonging to the graph
 *
 * @param <V> The type of vertices in the graph
 * @param <E> The type of cost between vertices in the graph
 */
public abstract class AbstractGraph<V, E> implements Graph<V, E> {
    private Set<V> vertices;

    /**
     * Creates a new abstract graph instance
     */
    public AbstractGraph() {
        vertices = new HashSet<>();
    }

    @Override
    /**
     * Clears all vertices and edges from the graph
     */
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * Returns {@code true} if the graph contains the vertex {@code v}
     *
     * @param v the vertex to check
     * @return {@code true} if the graph contains the vertex {@code v}
     */
    public boolean contains(V v) {
        return vertices.contains(v);
    }

    @Override
    /**
     * Returns {@code true} if the graph has no vertices
     *
     * @return {@code true} if the graph has no vertices
     */
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    @Override
    /**
     * The number of vertices in the graph
     *
     * @return the number of vertices in the graph
     */
    public int size() {
        return vertices.size();
    }

    @Override
    /**
     * Adds a vertex {@code v} to the graph
     *
     * @param v the vertex to add
     * @return {@code true} if the vertex was successfully added to the graph
     */
    public boolean addVertex(V v) {
        return vertices.add(v);
    }

    @Override
    /**
     * Adds an edge to the graph between vertices {@code v1} and {@code v2} with a cost of {@code cost}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if th edge was successfully added to the graph
     */
    public boolean addEdge(V v1, V v2, E cost) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * Returns {@code true} if the graph contains the vertex {@code v}
     *
     * @param v the vertex to check
     * @return {@code true} if the graph contains vertex {@code v}
     */
    public boolean containsVertex(V v) {
        return vertices.contains(v);
    }

    @Override
    /**
     * Removes a vertex {@code v} from the graph
     *
     * @param v the vertex to remove
     * @return {@code true} if the vertex was successfully removed from the graph
     */
    public boolean removeVertex(V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * Removes an edge from the graph between vertices {@code v1} and {@code v2} and a weight of {@code cost}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if the edge was successfully removed from the graph
     */
    public boolean removeEdge(V v1, V v2, E cost) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the cost for traveling along the edge connecting source vertex {@code v1} and destination vertex {@code v2}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return the cost to travel along the edge connecting {@code v1} and {@code v2}
     */
    public E getEdgeCost(V v1, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override
    /**
     * Returns {@code true} if an edge exists in the graph between source vertex {@code v1} and destination vertex {@code v2}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return {@code true} if an edge exists between the two nodes in the graph
     */
    public boolean areAdjacent(V v1, V v2) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a set of vertices from the graph that are adjacent to vertex {@code v}
     *
     * @param v the source vertex
     * @return a set of vertices adjacent to {@code v}
     */
    public Set<V> getAdjacent(V v) {
       throw new UnsupportedOperationException();
    }

    @Override
    /**
     * Returns a set with all of the vertices in the graph contained within it
     *
     * @return a set with all of the vertices in the graph contained within it
     */
    public Set<V> getVertices() {
        return vertices;
    }
}
