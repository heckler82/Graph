package com.foley.graph.core;

import java.util.*;

/**
 * A basic implementation of a graph that uses a hash map as the backing data structure for the edges connecting vertices.
 * This implementation does not allow for multiple edges of differing cost between vertices
 *
 * @param <V> The type of vertices in the graph
 * @param <E> The type of cost between vertices in the graph
 */
public class BasicHashGraph<V, E> extends AbstractGraph<V, E> implements Graph<V, E> {
    private Map<V, Map<V, E>> edgeMap;

    /**
     * Creates a new basic hash graph
     */
    public BasicHashGraph() {
        super();
        edgeMap = new HashMap<>();
    }

    @Override
    /**
     * Clears all vertices and edges from the graph
     */
    public void clear() {
        getVertices().clear();
        edgeMap.clear();
    }

    @Override
    /**
     * Adds a vertex {@code v} to the graph
     *
     * @param v the vertex to add
     * @return {@code true} if the vertex was successfully added to the graph
     */
    public boolean addVertex(V v) {
        boolean b = super.addVertex(v);
        if(b) {
            edgeMap.put(v, new HashMap<>());
        }
        return b;
    }

    @Override
    /**
     * Adds an edge to the graph between vertices {@code v1} and {@code v2} with a cost of {@code cost}. Vertices that are
     * already connected to each other will have the old cost overwritten if {@code addEdge(V, V, double)} is called with
     * a cost that is different from the old cost
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if the edge was successfully added to the graph
     */
    public boolean addEdge(V v1, V v2, E cost) {
        if(v1 == null || v2 == null || cost == null) {
            throw new IllegalArgumentException("Cannot add an edge for a null vertex or cost");
        }
        if(!containsVertex(v1) || !containsVertex(v2)) {
            throw new IllegalArgumentException("Both vertices must be in the graph to add an edge");
        }
        var vEdges = edgeMap.get(v1);
        if(cost == vEdges.getOrDefault(v2, null)) {
            return false;
        }
        vEdges.put(v2, cost);
        return true;
    }

    @Override
    /**
     * Removes a vertex {@code v} from the graph. This operation will remove all edges associated with this vertex
     *
     * @param v the vertex to remove
     * @return {@code true} if the vertex was successfully removed from the graph
     */
    public boolean removeVertex(V v) {
        boolean b = getVertices().remove(v);
        if(b) {
            edgeMap.remove(v);
            for(V vAdjacent : edgeMap.keySet()) {
                edgeMap.get(vAdjacent).remove(v);
            }
        }
        return b;
    }

    @Override
    /**
     * Removes an edge from the graph between source vertex {@code v1}, destination vertex {@code v2}, and a weight of {@code cost}
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @param cost the cost to travel along the edge
     * @return {@code true} if the edge was successfully removed from the graph
     */
    public boolean removeEdge(V v1, V v2, E cost) {
        if(areAdjacent(v1, v2)) {
            edgeMap.get(v1).remove(v2);
            return true;
        }
        return false;
    }

    /**
     * Returns the cost for traveling along the edge connecting source vertex {@code v1} and destination vertex {@code v2}.
     * Returns null if there is no existing edge connecting the two vertices in the graph
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return the cost to travel along the edge connecting {@code v1} and {@code v2}
     */
    public E getEdgeCost(V v1, V v2) {
        if(areAdjacent(v1, v2)) {
            return edgeMap.get(v1).get(v2);
        }
        return null;
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
        if(v1 == null || v2 == null) {
            return false;
        }
        if(!edgeMap.containsKey(v1) || !edgeMap.containsKey(v2)) {
            return false;
        }
        return edgeMap.get(v1).containsKey(v2);
    }

    /**
     * Returns a set of vertices from the graph that are adjacent to vertex {@code v}
     *
     * @param v the source vertex
     * @return a set of vertices adjacent to {@code v}
     */
    public Set<V> getAdjacent(V v) {
        if(edgeMap.containsKey(v)) {
            return edgeMap.get(v).keySet();
        }
        return null;
    }

    @Override
    /**
     * Returns a set with all the edges originating from source vertex {@code v}
     *
     * @param v the source vertex
     * @return a set with all the edges originating from source vertex {@code v}
     */
    public Set<Edge<V, E>> getEdges(V v) {
        if(v == null) {
            throw new IllegalArgumentException("cannot get edges for a null vertex");
        }
        if(!containsVertex(v)) {
            return Collections.emptySet();
        }
        var edges = new HashSet<Edge<V, E>>();
        for(V adj : edgeMap.get(v).keySet()) {
            edges.add(BasicEdge.buildEdge(v, adj, edgeMap.get(v).get(adj)));
        }
        return edges;
    }

    @Override
    /**
     * Returns a set with all of the edges in the graph
     *
     * @return a set with all the edges in the graph
     */
    public Set<Edge<V, E>> getAllEdges() {
        if(isEmpty()) {
            return Collections.emptySet();
        }
        var edges = new HashSet<Edge<V, E>>();
        for(V v : getVertices()) {
            edges.addAll(getEdges(v));
        }
        return edges;
    }
}
