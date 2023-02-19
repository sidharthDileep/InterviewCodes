package countWaysToReach;

public class Tabulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
        System.out.println(countWays(n));

	}

	private static int countWays(int n) {
		// TODO Auto-generated method stub
		int[] res = new int[n+1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;
		
		for(int i=3; i<=n; i++) {
			res[i] = res[i-1] + res[i-2] + res[i-3];
		}
		
		
		
		return res[n];
	}

}
