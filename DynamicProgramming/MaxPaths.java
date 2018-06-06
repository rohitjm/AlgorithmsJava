public class MaxPaths{

	public static void main(String[] args) {
		System.out.println("Max Paths!");
		int[][] grid = new int[4][4];
		int[] filler = {3,2,7,4,5,3,5,10,6,8,9,3,3,2,1,9};;
		int k = 0;
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = filler[k];
				k++;
			}
		}
		printArray(grid);
		// System.out.println(maxPathsMain(grid));
		System.out.println(maxPathsDP(grid));
	}

	// caller function for recursive solution
	static int maxPathsMain(int[][] grid) {
		return maxPaths(grid, 0 ,0);
	}

	static int maxPaths(int[][] grid, int i, int j) {
		int n = grid.length;
		int m = grid[i].length;
		int currVal = grid[i][j];
		if(i == n-1 && j == m-1) {
			return currVal;
		}
		if(i == n-1 && j < m-1) {
			return currVal + maxPaths(grid, i, j+1);
		}
		if(i < n-1 && j == m-1) {
			return currVal + maxPaths(grid, i+1, j);	
		}
		return currVal + Math.max(maxPaths(grid, i+1, j), maxPaths(grid, i, j+1));
	}

	static void printArray(int[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println("");
		}	
	}

	// DP Solution - builds DP table from the bottom up and returns the [0][0] element
	static int maxPathsDP(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] dpTable = new int[n][m];

		for(int i = n-1; i >= 0; --i) {
			for(int j = m-1; j >= 0; --j) {
				int currVal = grid[i][j];
				if(i == n-1 && j == m-1) {
					dpTable[i][j] = grid[i][j];
				} else if(i == n-1) {
					dpTable[i][j] = currVal + dpTable[i][j+1];
				} else if(j == m-1) {
					dpTable[i][j] = currVal + dpTable[i+1][j];
				} else {
					dpTable[i][j] = currVal + Math.max(dpTable[i+1][j], dpTable[i][j+1]);
				}

			}
		}
		return dpTable[0][0];
	}

}