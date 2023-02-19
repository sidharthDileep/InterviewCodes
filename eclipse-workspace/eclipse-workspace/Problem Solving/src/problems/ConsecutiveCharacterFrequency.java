package problems;

import java.util.Scanner;

public class ConsecutiveCharacterFrequency {
	public static void main(String[] args) {
		String str = "aabbbcdda";
		int count = 0;
		char temp = str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == temp) {
				count++;
			} else {
				System.out.print(temp + "" + count);
				count = 1;
				temp = str.charAt(i);
			}
		}
		System.out.print(temp + "" + count);
	}
}
