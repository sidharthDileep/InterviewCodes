package problems.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		System.out.print(groupAnagrams(words));

	}

	private static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String word : words) {
        	int[] charCount = new int[26];
        	for(char ch : word.toCharArray()) {
        		charCount[ch - 'a']++;
        	}
        	
        	StringBuilder keyBuilder = new StringBuilder();
        	for(int count : charCount) {
        		keyBuilder.append("#").append(count);
        	}
        	
        	String key = keyBuilder.toString();
        	anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        
        List<List<String>> result = new ArrayList<>(anagrams.values());
		return result;
	}

}
