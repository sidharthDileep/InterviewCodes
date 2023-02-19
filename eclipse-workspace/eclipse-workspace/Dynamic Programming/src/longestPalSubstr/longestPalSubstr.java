package longestPalSubstr;

public class longestPalSubstr {

	public static void main(String[] args) {

		String str = "aaaabbaa";
		System.out.println("Length is: " + longestPalSubstr(str));

	}

	static int longestPalSubstr(String str) {
		int n = str.length();
		boolean table[][] = new boolean[n][n];

		int maxLength = 1;
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		for (int k = 3; k <= n; ++k) {

			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1;

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.print("Longest palindrome substring is: ");
		printSubStr(str, start, start + maxLength - 1);

		return maxLength;
	}

	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high + 1));
	}

}
