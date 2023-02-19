package others;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FuntionalInterfacesExamples {

	public static void main(String[] args) {

		// Supplier is a functional interface; it takes no arguments and returns a
		// result.
		Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();

		// Consumer is a functional interface; it takes an argument and returns nothing.
		Consumer<String> consumer = x -> System.out.println(x);

		// Function is a functional interface; it takes an argument (object of type T)
		// and returns an object (object of type R).
		// The argument and output can be a different type.
		Function<String, Integer> function = x -> x.length();

		// Predicate is a functional interface, which accepts an argument and returns a
		// boolean.
		// Usually, it used to apply in a filter for a collection of objects.
		Predicate<Integer> predicate = x -> x > 5;

		System.out.println(supplier.get());
		consumer.accept("Sidharth");
		System.out.println(function.apply("Sidharth"));

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> collect = list.stream().filter(predicate).collect(Collectors.toList());

		System.out.println(collect);

		addFuncInterface addf = (x, y) -> x + y;

		System.out.println(addf.add(5, 3));
		
		int[] arr = {1, 2, 4, 6, 10};
		
		sumOfArray sum = (ar) -> Arrays.stream(ar).sum();
		
		System.out.println(sum.calculate(arr));

	}

}

@FunctionalInterface
interface addFuncInterface {

	public int add(int x, int y);
}

@FunctionalInterface
interface sumOfArray {

	int calculate(int[] arr);
}
