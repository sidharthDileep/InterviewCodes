package problems.leetcode;

public class RegularExpressionMatching {

	public static void main(String[] args) {

		String s = "aa";
		String p = "a*";

		System.out.println(isMatch(s, p));

	}

	public static boolean isMatch(String s, String p) {

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true;

		for (int j = 1; j < dp[0].length; j++) {
			if (p.charAt(j - 1) == '*') {
				if (j >= 2) {
					dp[0][j] = dp[0][j - 2];
				}
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {

				if (p.charAt(j - 1) == '*') {
					if (j >= 2) {
						dp[i][j] = dp[i][j] || dp[i][j - 2];
					}
					if (j >= 2) {
						if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
							dp[i][j] = dp[i][j] || dp[i - 1][j];
						}
					}

				} else {
					if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j - 1];
					}
				}

			}
		}

		return dp[s.length()][p.length()];
	}

}
