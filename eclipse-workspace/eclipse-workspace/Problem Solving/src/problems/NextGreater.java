package problems;

public class NextGreater {

	public static void main(String[] args) {

		int n = 6;
		int[] v = { 5, 3, 4, 9, 7, 6 };
		int[] res;

		res = nextPermutation(n, v);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	private static int[] nextPermutation(int n, int[] arr) {

		if (n == 1)
			return arr;

		int i = 0;

		for (i = n - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1])
				break;
		}

		if (i != 0) {
			for (int j = n - 1; j >= i; j--) {
				if (arr[i - 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i - 1];
					arr[i - 1] = temp;
					break;
				}
			}

		}

		int[] res = new int[arr.length];
		int ind = arr.length - 1;

		for (int j = 0; j < i; j++)
			res[j] = arr[j];

		for (int j = i; j < res.length; j++)
			res[j] = arr[ind--];

		return res;
	}

}
