package problems.cts.arrays;

import java.util.Arrays;

public class StringWindow {

	public static void main(String[] args) {

		String str = "hello";
		String pat = "elo";

		System.out.println(find_window(str, pat));

	}

	static String find_window(String s, String pat) {
		int FP[] = new int[256];
		int FS[] = new int[256];

		for (int i = 0; i < pat.length(); i++) {
			FP[pat.charAt(i)]++;
		}

		// System.out.println(Arrays.toString(FP));

		int count = 0;
		int start = 0;
		int start_index = -1;
		int min_so_far = Integer.MAX_VALUE;
		int window_size;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			FS[ch]++;

			if (FP[ch] != 0 && FS[ch] <= FP[ch]) {
				count++;
			}

			if (count == pat.length()) {
				while (FP[s.charAt(start)] == 0 || FS[s.charAt(start)] > FP[s.charAt(start)]) {
					FS[s.charAt(start)]--;
					start++;
				}

				window_size = i - start + 1;
				if (window_size < min_so_far) {
					min_so_far = window_size;
					start_index = start;
				}
			}
		}

		// System.out.println(Arrays.toString(FS));

		if (start_index == -1)
			return "No Window Found";

		return s.substring(start_index, start_index + min_so_far);

	}
}
