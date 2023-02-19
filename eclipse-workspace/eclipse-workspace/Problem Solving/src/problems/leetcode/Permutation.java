package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
		System.out.println(permute(nums));

		System.out.println(permuteTwo(nums));

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		List<List<Integer>> current = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {

			for (List<Integer> l : result) {
				for (int j = 0; j < l.size() + 1; j++) {

					l.add(j, nums[i]);
					ArrayList<Integer> temp = new ArrayList<>(l);
					current.add(temp);
					l.remove(j);
				}
			}

			result = new ArrayList<List<Integer>>(current);
		}
		return result;
	}

	
	//Another way
	static List<List<Integer>> result;

	public static List<List<Integer>> permuteTwo(int[] nums) {
		result = new ArrayList<>();
		permute(nums, 0);
		return result;
	}

	public static void permute(int[] nums, int index) {

		if (index == nums.length) {
			List<Integer> l = new ArrayList<>(nums.length);

			for (int elm : nums) {
				l.add(elm);
			}

			result.add(l);

		} else {
			for (int j = index; j < nums.length; j++) {
				int temp = nums[index];
				nums[index] = nums[j];
				nums[j] = temp;

				permute(nums, index + 1);

				temp = nums[index];
				nums[index] = nums[j];
				nums[j] = temp;
			}
		}
	}

}
