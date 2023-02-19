package problems.interview.tricky;

public class Numbers1 {

	public static void main(String[] args) {

		int n = 95; // 95

		int rows = n - 4 / 10; // 9

		int rem = n - 4 % 10; // 1

		int k = 1;

		for (int i = 0; i < rows; i++) {
			while (k < n + 1) {

				for (int j = 1; j <= 10; j++) {
					if (i == 0 && k == 4 || k == n) {
						System.out.print(k + " ");
						k++;
						break;
					}
					System.out.print(k + " ");
					k++;

				}

				System.out.println();
			}
		}

	}

}
