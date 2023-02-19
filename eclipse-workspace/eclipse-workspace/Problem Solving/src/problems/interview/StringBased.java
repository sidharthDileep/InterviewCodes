package problems.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringBased {

	public static void main(String[] args) {

		// ASCII
		// (0-9) - 48 - 57;
		// (@$#) - 58 -64
		// (a-z) - 97 - 122
		// (A-Z) - 65-90
		// [ 91, \ 92, ] 93, ^ 94, _ 95, ` 96
		// { 123, | 124, } 125, ~ 126, control 127

		String para = "I have my string";
		String[] words = para.split(" ");

		List<String> collect = Arrays.stream(words).sorted((s1, s2) -> (s2.length() - s1.length()))
				.collect(Collectors.toList());

		System.out.println(collect.get(0));

		String str = "abcd@xyz@123abcd"; // -> find count of each character
		String str2 = "abcd@xyz@123abcd";// -> Reverse individual words in a string o/p: dcba@zyx@dcba321

		String s1 = "Asj@1234";

		int[] arr = new int[128];

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i)] = arr[str.charAt(i)] + 1;
		}

		for (int i = 0; i < 128; i++) {
			if (arr[i] != 0 && i != '@') {
				Character c = (char) i;
				System.out.print(c + " - " + arr[i] + ", ");

			}
		}

		System.out.println();

		String result = Arrays.asList(str.split("@")).stream().map(s -> new StringBuilder(s).reverse())
				.collect(Collectors.joining("@"));

		System.out.println("Reverse string : " + result);
		

	}

}
