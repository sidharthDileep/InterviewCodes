package problems.cts.arrays;

public class RotatedSearch {

	public static void main(String[] args) {
		
		

	}

	static int rotated_serach(int[] arr, int key) {

		int n = arr.length;
		int s = 0;
		int e = n - 1;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (arr[mid] == key) {
				return mid;
			}

			if (arr[s] <= mid) {

				if (key >= arr[s] && key <= arr[mid]) {
					e = mid - 1;
				} else {
					s = mid + 1;
				}
			} else {

				if (key >= arr[mid] && key <= arr[e]) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
		}
		return -1;
	}

}
