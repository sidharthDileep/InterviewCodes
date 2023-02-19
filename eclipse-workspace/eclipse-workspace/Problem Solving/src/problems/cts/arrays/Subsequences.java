package problems.cts.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequences {

	public static void main(String[] args) {

		String s = "AAB";
		int num = numTilePossibilities(s);

		System.out.println(num);

		String tiles = "AAB";
		String ans = "";
		findSubsequences(tiles, ans);

		System.out.println(list);
		
		//The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".[AAB]
		
		List<String> numSubs = createsubsets(tiles);
		
		System.out.println(numSubs);

	}

	static List<String> list = new ArrayList<>();

	public static int numTilePossibilities(String tiles) {
		int[] count = new int[26];
		for (char ch : tiles.toCharArray()) {
			count[ch - 'A']++;
		}
		return dfs(count);
	}

	private static int dfs(int[] count) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0)
				continue;
			sum++;
			char ch = (char) (i+65);
			System.out.println(ch + " " + sum);
			System.out.println(Arrays.toString(count));
			count[i]--;
			sum += dfs(count);
			count[i]++;
		}
		return sum;
	}

	public static void findSubsequences(String s, String ans) {
		if (s.length() == 0) {
			list.add(ans);
			return;
		}

		findSubsequences(s.substring(1), ans + s.charAt(0));
		findSubsequences(s.substring(1), ans);
	}

	public static String print(String s, int i) {

		int j = 0;
		String sub = "";

		while (i > 0) {
			if ((i & 1) == 1) {
				sub += s.charAt(j);
			}
			j++;
			i = i >> 1;
		}
		return sub;
	}

	public static List<String> createsubsets(String s) {

		List<String> res = new ArrayList<>();
		for (int i = 0; i < (1 << s.length()); i++) {
			res.add(print(s, i));
		}
		return res;
	}

}
