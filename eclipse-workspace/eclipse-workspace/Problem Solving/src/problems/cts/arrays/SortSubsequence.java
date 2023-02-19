package problems.cts.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortSubsequence {

	public static void main(String[] args) {
		
		String s = "Hey";
		List<String> list = new ArrayList<>();
		String out = "";
		
		subsequence(s, out, list);
		
		Collections.sort(list);
		
		System.out.println(list);

	}

	static void subsequence(String s, String out, List<String> list) {
		
		if(s.length() == 0) {
			list.add(out);
			return;
		}
		
		char ch = s.charAt(0);
		String reduced_input = s.substring(1);
		
		subsequence(reduced_input, out+ch, list);
		subsequence(reduced_input, out, list);
		
		
	}
	
}
