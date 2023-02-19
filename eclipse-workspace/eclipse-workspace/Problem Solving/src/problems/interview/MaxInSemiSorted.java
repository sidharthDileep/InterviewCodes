package problems.interview;

public class MaxInSemiSorted {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 50, 1, 2, 3, 4 };
		int n = arr.length;
		//System.out.println("The maximum element is " + maxInBitonic(arr, 0, n - 1));
		System.out.println("The maximum element is " + findMax(arr));
	}

	static int maxInBitonic(int arr[], int l, int r) {

		while (l <= r) {

			int m = l + (r - l) / 2; // m = (l + r) / 2

			/**** Base Cases Starts *****/

			if (l == r)
				return arr[l];

			/*
			 * If there are two elements and first is greater then the first element is
			 * maximum
			 */
			if ((r == l + 1) && arr[l] >= arr[r])
				return arr[l];

			/*
			 * If there are two elements and second is greater then the second element is
			 * maximum
			 */

			if ((r == l + 1) && arr[l] < arr[r])
				return arr[r];

			/*
			 * If we reach a point where arr[mid] is greater than both of its adjacent
			 * elements arr[mid-1] and arr[mid+1], then arr[mid] is the maximum element
			 */
			if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1])
				return arr[m];

			/**** Base Case ends *****/

			// move to left with l and r=m-1
			if (arr[m] > arr[m + 1] && arr[m] < arr[m - 1])
				r = m - 1;

			else
				l = m + 1; // move to right with l=m+1 and r
		}
		// if we reach here, then element was
		// not present
		return -1;
	}

	public static int findMax(int[] nums) {
		// binary search
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[left] < nums[mid]) {
				left = mid;
			} else if (nums[left] > nums[mid]) {
				right = mid - 1;
			} else {
				// subtility here if there are duplicate elements in the array.
				// shift the left linearly
				left = left + 1;
			}
		}
		return nums[left];
	}

}
