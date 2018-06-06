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
		System.out.println(maxPathsMain(grid));
	}

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

}