package problems.leetcode;

import java.util.Arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}

	public static String multiply(String num1, String num2) {
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();

		int[] d = new int[n1.length() + n2.length()];

		for (int i = 0; i < n1.length(); i++) {
			for (int j = 0; j < n2.length(); j++) {
				d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
			}
		}

		System.out.println(Arrays.toString(d));

		String result = "";
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
			result = (digit + "") + result;
		}
		int index = 0;
		while (index < result.length() - 1 && result.charAt(index) == '0') {
			index++;
		}

		System.out.println(result);
		return result.substring(index);
	}

}
