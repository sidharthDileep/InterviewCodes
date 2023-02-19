package problems;

public class TrappingRainWater {

	public static void main(String[] args) {
		int arr[] = {3, 0, 2, 0, 4};
		//int arr[] = {0, 0, 0, 0, 0};
		int n = arr.length;
		System.out.println(maxWater(arr, n));
	}
	
	public static int maxWater(int[] arr, int n) {
		int res = 0;
		// 3 0 2 0 4
		for(int i=1; i<n-1; i++) {
			
			int left = arr[i];
			for(int j=0; j<i; j++) {
				left = Math.max(left, arr[j]);
			}
			
			int right = arr[i];
			for(int j=i+1; j<n; j++) {
				right = Math.max(right, arr[j]);
			}
			
			res+= Math.min(left, right) - arr[i];
			
		}
		
		return res;
	}

}
