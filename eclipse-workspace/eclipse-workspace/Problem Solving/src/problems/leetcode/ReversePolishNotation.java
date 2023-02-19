package problems.leetcode;

import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {

		String[] token = { "2", "1", "+", "3", "*" };

		System.out.println(evalPRN(token));

	}

	private static int evalPRN(String[] token) {

		int returnValue = 0;
		Stack<String> stack = new Stack<>();
		String operators = "+-*/";

		for (String t : token) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(a - b));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;

				}

			}
			
		}

		returnValue = Integer.valueOf(stack.pop());
		
		return returnValue;
	}

}
