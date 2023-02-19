package problems.cts.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniqueSubstring {

	public static void main(String[] args) {

		String str = "abcabekb";
		System.out.println(unique_substring(str));
	}

	static String unique_substring(String str) {

		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		int window_len = 0;
		int max_window_len = 0;
		int start_window = -1;

		while (j < str.length()) {
			
			char ch = str.charAt(j);
			if (map.containsKey(ch) && map.get(ch) <= i) {

				i = map.get(ch) + 1;
				window_len = j - i;
			}

			map.put(ch, j);
			window_len++;
			j++;

			if (window_len > max_window_len) {
				max_window_len = window_len;
				start_window = i;
			}

		}
		System.out.println(map);
		return str.substring(start_window, max_window_len+1);
	}

}
