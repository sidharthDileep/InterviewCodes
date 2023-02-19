package problems;

import java.util.Arrays;

public class PossibleMappingsOfCharacters {

	public static void main(String[] args) {
		
		int num = 123;
		int inputarr[] = new int[3];
		int r = 0;
		int i = 2;
		while(num > 0) {
			r = num%10;
			inputarr[i--] = r;
			num = num/10;
		}
		System.out.println(Arrays.toString(inputarr));
		//int inputarr[] = { 1, 2, 3 };
		int m = (int) Math.pow(2, 3) - 1;
		int n = 1;
		char outputarr[] = new char[m];

		mapped(inputarr, outputarr, 0, 0);

	}

	private static void mapped(int[] inputarr, char[] outputarr, int i, int j) {

		if (i >= inputarr.length) {
			String str = new String(outputarr);
			System.out.println(str.substring(0, j));
			return;
		}

		int digit = inputarr[i];

		char ch = (char) (digit + (int) 'A' - 1);
		outputarr[j] = ch;

		mapped(inputarr, outputarr, i + 1, j + 1);

		if (i + 1 < inputarr.length) {
			int second_digit = inputarr[i + 1];
			int number = digit * 10 + second_digit;

			if (number <= 26) {
				ch = (char) (number + (int) 'A' - 1);
				outputarr[j] = ch;

				mapped(inputarr, outputarr, i + 2, j + 1);
			}
		}

	}

}
