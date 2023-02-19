package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LongestWord {

	public static void main(String[] args) {

		String para = "I have my this";
		String[] arr = para.split(" ");
		System.out.println(Arrays.stream(arr).sorted((str2, str1) -> (str1.length() - str2.length()))
				.collect(Collectors.toList()).get(0));
		
		String str = "aabbbcccc";
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			if(map.get(str.charAt(i)) == null) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		
		Entry<Character, Integer> min = null;
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(min == null || min.getValue() > entry.getValue()) {
				min = entry;
			}
			
		}
		
		System.out.println(min.getKey());
		System.out.println(Collections.min(map.values()));
	}

}
