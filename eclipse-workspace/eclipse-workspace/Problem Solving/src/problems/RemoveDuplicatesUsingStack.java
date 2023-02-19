package problems;

import java.util.Stack;

public class RemoveDuplicatesUsingStack {

	public static void main(String[] args) {

		Stack<Character> stack = new Stack<>();

		String s = "AAABBBCDDDEE";
		Character p = 0;
		stack.add(s.charAt(0));

		for (char c : s.toCharArray()) {

			if (stack.isEmpty()) {
				if (p == c) {
					continue;
				} else {
					stack.push(c);
				}

			} else {

				if (c == stack.peek()) {
					//p = stack.pop();
					continue;

				} else {
					/*if (p == c) {
						continue;
					} else {*/
						stack.push(c);
					//}

				}

			}

		}

		System.out.println(stack);

	}

}
