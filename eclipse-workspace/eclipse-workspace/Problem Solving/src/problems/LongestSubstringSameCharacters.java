package problems;

public class LongestSubstringSameCharacters {

	public static void main(String[] args) {

		String s = "abpppcdddddeffd";
		//Optimal Solution
		System.out.println("size : " + longestSubstringChar(s));

		String str1 = "aaabbbbbaaaaaaaacc";

		// Length of the longest repeating character
		// starting index

		String str2 = "";

		int n = str1.length();

		for (int i = 1; i < n; i++) {
			String str3 = repeatedString(str1.substring(i - 1, n), str1.substring(i, n));
			// System.out.println("str3 : " + str3);
			if (str3.length() > str2.length())
				str2 = str3;

		}

		System.out.println("Longest String: " + str2);
		System.out.println("Length of the String: " + str2.length());
		System.out.println("Index value of the starting digit of the longest string: " + str1.indexOf(str2));

	}

	private static int longestSubstringChar(String s) {
		int count = 1, temp = 1;
		StringBuilder longest = new StringBuilder();
		String max = "";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				temp++;
				longest.append(s.charAt(i));
				if (temp > count) {
					max = longest.toString();
				}
			}

			else {
				longest.delete(0, longest.length());
				longest.append(s.charAt(i));
				count = Math.max(count, temp);
				temp = 1;
			}
		}

		count = Math.max(count, temp);

		System.out.println("Longest String : " + max);
		System.out.println("Index : " + s.indexOf(max));

		return count;
	}

	private static String repeatedString(String substring, String substring2) {

		int n = Math.min(substring.length(), substring2.length());
		for (int i = 0; i < n; i++) {
			if (substring.charAt(i) != substring2.charAt(i)) {
				return substring.substring(0, i + 1);
			}
		}
		return substring.substring(0, n);
	}

}
