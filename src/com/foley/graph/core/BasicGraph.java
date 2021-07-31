package com.foley.graph.core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Provides a basic implementation of a graph. Uses a Set as the backing data structure for edges
 *
 * @param <V> The type of vertices in the graph
 * @param <E> The type of cost between vertices in the graph
 */
public class BasicGraph<V, E> extends AbstractGraph<V, E> implements Graph<V, E> {
    private Set<Edge<V, E>> edges;

    /**
     * Creates a new basic graph
     */
    public BasicGraph() {
        super();
        edges = new HashSet<>();
    }

    @Override
    /**
     * Clears all vertices and edges from the graph
     */
    public void clear() {
        getVertices().clear();
        edges.clear();
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
        if(v1 == null || v2 == null || cost == null) {
            throw new IllegalArgumentException("Cannot add an edge for a null vertex or cost");
        }
        if(!getVertices().contains(v1) || !getVertices().contains(v2)) {
            throw new IllegalArgumentException("Both vertices must be in the graph to add an edge");
        }
        var edge = BasicEdge.buildEdge(v1, v2, cost);
        return edges.add(edge);
    }

    @Override
    /**
     * Removes a vertex {@code v} from the graph. This operation will remove all edges associated with this vertex
     *
     * @param v the vertex to remove
     * @return {@code true} if the vertex was successfully removed from the graph
     */
    public boolean removeVertex(V v) {
        var adjacent = getAdjacent(v);
        boolean b = getVertices().remove(v);
        if(b) {
            for(V adj : adjacent) {
                E cost = getEdgeCost(v, adj);
                edges.remove(BasicEdge.buildEdge(v, adj, cost));
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
        if(v1 == null || v2 == null || cost == null) {
            throw new IllegalArgumentException("cannot remove edge of null vertex or cost");
        }
        edges.remove(BasicEdge.buildEdge(v1, v2, cost));
        return false;
    }

    /**
     * Returns the cost for traveling along the edge connecting source vertex {@code v1} and destination vertex {@code v2}.
     * Returns null if there is no edge between the two vertices
     *
     * @param v1 the source vertex
     * @param v2 the destination vertex
     * @return the cost to travel along the edge connecting {@code v1} and {@code v2}
     */
    public E getEdgeCost(V v1, V v2) {
        if(areAdjacent(v1, v2)) {
            for(var e : edges) {
                if(e.getSource() == v1 && e.getDestination() == v2) {
                    return e.getCost();
                }
            }
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
        if(!getVertices().contains(v1) || !getVertices().contains(v2)) {
            return false;
        }
        for(Edge e : edges) {
            if(e.getSource().equals(v1) && e.getDestination().equals(v2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a set of vertices from the graph that are adjacent to vertex {@code v}
     *
     * @param v the source vertex
     * @return a set of vertices adjacent to {@code v}
     */
    public Set<V> getAdjacent(V v) {
        var adjacent = new HashSet<V>();
        for(V adj : getVertices()) {
            if(areAdjacent(v, adj)) {
                adjacent.add(adj);
            }
        }
        return adjacent;
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
        var edgeMap = new HashSet<Edge<V, E>>();
        for(var e : edges) {
            if(e.getSource() == v) {
                edgeMap.add(e);
            }
        }
        return edgeMap;
    }

    @Override
    /**
     * Returns a set with all of the edges in the graph
     *
     * @return a set with all the edges in the graph
     */
    public Set<Edge<V, E>> getAllEdges() {
        return edges;
    }
}
