package problems.leetcode;

public class LongestPalindrome {

	public static void main(String[] args) {

		String str = "abbavvvbbbvvv";

		System.out.println(longestPalindrome(str));

		//////////////////// Second
		String str2 = "forgeeksskeegfor";
		System.out.print("\nLength is: " + longestPalSubstr(str2));

	}

	private static String longestPalindrome(String str) {

		String longest = str.substring(0, 1);
		for (int i = 0; i < str.length(); i++) {

			String temp = helper(str, i, i);

			if (temp.length() > longest.length()) {
				longest = temp;
			}

		}
		return longest;
	}

	private static String helper(String s, int begin, int end) {

		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}

		return s.substring(begin + 1, end);
	}

	//////////////////////////////////////////// Another Approach
	public static void printSubStr(String str, int low, int high) {
		for (int i = low; i <= high; ++i)
			System.out.print(str.charAt(i));
	}

	private static int longestPalSubstr(String str) {
		int n = str.length();

		int maxLength = 1, start = 0;

		for (int i = 0; i < n; i++) { // MaaM
			for (int j = i; j < n; j++) { // 0123
				int flag = 1;

				for (int k = 0; k < (j - i + 1) / 2; k++) {
					if (str.charAt(i + k) != str.charAt(j - k)) {
						flag = 0;
					}
				}

				if (flag != 0 && (j - i + 1) > maxLength) {
					start = i;
					maxLength = j - i + 1;
				}

			}
		}

		System.out.print("Longest palindrome subString is: ");
		printSubStr(str, start, start + maxLength - 1);

		return maxLength;
	}

}
