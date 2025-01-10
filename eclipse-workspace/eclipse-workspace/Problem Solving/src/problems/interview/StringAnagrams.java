package problems.interview;

public class StringAnagrams {
	public static void main(String[] args) {
		String str1 = "care";
		String str2 = "race";
		
		boolean anagramChecker = anagramChecker(str1, str2);
		
		System.out.print(anagramChecker);

	}

	private static boolean anagramChecker(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		
		for(int i = 0; i < str1.length(); i++) {
			count1[str1.charAt(i) - 'a'] = count1[str1.charAt(i) - 'a'] + 1;
		}
		
		for(int i = 0; i < str2.length(); i++) {
			count2[str2.charAt(i) - 'a'] = count2[str2.charAt(i) - 'a'] + 1;
		}
		
		for(int i = 0; i < 26; i++) {
			if(count1[i] != count2[i]) return false;
		}
		
		return true;
	}
}
