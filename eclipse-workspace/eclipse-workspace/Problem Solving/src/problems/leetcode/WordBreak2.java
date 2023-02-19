package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static void main(String[] args) {

		String word = "catsanddogs";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dogs");

		System.out.println(wordbreak(word, dict));

	}

	private static List<String> wordbreak(String s, Set<String> dict) {
		List<String> list[] = new ArrayList[s.length() + 1];
		List<String> result = new LinkedList<>();
		list[0] = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			if (list[i] == null) {
				continue;
			}

			for (String word : dict) {
				int len = word.length();
				int end = i + len;

				if (end > s.length()) {
					continue;
				}

				if (s.substring(i, end).equals(word)) {
					if (list[end] == null) {
						list[end] = new ArrayList<String>();
					}
					list[end].add(word);
				}

			}
		}

		System.out.println(Arrays.toString(list));

		if (list[s.length()] == null) {
			return result;
		}

		ArrayList<String> temp = new ArrayList<>();
		dfs(list, s.length(), result, temp);

		return result;

	}

	private static void dfs(List<String>[] list, int end, List<String> result, ArrayList<String> temp) {

		if (end <= 0) {
			String path = temp.get(temp.size() - 1);
			for (int i = temp.size() - 2; i >= 0; i--) {
				path = path + " " + temp.get(i);
			}
			result.add(path);
			return;
		}

		for (String str : list[end]) {
			temp.add(str);
			dfs(list, end - str.length(), result, temp);
			temp.remove(temp.size() - 1);
		}

	}
}
