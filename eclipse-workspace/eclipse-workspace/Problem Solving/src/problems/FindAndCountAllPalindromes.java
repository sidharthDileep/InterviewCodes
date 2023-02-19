package problems;

public class FindAndCountAllPalindromes {

	public static void main(String[] args) {

		String str = "aabbbaa";
		int count = findAllPalindromeSubstrings(str);
		System.out.println("Total palindrome substrings : " + count);
		System.out.println("Total Palindromes : " + countPS(str));

	}

	private static int findAllPalindromeSubstrings(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count += findPalindromesInSubString(str, i - 1, i + 1);
			count += findPalindromesInSubString(str, i, i + 1);
		}

		return count;
	}

	private static int findPalindromesInSubString(String str, int j, int k) {

		int count = 0;
		for (; j >= 0 && k < str.length(); --j, ++k) {
			if (str.charAt(j) != str.charAt(k)) {
				break;
			}
			System.out.println(str.substring(j, k + 1));
			count++;
		}

		return count;
	}
	
	private static int countPS(String str) {
		int count = 0;
		
		String temp = "";
		StringBuilder stf;
		
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=str.length(); j++) {
				temp = str.substring(i, j);
				
				if(temp.length() >= 2) {
					stf = new StringBuilder(temp);
					stf.reverse();
					
					if(stf.toString().compareTo(temp) == 0)
						count++;
				}
			}
		}
		
		return count;
	}

}
