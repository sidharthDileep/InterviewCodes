package problems.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MSinterview {

	static int maxnumber(int[] arr) {
		int max = 0;
		
		List<Integer> list = new ArrayList<>();
		list = Arrays.stream(arr)
			  .boxed()
			  .collect(Collectors.toList());
		
		System.out.println(list);
		
		max = list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		
		System.out.println("Index : " + list.indexOf(max));
		
		return max;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Max Number :" + maxnumber(prices));
	}
}
