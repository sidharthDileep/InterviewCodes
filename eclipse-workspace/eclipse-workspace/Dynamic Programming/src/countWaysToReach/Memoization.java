package countWaysToReach;

import java.util.Arrays;

public class Memoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Memoization g = new Memoization();
	    int n = 4;
	 
	    System.out.println(g.findStep(n));

	}
	
	public int findStep(int n)
    {
      int[] dp = new int[n + 1];
      Arrays.fill(dp,-1);
      return findStepHelper(n, dp);
    }
	
	private int findStepHelper(int n, int[] dp)
    {
      if (n == 0)
        return 1;
      else if (n < 0)
        return 0;
      
      if (dp[n] != -1) {
        return dp[n];
      }

      return dp[n] = findStepHelper(n - 3, dp)
        + findStepHelper(n - 2, dp)
        + findStepHelper(n - 1, dp);
    }
}
