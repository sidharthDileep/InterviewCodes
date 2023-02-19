package problems.cts.arrays;

public class CheckSubset {

	public static void main(String[] args) {
		
		String str1 = "Hello";
		String str2 = "He";
		
		System.out.println(isSubset(str1, str2));

	}
	
	static boolean isSubset(String s1, String s2) {
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		
		while(i>=0 && j>=0) {
			if(s2.charAt(j) == s1.charAt(i)) {
				i--;
				j--;
			}
			else {
				i--;
			}
		}
		
		if(j==-1)
			return true;
		
		return false;
	}

}
