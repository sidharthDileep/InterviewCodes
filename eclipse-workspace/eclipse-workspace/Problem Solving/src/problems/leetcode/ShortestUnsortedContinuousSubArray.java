package problems.leetcode;

public class ShortestUnsortedContinuousSubArray {

	public static void main(String[] args) {

		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };

		System.out.println(findUnsortedSubarray(nums));

	}

	public static int findUnsortedSubarray(int[] nums) {

		int len = nums.length - 1, left = -1, right = -1;
		int max = nums[0], min = nums[len];

		for (int i = 1; i <= len; i++) {
			int a = nums[i];
			int b = nums[len - i];

			if (a < max) {
				right = i;
			} else {
				max = a;
			}
			if (b > min) {
				left = i;
			} else {
				min = b;
			}
		}
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		System.out.println("left : " + left);
		System.out.println("right : " + right);
		return Math.max(0, left + right - len + 1);
	}

}
