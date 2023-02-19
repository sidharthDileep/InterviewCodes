package problems.interview.tricky;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrickyQuestions3 {

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		
		CalculateArray calc = (ar) -> Arrays.stream(ar).sum();
		
		System.out.println(calc.sum(arr));
		
		Map<String, String> map = new HashMap<>();
		map.put(new String("a"), "audi");
		map.put(new String("a"), "ferrari");
		
		System.out.println(map);
		
		String s1 = new String("Hi");
		String s2 = new String("Hi");
		String s3 = s1;
		
		if(s3.equals(s2)) {
			System.out.println("1");
		}
		if(s2 == s3) {
			System.out.println("2");
		}
		
		
		List<String> list = Arrays.asList("", null, "sidharth", "vasudha", "");
		
		List<String> collect = list.stream()
								   .sorted(Comparator.nullsLast(Comparator.naturalOrder()))
								   .collect(Collectors.toList());
		
		List<String> nonEmpty = list.stream()
									.filter(e -> e!=null)
									.filter(e -> !e.isEmpty())
									.collect(Collectors.toList());
		
		System.out.println(collect);
		System.out.println(nonEmpty);
	}

}

@FunctionalInterface
interface CalculateArray {

	int sum(int[] arr);

}
