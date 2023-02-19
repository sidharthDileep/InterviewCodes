package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class RearrangeOddEven {

	public static void main(String[] args) {

		int arr[] = { 9, 8, 13, 2, 19, 14, 3, 5, 6, 10 };
		int n = arr.length;

		// AlternateRearrange(arr, n);
		RearrangeAtEnds(arr, n);

	}

	private static void RearrangeAtEnds(int[] arr, int n) {

		int left = 0;
		int right = arr.length - 1;
		
		for (int i = 0; i < arr.length; i++) {

			while (arr[left] % 2 == 1) {
				left++;
			}
			while (arr[right] % 2 == 0) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void AlternateRearrange(int[] arr, int n) {

		Arrays.sort(arr);

		Vector v1 = new Vector();
		Vector v2 = new Vector();

		for (int i = 0; i < n; i++) {
			if (arr[i] % 2 == 0)
				v1.add(arr[i]);
			else
				v2.add(arr[i]);
		}

		int index = 0, i = 0, j = 0;

		boolean flag = false;

		if (arr[0] % 2 == 0)
			flag = true;

		while (index < n) {
			if (flag == true) {
				arr[index] = (int) v1.get(i);
				i += 1;
				index += 1;
				flag = !flag;
			} else {
				arr[index] = (int) v2.get(j);
				j += 1;
				index += 1;
				flag = !flag;
			}
		}

		for (i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
