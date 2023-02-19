package problems;

import java.util.Arrays;
import java.util.Stack;

public class SortArrayUsingStack {

	public static void main(String[] args) {
		int[] arr = { 55, 10, 5, 15, 45, 4 };
		int n = arr.length;
		
		System.out.println(Arrays.toString(arr));

		sortArrayUsingStacks(arr, n);

		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	private static void sortArrayUsingStacks(int[] arr, int n) {

		Stack<Integer> input = new Stack<>();

		for (int i = 0; i < n; i++)
			input.push(arr[i]);

		Stack<Integer> tmpStack = sortStack(input);
		
		for(int i=0; i<n; i++) {
			arr[i] = tmpStack.peek();
			tmpStack.pop();
		}

	}

	private static Stack<Integer> sortStack(Stack<Integer> input) {

		Stack<Integer> tmpStack = new Stack<>();

		while (!input.empty()) {
			int tmp = input.peek();
			input.pop();

			while (!tmpStack.empty() 
					&& tmpStack.peek() < tmp) {
				input.push(tmpStack.peek());
				tmpStack.pop();
			}

			tmpStack.push(tmp);
			
			//System.out.println(tmpStack);
		}
		return tmpStack;
	}

}
