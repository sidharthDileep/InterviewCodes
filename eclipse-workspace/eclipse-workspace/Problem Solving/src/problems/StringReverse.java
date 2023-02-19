package problems;

public class StringReverse {

	public static void main(String[] args) {
		
		String str = "Sidharth";
		
		System.out.println(revereString(str.toCharArray(), 0, str.length()-1));
		
	}
	
	static String revereString(char[] str, int start, int end) {
		
		while(start < end) {
			str[start] ^= str[end];
			str[end] ^= str[start];
			str[start] ^= str[end];
			
			++start;
			--end;
		}
		
		return String.valueOf(str);
	}

}
