package problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Reverse_String {

	public static void main(String[] args) {

		String str = "Hello Where are you", nStr = "";
		char ch;

		for (int i = str.length() - 1; i >= 0; i--) {
			ch = str.charAt(i);
			nStr = nStr + ch;
		}

		System.out.println(nStr);

		String anotherString = "Hello Where are you";

		String result = Arrays.asList(anotherString.split(" ")).stream().map(s -> new StringBuilder(s).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(result);

		String s = "getting good at coding " + "needs a lot of practice";

		System.out.println(s.length());
		String[] words = s.split("\\s");
		System.out.println(words.length);
		words = RevString(words, words.length);

		s = String.join(" ", words);

		System.out.println(s);

	}

	private static String[] RevString(String[] s, int l) {

		if (l % 2 == 0) {

			int j = l / 2;

			while (j <= l - 1) {
				String temp;
				temp = s[l - j - 1];
				s[l - j - 1] = s[j];
				s[j] = temp;
				j += 1;
			}

		} else {
			int j = (l / 2) + 1;

			while (j < l) {

				String temp;
				temp = s[l - 1 - j];
				s[l - 1 - j] = s[j];
				s[j] = temp;
				j += 1;
			}
		}
		return s;
	}

}
