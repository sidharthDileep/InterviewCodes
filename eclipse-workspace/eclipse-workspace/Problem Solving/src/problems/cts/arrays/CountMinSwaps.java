package problems.cts.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountMinSwaps {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 4, 3, 2 };
		System.out.println(minSwaps(arr));
	}

	static int minSwaps(int[] nums) {

		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; i++)
			map.put(nums[i], i);

		Arrays.sort(nums);

		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);

		int min = 0;

		for (int i = 0; i < len; i++) {
			if (visited[i] || map.get(nums[i]) == i)
				continue;

			int j = i, cycle_size = 0;

			while (!visited[j]) {
				visited[j] = true;

				j = map.get(nums[j]);
				cycle_size++;
			}

			if (cycle_size > 0)
				min += (cycle_size - 1);
		}

		return min;
	}
}
