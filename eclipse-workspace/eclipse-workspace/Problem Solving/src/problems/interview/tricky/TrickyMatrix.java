package problems.interview.tricky;

public class TrickyMatrix {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, 
						 { 5, 6, 7, 8 }, 
						 { 9, 10, 11, 12 }, 
						 { 13, 14, 15, 16 } };

		System.out.println("Length : " + matrix.length);

		int n = matrix.length;

		int search = 19;
		boolean flag = false;

		int length = n;
		int it = matrix[3][1];
		n = n - 1;
		int i = 0;

		while (n >= 0) {

			if (i < length) {
				if (matrix[n][i] == search) {
					flag = true;
					System.out.println("Found " + search + " at " + "( " + n + ", " + i + " )");
					break;
				} else {

					if (matrix[n][i] < search)
						i++;
					else
						n--;

				}
			} else {
				System.out.println("Not Found");
				break;
			}

		}
	}

}
