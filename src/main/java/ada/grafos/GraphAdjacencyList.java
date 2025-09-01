package ada.grafos;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {
    private int vertices;
    private int edges;
    public List<List<Integer>> adjacencyList;

    public GraphAdjacencyList(int vertices) {
        this.vertices  = vertices;
        this.edges = 0;
        this.adjacencyList = new ArrayList();
        for(int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        this.adjacencyList.get(v).add(w);
        this.edges++;
    }
}
