package problems.cts.arrays;

public class Sudoku {

	static final int N = 9;
	
	public static void main(String[] args) {
		
	int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
		                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
		                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
		                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
		                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
		                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
		                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
		                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
		                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		if (solveSudoku(grid, 0, 0))
		   print(grid);
		else
		   System.out.println("No Solution exists");

	}

	private static void print(int[][] grid) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static boolean solveSudoku(int[][] grid, int row, int col) {
		
		if(row == N) {
			print(grid);
			return true;
		}
		
		if(col == N) {
			return solveSudoku(grid, row+1, 0);
		}
		
		if(grid[row][col] != 0) {
			return solveSudoku(grid, row, col+1);
		}
		
		for(int num=1; num<=N; num++) {
			if(isSafe(grid, row, col, num)) {
				
				grid[row][col] = num;
				
				boolean solveSubproblem = solveSudoku(grid, row, col+1);
				
				if(solveSubproblem ==  true)
					return true;
			}
		}
		grid[row][col] = 0;
		return false;
	}

	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		
		for(int k=0; k<N; k++) {
			if(grid[k][col] == num || grid[row][k] == num)
				return false;
		}
		
		int sx = (row/3)*3;
		int sy = (col/3)*3;
		
		for(int x=sx; x<sx+3; x++) {
			for(int y=sy; y<sy+3; y++) {
				if(grid[x][y] == num) {
					return false;
				}
			}
		}
		
		return true;
	}

}
