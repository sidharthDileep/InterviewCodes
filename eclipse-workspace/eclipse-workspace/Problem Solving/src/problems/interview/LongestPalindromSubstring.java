package problems.interview;

public class LongestPalindromSubstring {
	
	public static void main(String args[]) {
		String str = "babad";
        System.out.println(longestPalindrome(str));
	}

	private static String longestPalindrome(String str) {
		if(str == null || str.length() < 2) return str;
		
		int start = 0, maxLength = 1;
		for(int i = 0; i < str.length(); i++) {
			int len1 = expandAroundCenter(str, i, i);
			int len2 = expandAroundCenter(str, i, i + 1);
			int len = Math.max(len1, len2);
			
			if(len > maxLength) {
				maxLength = len;
				start = i - (len - 1) / 2;
			}
		}
		
		return str.substring(start, start + maxLength);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		return right - left - 1;
	}
	
	

}
