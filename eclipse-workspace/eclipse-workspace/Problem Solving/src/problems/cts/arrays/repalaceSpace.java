package problems.cts.arrays;

public class repalaceSpace {

	public static void main(String[] args) {
		
		char[] str = "Hi How are you?".toCharArray();
		
		char[] newString = replace_space(str);
		
		System.out.println(newString);

	}
	
	static char[] replace_space(char[] str) {
		int spaces = 0, i=0;
		for(i=0; i<str.length; i++) {
			if(str[i] == ' ')
				spaces++;
		}
		//System.out.println(spaces);
		
		/*
		 * while(str[i-1] == ' ') { spaces--; i--; }
		 */
		//System.out.println(spaces);
		
		int new_length = i+spaces*2;
		
		int index = new_length-1;
		
		char[] old_str = str;
		str = new char[new_length];
		
		for(int j=i-1; j>=0; j--) {
			if(old_str[j] == ' ') {
				str[index] = '0';
				str[index - 1] = '2';
				str[index - 2] = '%';
				index = index-3;
			} else {
				str[index] = old_str[j];
				index--;
			}
		}
		return str;
	}

}
