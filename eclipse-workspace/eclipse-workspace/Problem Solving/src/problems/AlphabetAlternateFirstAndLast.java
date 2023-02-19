package problems;

public class AlphabetAlternateFirstAndLast {

	public static void main(String[] args) {

		String str = "ABCDXYZ";

		String expected = "AZBYCXD";

		int l = 0;
		int n = str.length();

		StringBuilder sb = new StringBuilder();

		int r = n - 1;
		int limit = n / 2;

		int len = limit;

		if (n % 2 == 0) {
			len = limit - 1;
		}

		for (int i = 0; i <= len; i++) {
			char ch_l = str.charAt(i);
			char ch_r = str.charAt(r);
			r--;

			if (i == limit) {
				sb.append(ch_l);
			} else {
				sb.append(ch_l);
				sb.append(ch_r);
			}
		}
		System.out.println(sb);
	}

}
