package util.graph;

import java.util.Set;

public interface DirectedGraph<V, E> {
    public void addVertex(Vertex<V> n);

    public void addEdge(Edge<V, E> e);

    public Set<Vertex<V>> vertexs();

    public Set<Edge<V, E>> edges();

    public Set<Vertex<V>> getNeighbors(Vertex<V> v);

    public Set<Edge<V, E>> getIncidence(Vertex<V> v);

    public class Edge<V, E> {
        Vertex<V> source;
        Vertex<V> destination;
        E value;

        public Edge(Vertex<V> s, Vertex<V> d, E value) {
            this.source = s;
            this.destination = d;
            this.value = value;
        }
    }

    public class Vertex<V> {
        V value;

        public Vertex(V value) {
            this.value = value;
        }
    }

}
