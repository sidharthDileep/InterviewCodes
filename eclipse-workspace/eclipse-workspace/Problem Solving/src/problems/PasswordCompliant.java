package problems;

public class PasswordCompliant {

	public static void main(String[] args) {

		String s1 = "Sidharth@123";

		// ASCII
		// (0-9) - 48 - 57;
		// (@$#) - 58 -64
		// (a-z) - 97 - 122
		// (A-Z) - 65-90
		// [ 91, \ 92, ] 93, ^ 94, _ 95, ` 96
		// { 123, | 124, } 125, ~ 126, control 127

		int[] arr1 = new int[128];
		int count = 0;
		boolean flagA = false, flagB = false, flagC = false, flagD = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != '`') {
				char c = s1.charAt(i);
				int n = (int) c;
				System.out.println(c + " " + n);
				// if((c >='A' && c<='Z') && (c>='a' && c<='z'))
				if (n >= 48 && n <= 57)
					flagA = true;
				else if (n >= 58 && n <= 64)
					flagB = true;
				else if (n >= 65 && n <= 90)
					flagC = true;
				else if (n >= 97 && n <= 122)
					flagD = true;
				else {

				}
			}

		}

		if (flagA == true && flagB == true && flagC == true && flagD == true) {
			System.out.println("Password is compliant");
		} else {
			System.out.println("Password is not compliant");
		}
	}

}
