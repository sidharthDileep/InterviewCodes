package student;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 2, 5, 2, 3, 3);

		Map<Boolean, List<Integer>> map = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

		System.out.println(map);

		Map<Integer, Long> result2 = numbers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		System.out.println("Result " + result2);

		Map<Boolean, List<Integer>> collect = numbers.stream().distinct()
				.collect(Collectors.partitioningBy(x -> x % 2 == 0));

		List<Integer> even = collect.get(true);
		List<Integer> odd = collect.get(false);

		System.out.println("Even : " + even.toString() + " - " + "Odd" + odd.toString());

		List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);

		Set<Integer> collect2 = list.stream().filter(i -> Collections.frequency(list, i) > 1)
				.collect(Collectors.toSet());

		System.out.println(collect2);

		Stream<String[]> Ss1 = Stream
				.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "Geeks" } });

		LinkedHashMap<String, String> map2 = Ss1
				.collect(Collectors.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new));

		System.out.println("Map:" + map2);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		

		List<Person> personList = Arrays.asList(new Person("bob", 34), new Person("bob", 43), new Person("mary", 84),
				new Person("john", 12), new Person("bob", 22));

		System.out.println("Person list - " + personList);

		Stream<Person> personStream = personList.stream();

		Map<String, List<Integer>> result3 = personStream
				.collect(Collectors.groupingBy(p -> p.name, Collectors.mapping(e -> e.age, Collectors.toList())));

		System.out.println("Mapping result - " + result3);

	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}
