package ada.grafos;

import java.util.List;

public class GraphPonderado {
    private int vertices;
    private int edges;
    private List<List<WeighEdge>> adjacencyList;

    public GraphPonderado(int vertices) {
        this.vertices  = vertices;
        this.edges = 0;
        this.adjacencyList = List.of(new List[vertices]);
    }

    public void addEdge(int u, int v, int w) {
        this.adjacencyList.get(u).add(new WeighEdge(v, w));
        this.edges++;
    }
}

record WeighEdge(int vertex, int weight) {}
