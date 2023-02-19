package problems.cts.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestBand {

	public static void main(String[] args) {

		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		int n = arr.length;

		findLongestConseqSubseq(arr, n);
		longestBand(arr, n);
		
	}

	private static void findLongestConseqSubseq(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		int ans = 0;

		for (int i = 0; i < n; i++)
			set.add(arr[i]);

		for (int i = 0; i < n; i++) {
			if (!set.contains(arr[i] - 1)) {
				int j = arr[i];

				while (set.contains(j)) {
					set.remove(Integer.valueOf(j));
					j++;
				}

				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}

		System.out.println(ans);
	}
	
	private static void longestBand(int[] arr, int n) {
		Set<Integer> set = new HashSet<>();
		int largestLen = 0;

		for (int i = 0; i < n; i++)
			set.add(arr[i]);

		for(int element : set) {
			int parent = element - 1;
			
			if(!set.contains(parent)) {
				int next = element + 1;
				int count = 1;
				
				while(set.contains(next)) {
					next++;
					count++;
				}
				
				if(count > largestLen)
					largestLen = count;
			}
		}

		System.out.println(largestLen);
	}
	
	

}
