package problems.cts.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequentialStrings {

	public static void main(String[] args) {

		String s = "111222333444";
		List<String> list = Arrays.asList("121", "3", "12345", "11234");

		//String s = "987654";
		//List<String> list = Arrays.asList("121", "3", "4", "04");

		System.out.println(countMinimumCharacters(list, s));

	}

	private static List<Integer> countMinimumCharacters(List<String> list, String s) {
		List<Integer> ans = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == null)
				map.put(s.charAt(i), i);
		}

		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			boolean flag = true;
			int index = -1;
			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);

				for (int k = 0; k < temp.length(); k++) {

					if (!map.containsKey(temp.charAt(k))) {
						flag = false;
						break;
					} else {
						flag = true;
					}
					if (temp.charAt(k) == ch) {
						flag = true;
						// index = j-1;
						index = map.get(temp.charAt(k)) + 1;
					}

				}
			}

			if (flag) {
				ans.add(index);
			} else {
				ans.add(-1);
			}
		}

		return ans;
	}

}
