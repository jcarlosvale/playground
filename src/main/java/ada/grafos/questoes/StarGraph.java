package ada.grafos.questoes;

import ada.grafos.Graph;
import ada.grafos.GraphAdjacencyList;

public class StarGraph {
    public static int findCenter(int[][] edges) {
        GraphAdjacencyList graph = new GraphAdjacencyList(edges.length + 2);
        for(int[] edge: edges) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }
//        boolean found = false;
//        for(int i = 1; i < graph.adjacencyList.length; i++) {
//            found = true;
//            for(int j = 1; j < graph.adjacencyList.length; j++) {
//                if (i != j) {
//                    if (!graph.adjacencyList[i][j]) {
//                        found = false;
//                        continue;
//                    }
//                }
//            }
//            if (found) return i;
//        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}})); // Output: 2
    }
}
