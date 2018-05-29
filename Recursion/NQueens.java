import java.util.*;

public class NQueens {

	public static ArrayList<int[]> results = new ArrayList<int[]>();

	public static void main(String[] args) {
		System.out.println("NQueens Bro");
		nQueensMain(4);
		printResults(results);
	}

	static void nQueensMain(int n) {
		int[] placement = new int[n];
		nQueens(placement, 0);
		return;	
	}

	static boolean nQueens(int[] placement, int r) {
		if(r == placement.length) {
			results.add(placement);
			return true;
		}
		// iterate through possible placements for the column
		for(int i = 0; i < placement.length; i++) {
			placement[r] = i;
			boolean isSafe = ifSafe(placement, r);
			if(isSafe && nQueens(placement, r+1)) {
				return true;
			} 
		}
		return false;
	}

	//check if the potential placement is safe
	static boolean ifSafe(int[] placement, int row) {
		for(int j = 0; j < row; j++) {
			if(placement[j] == placement[row]) {
				return false;
			}
			int columnDiff = placement[row] - placement[j];
			int rowDiff = row - j;
			if(columnDiff == rowDiff) {
				return false;
			}
		}
		return true;	
	}

	static void printArrayOnOneLine(int[] arr, int x) {
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);	
		}		
	}

	static void printResults(ArrayList<int[]> results) {
		String[] resultsArr = new String[results.size()];
		for(int i = 0; i < results.size(); i++) {
			int[] thisResult = results.get(i);
			printArrayOnOneLine(thisResult, 0);
		}
	}
}
