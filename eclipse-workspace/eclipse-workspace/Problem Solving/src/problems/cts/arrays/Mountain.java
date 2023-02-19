package problems.cts.arrays;

public class Mountain {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 9, 8, 7, 6, 5 };

		System.out.println(isMountainArray(arr) ? "true" : "false");

		System.out.println(highestMountain(arr));
		
		System.out.println(validMountain(arr));
	}

	static boolean isMountainArray(int arr[]) {

		int n = arr.length;

		if (n < 3)
			return false;

		int i = 0;

		for (i = 1; i < n; i++) {
			if (arr[i] <= arr[i - 1])
				break;
		}

		if (i == n || i == 1)
			return false;

		for (; i < n; i++) {
			if (arr[i] >= arr[i - 1])
				break;
		}

		return i == n;
	}

	static int highestMountain(int arr[]) {
		int n = arr.length;

		int largest = 0;

		for (int i = 1; i <= n - 2; i++) {
			int count = 1;
			int j = i;

			while (j >= 1 && arr[j] > arr[j - 1]) {
				j--;
				count++;
			}

			while (i <= n - 2 && arr[i] > arr[i + 1]) {
				i++;
				count++;
			}

			largest = Math.max(largest, count);
		}

		return largest;
	}

	static boolean validMountain(int[] arr) {

		int n = arr.length;
		int left = 0, right = n - 1;

		while (left < n - 1 && arr[left] < arr[left + 1]) {
			left = left + 1;
		}

		while (right > 0 && arr[right-1] > arr[right]) {
			right = right - 1;
		}

		if (left > 0 && left == right && right < n - 1)
			return true;
		else
			return false;

	}

}
