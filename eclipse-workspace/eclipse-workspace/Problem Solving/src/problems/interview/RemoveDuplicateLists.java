package problems.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicateLists {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(1, 2, 3, 6, 12, 45, 5, 87, 3, 2, 6);
		Map<Integer, Integer> map = new HashMap<>();
		list.forEach(e -> map.put(e, map.getOrDefault(e, 0) + 1));
		
		map.entrySet().stream()
					  .filter(e -> e.getValue() > 1)
					  .map(e -> e.getKey()).collect(Collectors.toList());
		
		List<Integer> collect2 = list.stream().distinct().collect(Collectors.toList());
		
		Map<Integer, Long> collect = list.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		

	}

}
