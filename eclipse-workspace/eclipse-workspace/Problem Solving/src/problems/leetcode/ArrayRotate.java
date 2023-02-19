package problems.leetcode;

import java.util.Arrays;

public class ArrayRotate {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		arrayRotate(arr, k);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void arrayRotate(int[] arr, int k) {
		
		if(k > arr.length) {
			k = k%arr.length;
		}
		
		int[] result = new int[arr.length];
		
		for(int i=0; i<k; i++) {
			result[i] = arr[arr.length - k + i];
		}
		
		int j = 0;
		for(int i=k; i<arr.length; i++) {
			result[i] = arr[j];
			j++;
		}
		
		System.arraycopy(result, 0, arr, 0, arr.length);
		
		
	}

}
