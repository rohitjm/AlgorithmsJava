public class BoggleSolverNaive {

	public static void main(String[] args) {

		System.out.println("Boogle Solver!!!!");

		String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

		String[][] boogle = {{"G","I","Z"},
                       {"U","E","K"},
                       {"Q","S","E"}};

        findWords(dictionary, boogle);               
	}

	static String[] findWords(String[] dictionary, String[][] board) {
		boolean visited[][] = new boolean[board.length][board[0].length]; 
        for(int i=0; i < board.length; i++){ 
            for(int j=0; j <board[i].length; j++){ 
                StringBuffer buffer = new StringBuffer(); 
                traverse(i,j,buffer,visited,board); 
            } 
        } 

		return dictionary;
	}

	// traverse method will go through each path and save the  path to the Trie
	static void traverse(int i, int j, StringBuffer buffer, boolean[][] visited, String[][] board) {
		
        visited[i][j] = true; 
        buffer.append(board[i][j]); 

        if(buffer.toString().equals("GEEKS") || buffer.toString().equals("QUIZ")){ 
            System.out.println(buffer); 
        }
         
        for(int k = i-1; k <= i+1; k++){ 
            for(int l = j-1;l <= j+1; l++){
                if(checkInBoard(k,l,board) && visited[k][l] == false){ 
                    traverse(k,l,buffer,visited,board); 
                }                  
            } 
        } 
        buffer.deleteCharAt(buffer.length()-1); 
        visited[i][j] = false; 
	}

	static boolean checkInBoard(int k, int l, String[][] board) {
		if( k < board.length && k >= 0 && l >= 0 && l < board[k].length) {
			return true;
		}
		return false;
	}

}