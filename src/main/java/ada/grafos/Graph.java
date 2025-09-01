package ada.grafos;

import java.util.List;

public class Graph {
    public int vertices;
    public int edges;
    public boolean [][] adjacencyList;

    public Graph(int vertices) {
        this.vertices  = vertices;
        this.edges = 0;
        this.adjacencyList = new boolean[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        this.adjacencyList[u][v] = true;
        this.edges++;
    }
}
