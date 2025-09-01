package ada.grafos.questoes;

import ada.grafos.Graph;
import ada.grafos.GraphAdjacencyList;

public class FindJudge {
    public int findJudge(int n, int[][] trust) {
        GraphAdjacencyList graph = new GraphAdjacencyList(n+1);
        for(int[] t : trust) {
            graph.addEdge(t[0], t[1]);
        }
        //find the person who does not trust anyone
        for(int i = 1; i <= n; i++) {
            if(graph.adjacencyList.get(i).size() == 0) {
                //check if this person is trusted by everyone else
                boolean isJudge = true;
                for(int j = 1; j <= n; j++) {
                    if(i != j && !graph.adjacencyList.get(j).contains(i)) {
                        isJudge = false;
                        break;
                    }
                }
                if(isJudge) {
                    return i; //found the judge
                }
            }
        }
        return -1; //no judge found
    }
}
