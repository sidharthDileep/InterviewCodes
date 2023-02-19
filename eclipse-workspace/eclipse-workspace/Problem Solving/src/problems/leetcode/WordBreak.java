package problems.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {
		
		String word = "leetcodedata";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		dict.add("data");
		
		boolean flag = wordBreak(word, dict);
		
		if(flag) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}

	private static boolean wordBreak(String word, Set<String> dict) {
		Set<String> set = dict;
		
		for(int i=0; i<=word.length(); i++) {
			for(int j=i; j<=word.length(); j++) {
				String sub = word.substring(i, j);
				if(set.contains(sub)) {
					set.remove(sub);
				}
				
				if(set.size() == 0) {
					return true;
				}
				
			}
		}
		
		return false;
		
	}

}
