import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class program {
    public static int countMoves(char matrix[][], int calculated[][], int startRow, int startCol, int endRow, int endCol) {
		int matrixRows = matrix.length;
		if (matrixRows < 1) return -2;
		int matrixCols = matrix[0].length;
		if (matrixCols < 1) return -2;
		  	
		if (endRow < 0 || endRow >= matrixRows) return -2;
		if (endCol < 0 || endCol >= matrixCols) return -2;
		 	
		if (startRow < 0 || startRow >= matrixRows) return -2;
		if (startCol < 0 || startCol >= matrixCols) return -2;
		  	
		if (matrix[endRow][endCol] != '0') return -2;		//block the dst.


		for (int i = 0; i < matrixRows; i++)
			Arrays.fill(calculated[i], -2);
		  	
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new program().new Point(startRow, startCol));

		calculated[startRow][startCol] = 0;

		Point[] moves = {new program().new Point(1, 0), new program().new Point(-1, 0),
						new program().new Point(0, 1), new program().new Point(0, -1)};

		while (!queue.isEmpty()) {
			Point point = queue.poll();

		  	for (int i = 0; i < moves.length; i++) {
		  		Point move = moves[i];
		  		int newRow = point.getRow() + move.getRow();
		  		int newCol = point.getCol() + move.getCol();

		  		if (newRow < 0 || newRow >= matrixRows) continue;	// out of matrix


		  		if (newCol < 0 || newCol >= matrixCols) continue;	// out of matrix


		  		if (matrix[newRow][newCol] != '0') continue;		// move blocked


		  		if (calculated[newRow][newCol] >= 0) continue;	    // visited


		  			
		  		calculated[newRow][newCol] = calculated[point.getRow()][point.getCol()] + 1;
		  		if (newRow == endRow && newCol == endCol) return calculated[newRow][newCol];	//if find the result.


		  		queue.add(new program().new Point(newRow, newCol));
		 	}
		}
		  	
		return calculated[endRow][endCol];
	}

	public static int getMoves(char matrix[][], char pattern[][], int endRow, int endCol) {
	  	int maxMoves = -1;
		  	
	  	int matrixRows = matrix.length;
	  	if (matrixRows < 1) return maxMoves;
	  	int matrixCols = matrix[0].length;
	  	if (matrixCols < 1) return maxMoves;
	  	int patternRows = pattern.length;
	  	if (patternRows < 1) return maxMoves;
	  	int patternCols = pattern[0].length;
	  	if (patternCols < 1) return maxMoves;
		  	
	  	if (matrixRows < patternRows || matrixCols < patternCols) return maxMoves;
		  	
	  	int robotRow = -1;
	  	int robotCol = -1;
	  	for (int i = 0; i < patternRows; i++) {
	  		for (int j = 0; j < patternCols; j++) {
	  			if (pattern[i][j] == '2') {
	  				robotRow = i;
	  				robotCol = j;
	  				pattern[i][j] = '0';
	  			}
	  		}
	  	}
		  	
	  	if (robotRow == -1) return maxMoves;		//not found robot.


		  	
	  	int calculated[][] = new int[matrixRows][];
	  	for (int i = 0; i < matrixRows; i++) 
	  	    calculated[i] = new int[matrixCols];

	  	for (int i = 0; i < matrixRows - patternRows; i++) {
			for (int j = 0; j < matrixCols - patternCols; j++) {
	  			int k, l;
	  			for (k = 0; k < patternRows; k++) {
	  				for (l = 0; l < patternCols; l++) {
	  					if (matrix[i+k][j+l] != pattern[k][l]) {
	  						break;
	  					}
	  				}
	  				
	  				if (l != patternCols) break;
	  			}

	  			if (k == patternRows) {
	  				int startRow = i + robotRow;
	  				int startCol = j + robotCol;
		  				
	  				int moveCount = countMoves(matrix, calculated, startRow, startCol, endRow, endCol);
	  				if (moveCount < 0) return -2;
	  				maxMoves = Math.max(maxMoves, moveCount);
	  			}
	  		}
	  	}
		  	
	  	return maxMoves;
    }    

    public static void main(String[] args) {
        try {
            // Read input from stdin, write output to stdout

	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String numberPattern = in.readLine();
	        String endPoints = in.readLine();
	    
    	    String data[] = numberPattern.split(" ");
	        int matrixRows = Integer.valueOf(data[0]);
	        int patternRows = Integer.valueOf(data[2]);

    	    data = endPoints.split(" ");
	        int endRow = Integer.valueOf(data[0]) - 1;
	        int endCol = Integer.valueOf(data[1]) - 1;
	    
	        char matrix[][] = new char[matrixRows][];
    	    for (int i = 0; i < matrixRows; i++) {
	          	String line = in.readLine();
	          	matrix[i] = line.toCharArray();
    	    }
	    
	        char pattern[][] = new char[patternRows][];
	        for (int i = 0; i < patternRows; i++) {
	      	    String line = in.readLine();
    	      	pattern[i] = line.toCharArray();
	        }
	      	
	        System.out.println(getMoves(matrix, pattern, endRow, endCol));
        } catch (Exception e) {
            System.out.println("-1");
        }
    }

	class Point {
		private int row = 0;
		private int col = 0;

		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		int getRow() { return row; }
		int getCol() { return col; }
	}
}