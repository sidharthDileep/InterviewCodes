package countWaysToReach;

public class Recurssion {

	public static void main(String[] args) {
		
		int n = 4; // 1+1+1+1, 2+2, 1+2+1, 1+1+2, 2+1+1
		
		System.out.println("Number of Steps : " + findStep(n));

	}
	
	
	public static int findStep(int n) {
		
		if( n == 0) {
			return 1;
		} else if( n < 0) {
			return 0;
		}
		
		else {
			return  findStep(n-2) + findStep(n-1);
		}
		
	}

}
