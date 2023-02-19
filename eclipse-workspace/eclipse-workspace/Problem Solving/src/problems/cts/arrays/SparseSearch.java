package problems.cts.arrays;

public class SparseSearch {

	public static void main(String[] args) {

		String arr[] = { "for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz" };
		String x = "geeks";
		int n = x.length();
		int index = sparse_search(arr, n, x);
		if (index != -1)
			System.out.println(x + " found at index " + index);
		else
			System.out.println(x + " not found");
	}

	static int sparse_search(String a[], int n, String key) {

		int s = 0;
		int e = n;

		while (s <= e) {

			int mid = (s + e) / 2;

			int mid_left = mid - 1;
			int mid_right = mid + 1;

			if (a[mid] == "") {

				while (true) {
					if (mid_left < s && mid_right > e) {
						return -1;
					} else if (a[mid_right] != "") {
						mid = mid_left;
						break;
					} else if (a[mid_left] != "") {
						mid = mid_left;
						break;
					}
					mid_left--;
					mid_right++;
				}

			} else if (a[mid] == key) {
				return mid;
			} else if (key.compareTo(a[mid]) < 0) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}
		return -1;
	}

}
