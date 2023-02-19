package problems.eyList;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

	public static void main(String[] args) {

		
		  int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		  
		  int n = mat.length;
		  
		  printMatrix(mat);
		  
		  System.out.println();
		  
			/*
			 * rotateMatrix180(mat);
			 * 
			 * mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			 * 
			 * rotateMatrix90(mat);
			 * 
			 * System.out.println();
			 * 
			 * printMatrix(mat);
			 * 
			 * mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			 * 
			 * System.out.println();
			 * 
			 * rotateMatrix270(mat);
			 * 
			 * System.out.println();
			 * 
			 * printMatrix(mat);
			 * 
			 * mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
			 * 
			 * int row = n; int col = n;
			 * 
			 * spiralPrint(mat, 0, 0, row, col);
			 * 
			 * System.out.println();
			 */
		 

		int[][] matrix = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

		//maxSubmatrixSum(matrix);
		//printMatrix(mat);
		
		//To rotate 90 degree transpose and reverse once
		
		transpose(mat);
		System.out.println();
		reverse(mat);
		System.out.println();
		printMatrix(mat);

	}

	private static void transpose(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

	private static void reverse(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int k = matrix.length - 1;
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
				k--;
			}
		}
	}
	
	private static void reverseColumn(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int k = matrix.length - 1;
			for (int j = 0; j < matrix.length / 2; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[k][i];
				matrix[k][i] = temp;
				k--;
			}
		}
	}

	private static void maxSubmatrixSum(int[][] matrix) {

		int r = matrix.length;
		int c = matrix[0].length;

		int maxSubMatrix = 0;

		for (int i = 0; i < r; i++) {

			for (int j = 0; j < c; j++) {

				for (int k = i; k < r; k++) {

					for (int l = j; l < c; l++) {

						int sumSubMatrix = 0;

						for (int m = i; m <= k; m++) {

							for (int n = j; n <= l; n++) {

								sumSubMatrix += matrix[m][n];
							}
						}

						maxSubMatrix = Math.max(maxSubMatrix, sumSubMatrix);
					}
				}
			}
		}
		System.out.println("Max SubMatrix : " + maxSubMatrix);
	}

	private static void spiralPrint(int[][] mat, int i, int j, int m, int n) {

		// If i or j lies outside the matrix
		if (i >= m || j >= n) {
			return;
		}

		// Print First Row
		for (int p = i; p < n; p++) {
			System.out.print(mat[i][p] + " ");
		}

		// Print Last Column
		for (int p = i + 1; p < m; p++) {
			System.out.print(mat[p][n - 1] + " ");
		}

		// Print Last Row, if Last and
		// First Row are not same
		if ((m - 1) != i) {
			for (int p = n - 2; p >= j; p--) {
				System.out.print(mat[m - 1][p] + " ");
			}
		}

		// Print First Column, if Last and
		// First Column are not same
		if ((n - 1) != j) {
			for (int p = m - 2; p > i; p--) {
				System.out.print(mat[p][j] + " ");
			}
		}
		spiralPrint(mat, i + 1, j + 1, m - 1, n - 1);

	}

	private static void rotateMatrix270(int[][] mat) {

		int n = mat.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n; j++) {
				int temp = mat[j][n - i - 1];
				mat[j][n - i - 1] = mat[j][i];
				mat[j][i] = temp;
			}
		}

	}

	private static void printMatrix(int[][] mat) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(mat[i][j] + " ");

			System.out.println();
		}
	}

	private static void rotateMatrix90(int[][] mat) {

		int n = mat.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - 1 - j][i];
				mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
				mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
				mat[j][n - 1 - i] = temp;
			}
		}

	}

	private static void rotateMatrix180Print(int[][] mat) {

		int n = mat.length;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--)
				System.out.print(mat[i][j] + " ");

			System.out.println();
		}

	}

	private static void rotateMatrix180(int[][] data) {
		int rows = data.length;
		int cols = data[0].length;

		if (rows % 2 != 0) {
			// If N is odd reverse the middle row in the matrix
			reverseRow(data, data.length / 2);
		}

		// Swap the value of matrix [i][j] with [rows - i - 1][cols - j - 1] for half
		// the rows size.
		for (int i = 0; i <= (rows / 2) - 1; i++) {
			for (int j = 0; j < cols; j++) {
				int temp = data[i][j];
				data[i][j] = data[rows - i - 1][cols - j - 1];
				data[rows - i - 1][cols - j - 1] = temp;
			}
		}
	}

	private static void reverseRow(int[][] data, int index) {
		int cols = data[index].length;
		for (int i = 0; i < cols / 2; i++) {
			int temp = data[index][i];
			data[index][i] = data[index][cols - i - 1];
			data[index][cols - i - 1] = temp;
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		if (matrix.length == 0)
			return res;

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int columnBegin = 0;
		int columnEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && columnBegin <= columnEnd) {
			for (int i = columnBegin; i <= columnEnd; i++) {
				res.add(matrix[rowBegin][i]);
			}
			rowBegin++;

			for (int i = columnBegin; i <= columnEnd; i++) {
				res.add(matrix[i][columnEnd]);
			}
			columnEnd--;

			if (rowBegin <= rowEnd) {
				for (int i = columnEnd; i >= columnBegin; i++) {
					res.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;

			if (columnBegin <= columnEnd) {
				for (int i = rowEnd; i >= rowBegin; i++) {
					res.add(matrix[i][columnBegin]);
				}
			}
			columnBegin++;

		}

		return res;
	}

}
