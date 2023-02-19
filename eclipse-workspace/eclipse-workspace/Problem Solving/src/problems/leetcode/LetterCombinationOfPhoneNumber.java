package problems.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {

		HashMap<Character, String> keyboard = new HashMap<>();

		initKeyboard(keyboard);
		
		String digits = "23";
		
		List<String> result = new LinkedList<String>();
		compile(digits, "", 0, keyboard, result);
		
		System.out.println(result);

	}

	private static void compile(String digits, String prefix, int start, HashMap<Character, String> keyboard,
			List<String> result) {
		
		if(start == digits.length()) {
			result.add(prefix);
			return;
		}
		
		String cand = keyboard.get(digits.charAt(start));
		
		for(int j=0; j<cand.length(); j++) {
			compile(digits, prefix + cand.charAt(j), start+1, keyboard, result);
		}
		
	}

	private static void initKeyboard(HashMap<Character, String> keyboard) {
		keyboard.put('2', "abc");
		keyboard.put('3', "def");
		keyboard.put('4', "ghi");
		keyboard.put('5', "jkl");
		keyboard.put('6', "mno");
		keyboard.put('7', "pqrs");
		keyboard.put('8', "tuv");
		keyboard.put('9', "wxyz");
	}

}
