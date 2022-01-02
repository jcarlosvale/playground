package tests.facebook;

class ScoreboardInference {
  
  public int getMinProblemCount(int N, int[] S) {
    boolean hasOdd = false;
    int max = 0;
    for(int i: S){
      max = Math.max(max, i);
      if (i % 2 != 0) hasOdd = true;
    }

    if (max %2 != 0) return max / 2 + 1;
    return max / 2 + (hasOdd ? 1 : 0);
  }
  
}