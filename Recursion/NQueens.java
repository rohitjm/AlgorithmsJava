public class NQueens {
	public static void main(String[] args) {
		System.out.println("NQueens Bro");
		int[] arr = nQueensMain(4);
		printArrayOnOneLine(arr, 0);
	}

	static int[] nQueensMain(int n) {
		int[] placement = new int[n];
		nQueens(placement, 0);
		return placement;	
	}

	static boolean nQueens(int[] placement, int r) {
		if(r == placement.length) {
			return true;
		}
		// iterate through possible placements for the column
		for(int i = 0; i < placement.length; i++) {
			if((ifSafe(placement, r, i)) && nQueens(placement, r++)) {
				return false;
			} else {
				return false;
			}
		}
		return false;
	}

	//check if the potential placement is safe
	static boolean ifSafe(int[] placement, int row, int column) {
		for(int j = 0; j < row; j++) {
			if(placement[j] == column) {
				return false;
			}
			int columnDiff = column - placement[j];
			int rowDiff = row - j;
			if(columnDiff == rowDiff) {
				return false;
			}
		}
		return false;	
	}

	static void printArrayOnOneLine(int[] arr, int x) {
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);	
		}		
	}
}
