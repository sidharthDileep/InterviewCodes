package problems.leetcode;

import java.util.Arrays;

public class ValidAnagram {

	public static void main(String[] args) {

		String s = "rat";
		String t = "car";

		System.out.println(isAnagram(s, t));
	}

	private static boolean isAnagram(String s, String t) {

		char[] ca = s.toCharArray();
		char[] ct = t.toCharArray();

		Arrays.sort(ca);
		Arrays.sort(ct);

		String ss = new String(ca);
		String st = new String(ct);

		return ss.equals(st);
	}

}
