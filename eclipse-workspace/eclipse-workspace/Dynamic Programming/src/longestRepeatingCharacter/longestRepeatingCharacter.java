package longestRepeatingCharacter;

import java.util.Stack;

public class longestRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "aaabbbbbaaaaaaaacc";
					           
		String str2 = "";
		
		int n = str1.length();
		for(int i=0; i<n; i++) {
			String str3 = repeatedString(str1.substring(i, n), str1.substring(i+1, n));
			
			if(str3.length() > str2.length()) {
				str2 = str3;
			}
			
		}
		
		
		System.out.println("Longest String: "+str2);
        System.out.println("Length of the String: "+str2.length());
        System.out.println("Index value of the starting digit of the longest string: "+str1.indexOf(str2));
	}

	private static String repeatedString(String s1, String s2) {
		// TODO Auto-generated method stub
		int n = Math.min(s1.length(), s2.length());
		for(int i=0; i<n; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				return s1.substring(0, i);
			}
		}
		
		
		return s1.substring(0, n);
	}

}
