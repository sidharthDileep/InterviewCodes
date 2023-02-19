package problems.cts.arrays;

public class Housing {

	public static void main(String[] args) {

		int plots[] = { 1, 3, 2, 1, 4, 1, 2, 1, 1 };
		int n = plots.length;
		int k = 8;

		housing(plots, n, k);

	}

	static void housing(int[] arr, int n, int k) {
		int i = 0, j = 0, cs = 0;

		while (j < n) {

			cs += arr[j];
			j++;

			while (cs > k && i < j) {
				cs = cs - arr[i];
				i++;
			}

			if (cs == k) {
				System.out.println(i + " - " + (j - 1));
			}
		}
	}
}
