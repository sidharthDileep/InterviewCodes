package problems.eyList;

import java.util.Arrays;

public class MaxSubArray {

	public static void main(String[] args) {

		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		
		int maxSubArray = maxSubArray(nums);
		
		System.out.println(maxSubArray);

	}

	private static int maxSubArray(int[] nums) {
		
		int currSum = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<nums.length; i++) {
			currSum = Math.max(currSum + nums[i], nums[i]);
			max = Math.max(max, currSum);
		}
		
		return max;
	}

}
