import java.util.*;

public class BoggleSolverTrie {

	public static void main(String[] args) {

		System.out.println("Boogle Solver!!!!");

		String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

		char[][] boggle = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};

        findWords(dictionary, boggle);               
	}

	static void findWords(String[] dictionary, char[][] board) {

        TrieNode root = new TrieNode();

        for(int i = 0; i < dictionary.length; i++) {
            insertWord(root, dictionary[i], 0);
        }

        // Verify that the dictionary words have been added to to the Trie
        // for(int i = 0; i < dictionary.length; i++) {
        //     searchWord(root, dictionary[i]);
        //     System.out.println();
        // }

        StringBuffer buff = new StringBuffer();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // pass filled Trie and board to traverse function to search for words in board
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(root.children.containsKey(board[i][j])) {
                    buff.append(board[i][j]);
                    traverse(i, j, buff, visited, board, root.children.get(board[i][j]));
                }
            }
        }
	}

	static void traverse(int i, int j, StringBuffer buffer, boolean[][] visited, char[][] board, TrieNode root) {

        if(root.endOfWord) {
            System.out.println(buffer.toString());
        }
        System.out.println(buffer.toString());


        visited[i][j] = true;

        for(int k = i-1; k < i+1 && k < board.length; k++) {
            for(int l = j-1; l < j+1 && l < board[i].length; l++) {
                
                // if(checkInBoard(k, l, board)) {
                //     System.out.println("i: "+i+" j: "+j);
                //     System.out.println(visited[k][l]);
                //     System.out.println(root.children.containsKey(board[k][l]));                    
                // }

                if(checkInBoard(k, l, board) && !visited[k][l] && root.children.containsKey(board[k][l])) {                    
                    buffer.append(board[k][l]);
                    traverse(k, l, buffer, visited, board, root.children.get(board[k][l]));
                }
            }
        }

        buffer.deleteCharAt(buffer.length()-1);
        visited[i][j] = false;
	}

	static boolean checkInBoard(int k, int l, char[][] board) {
		if( k < board.length && k >= 0 && l >= 0 && l < board[k].length) {
			return true;
		}
		return false;
	}

    static void insertWord(TrieNode root, String toInsert, int i) {
        if(i > toInsert.length()-1) {
            root.endOfWord = true;
            return;
        }
        if(root.children.containsKey(toInsert.charAt(i))) {
            insertWord(root.children.get(toInsert.charAt(i)), toInsert, ++i);
        }
        TrieNode newNode = new TrieNode();
        root.children.put(toInsert.charAt(i), newNode);
        insertWord(root.children.get(toInsert.charAt(i)), toInsert, ++i);
    }

    // static void insertWord(TrieNode root, String toInsert) {
    //     int n = toInsert.length();
    //     for(int i = 0; i < n; i++) {
    //         if(root.children.containsKey(toInsert.charAt(i))) {
    //             root = root.children.get(toInsert.charAt(i));
    //         } else {
    //             TrieNode newNode = new TrieNode();
    //             root.children.put(toInsert.charAt(i), newNode);
    //             root = newNode;
    //         }
    //         if(i == n-1) {
    //             root.endOfWord = true;
    //         }
    //     }
    // }

    static void searchWord(TrieNode root, String toFind) {

        int n = toFind.length();

        for(int i = 0; i < n; i++) {
            if(root.children.containsKey(toFind.charAt(i))) {
                System.out.print(toFind.charAt(i)+" ");
                root = root.children.get(toFind.charAt(i));
            }
            if(root.endOfWord) {
                System.out.print("*");
            }
        }
    }
}

class TrieNode {
    boolean endOfWord;
    HashMap<Character, TrieNode> children;

    TrieNode() {
        endOfWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}

