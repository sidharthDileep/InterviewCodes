package problems.eyList;

import java.util.stream.IntStream;

public class PrintOneToN {

	public static void main(String[] args) {

		int n = 100;
		
		IntStream range = IntStream.range(1, 101);
		
		range.forEach(System.out::println);

		//print1ToN(n);

	}

	private static void print1ToN(int n) {

		if (n == 1) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		print1ToN(n - 1);
	}

}
