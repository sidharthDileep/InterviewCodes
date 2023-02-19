package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));

	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, Integer> groups = new HashMap<String, Integer>();
		
		for(int i=0; i<strs.length; i++) {
			char[] tmpChar = strs[i].toCharArray();
			Arrays.sort(tmpChar);
			
			String tmp = new String(tmpChar);
			
			if(groups.containsKey(tmp)) {
				result.get(groups.get(tmp)).add(strs[i]);
				continue;
			}
			
			List<String> curr = new LinkedList<>();
			curr.add(strs[i]);
			result.add(curr);
			groups.put(tmp, result.size() - 1);
			
		}
		
		System.out.println(groups);
		
		return result;
	}

}
