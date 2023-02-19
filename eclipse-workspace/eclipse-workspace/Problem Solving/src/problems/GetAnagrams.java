package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAnagrams {

	public static void main(String[] args) {

		// String s1 = "ddcf";
		// String s2 = "cedk";

		String s3 = "ddcfcedk";
		int len = s3.length();

		String s1 = s3.substring(0, len / 2);
		String s2 = s3.substring(len / 2);

		System.out.println("s1 :" + s1);
		System.out.println("s2 :" + s2);

		System.out.println();

		int count = 0;
		int char_count[] = new int[26];

		for (int i = 0; i < s1.length(); i++)
			char_count[s1.charAt(i) - 'a']++;

		for (int i = 0; i < s2.length(); i++)
			char_count[s2.charAt(i) - 'a']--;

		for (int i = 0; i < 26; i++) {
			if (char_count[i] != 0) {
				count += Math.abs(char_count[i]);
			}
		}

		System.out.println(Arrays.toString(char_count));

		System.out.println(count / 2);

	}

	// s: "cbaebabacd" p: "abc"

	public List<Integer> findAnagramsV2(String s, String p) {
		int sn = s.length();
		int pn = p.length();
		List<Integer> res = new ArrayList<>();
		if (sn <= 0 || pn <= 0)
			return res;

		int[] pArr = new int[26];
		for (int i = 0; i < pn; i++) {
			char c = p.charAt(i);
			pArr[(int) (c - 'a')]++;
		}

		int[] sArr = new int[26];
		for (int i = 0; i < sn; i++) {
			char c = s.charAt(i);
			sArr[(int) (c - 'a')]++;
			if (i >= pn) {
				char c2 = s.charAt(i - pn);
				sArr[(int) (c2 - 'a')]--;
			}

			if (Arrays.equals(pArr, sArr)) {
				res.add(i - pn + 1);
			}
		}

		return res;
	}

	public List<Integer> findAnagrams(String s, String p) {
		int sn = s.length();
		int pn = p.length();
		List<Integer> res = new ArrayList<>();
		if (sn <= 0 || pn <= 0)
			return res;

		int[] pArr = new int[26];
		for (int i = 0; i < pn; i++) {
			char c = p.charAt(i);
			pArr[(int) (c - 'a')]++;
		}

		for (int i = 0; i <= sn - pn; i++) {
			char c = s.charAt(i);
			if (pArr[(int) (c - 'a')] == 0)
				continue;
			if (isAnagram(s, i, i + pn - 1, pArr)) {
				res.add(i);
			}
		}

		return res;
	}

	private boolean isAnagram(String s, int start, int end, int[] pArr) {
		int[] sArr = new int[26];
		for (int i = start; i <= end; i++) {
			char c = s.charAt(i);
			if (pArr[(int) (c - 'a')] == 0)
				return false;
			sArr[(int) (c - 'a')]++;
			if (pArr[(int) (c - 'a')] < sArr[(int) (c - 'a')])
				return false;
		}

		return true;
	}

}
