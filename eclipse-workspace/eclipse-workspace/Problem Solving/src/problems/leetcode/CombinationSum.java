package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {

		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> list = combinationSum(candidates, target);

		System.out.println(list);

	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (candidates == null || candidates.length == 0)
			return result;

		ArrayList<Integer> current = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, current, result);

		return result;
	}

	private static void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr,
			List<List<Integer>> result) {

		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<>(curr);
			result.add(temp);
			return;
		}

		for (int i = j; i < candidates.length; i++) {

			if (target < candidates[i])
				return;

			curr.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, curr, result);
			curr.remove(curr.size() - 1);

		}

	}

}
