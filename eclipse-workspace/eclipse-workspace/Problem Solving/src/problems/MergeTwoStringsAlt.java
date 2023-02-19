package problems;

public class MergeTwoStringsAlt {

	public static void main(String[] args) {
		
		String s1 = "Sidharth";
		String s2 = "something";
		
		StringBuilder merge = new StringBuilder();
		
		for(int i=0; i<s1.length() || i<s2.length(); i++) {
			
			if( i < s1.length())
				merge.append(s1.charAt(i));
			
			if( i < s2.length())
				merge.append(s2.charAt(i));
			
			
		}
		
		System.out.println(merge.toString());

	}

}
