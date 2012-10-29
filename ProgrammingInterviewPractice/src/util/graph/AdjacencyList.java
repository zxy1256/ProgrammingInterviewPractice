package util.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AdjacencyList<V, E> implements DirectedGraph<V, E> {
    Map<Vertex<V>, Set<Edge<V, E>>> adjacencyList;

    public AdjacencyList() {
        adjacencyList = new HashMap<Vertex<V>, Set<Edge<V, E>>>();
    }

    @Override
    public void addVertex(Vertex<V> v) {
        if (adjacencyList.containsKey(v)) {
            return;
        }
        adjacencyList.put(v, new HashSet<Edge<V, E>>());
    }

    @Override
    public void addEdge(Edge<V, E> e) {
        Vertex<V> source = e.source;
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        Vertex<V> desti = e.destination;
        if (!adjacencyList.containsKey(desti)) {
            addVertex(desti);
        }
        Set<Edge<V, E>> incidences = adjacencyList.get(source);
        if (incidences == null) {
            incidences = new HashSet<Edge<V, E>>();
        }
        incidences.add(e);
        adjacencyList.put(source, incidences);
    }

    @Override
    public Set<Vertex<V>> vertexs() {
        return adjacencyList.keySet();
    }

    @Override
    public Set<Edge<V, E>> edges() {
        Set<Edge<V, E>> edges = new HashSet<Edge<V, E>>();
        for (Vertex<V> v : adjacencyList.keySet()) {
            edges.addAll(adjacencyList.get(v));
        }
        return edges;
    }

    @Override
    public Set<Vertex<V>> getNeighbors(Vertex<V> v) {
        Set<Vertex<V>> neighbors = new TreeSet<Vertex<V>>();
        for (Edge<V, E> e : getIncidence(v)) {
            neighbors.add(e.destination);
        }
        return neighbors;
    }

    @Override
    public Set<Edge<V, E>> getIncidence(Vertex<V> v) {
        return adjacencyList.get(v);
    }
}
