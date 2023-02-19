package operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamOperation {

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

		Integer sum = integers.stream().reduce(0, (a, b) -> a + b);

		Integer sum2 = integers.stream()
							   .collect(Collectors.summingInt(Integer::intValue));

	}

}
