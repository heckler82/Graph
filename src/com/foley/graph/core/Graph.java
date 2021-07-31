package com.foley.graph.core;

import java.util.Set;

/**
 * An abstract, unordered collection of vertices and the edges relating them
 *
 * @param <V> The type of vertices in the graph
 * @param <E> The type of cost between vertices in the graph
 */
public interface Graph<V, E> {
    /**
     * Clears all vertices and edges from the graph
     */
    void clear();

    /**
     * Returns {@code true} if the graph contains the vertex {@code v}
     *
     * @param v the vertex to check
     * @return {@code true} if the graph contains the vertex {@code v}
     */
    boolean contains(V v);

    /**
     * Returns {@code true} if the graph has no vertices
     *
     * @return {@code true} if the graph has no vertices
     */
    boolean isEmpty();

    /**
     * The number of vertices in the graph
     *
     * @return the number of vertices in the graph
     */
    int size();

    /**
     * Adds a vertex {@code v} to the graph
     *
     * @param v the vertex to add
     * @return {@code true} if the vertex was successfully added to the graph
     */
    boolean addVertex(V v);

    /**
     * Adds an edge to the graph between vertices {@code v1} and {@code v2} with a cost of {@code cost}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if the edge was successfully added to the graph
     */
    boolean addEdge(V v1, V v2, E cost);

    /**
     * Returns {@code true} if the graph contains the vertex {@code v}
     *
     * @param v the vertex to check
     * @return {@code true} if the graph contains vertex {@code v}
     */
    boolean containsVertex(V v);

    /**
     * Removes a vertex {@code v} from the graph
     *
     * @param v the vertex to remove
     * @return {@code true} if the vertex was successfully removed from the graph
     */
    boolean removeVertex(V v);

    /**
     * Removes an edge from the graph between vertices {@code v1} and {@code v2} and a weight of {@code cost}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if the edge was successfully removed from the graph
     */
    boolean removeEdge(V v1, V v2, E cost);

    /**
     * Returns the cost for traveling along the edge connecting source vertex {@code v1} and destination vertex {@code v2}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return the cost to travel along the edge connecting {@code v1} and {@code v2}
     */
    E getEdgeCost(V v1, V v2);

    /**
     * Returns {@code true} if an edge exists in the graph between source vertex {@code v1} and destination vertex {@code v2}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return {@code true} if an edge exists between the two nodes in the graph
     */
    boolean areAdjacent(V v1, V v2);

    /**
     * Returns a set of vertices from the graph that are adjacent to vertex {@code v}
     *
     * @param v the source vertex
     * @return a set of vertices adjacent to {@code v}
     */
    Set<V> getAdjacent(V v);

    /**
     * Returns a set with all of the vertices in the graph contained within it
     *
     * @return a set with all of the vertices in the graph contained within it
     */
    Set<V> getVertices();

    /**
     * Returns a set with all the edges originating from source vertex {@code v}
     *
     * @param v the source vertex
     * @return a set with all the edges originating from source vertex {@code v}
     */
    Set<Edge<V, E>> getEdges(V v);

    /**
     * Returns a set with all of the edges in the graph
     *
     * @return a set with all the edges in the graph
     */
    Set<Edge<V, E>> getAllEdges();
}
