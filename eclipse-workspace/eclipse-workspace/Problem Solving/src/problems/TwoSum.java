package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] nums = {2, 7, 11, 15};
		int n = nums.length;
		int target = 9;
		List<Integer> list = new ArrayList<>();
		Twosum1(nums, target);
		
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			if(map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			}
			map.put(nums[i], i);
		}
		
		System.out.println("Second Version : " + Arrays.toString(result));
		
		int input[] = {9,7,4,6,8,2,1};
        int sum = 9;
        
		IntStream.range(0,  input.length)
        .forEach(i -> IntStream.range(0,  input.length)
        .filter(j -> i != j && input[i] + input[j] == sum)
        .limit(1)
        .forEach(System.out::println)
        );

	}

	private static void Twosum1(int[] nums, int target) {
		List<Integer> list;
		list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int n = nums.length;
		
		
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<n; i++) {
			int temp = target - nums[i];
			
			if(set.contains(temp)) {
				System.out.println("[" + list.indexOf(temp) + ", " + list.indexOf(nums[i]) + "]");
			}

			set.add(nums[i]);
		}
	}

}
