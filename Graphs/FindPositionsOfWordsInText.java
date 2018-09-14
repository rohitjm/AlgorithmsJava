import java.util.*;

public class FindPositionsOfWordsInText {

	public static void main(String[] args) {
		System.out.println("Find all positions of words in text!!");
		String text = "this is a big ass string, and we bruh need to find the words in it.";
		String[] wordsToFind = {"bruh", "ass", "find"};
		int[][] res = findWordPositions(text, wordsToFind);
		print2DArr(res);
	}

	static int[][] findWordPositions(String text, String[] toFind) {
		Trie myTrie = new Trie();

		// Enter the whole text into the trie
		int i = 0;
		int wordStart = 0;;
		boolean inWord = false;
		StringBuffer currWord = new StringBuffer();

		while(i < text.length()) {
			if(Character.isLetter(text.charAt(i))) {
				currWord.append(String.valueOf(text.charAt(i)));
				if(!inWord) {
					inWord = true;
					wordStart = i;
				}
				i++;
			} else {
				if(inWord) {
					inWord = false;
				}
				String s = currWord.toString();			
				if(currWord.length() > 0) {
					System.out.println("inserting: "+s);
					myTrie.insert(s, wordStart);
					currWord.delete(0, currWord.length());	
				}				
				i++;
			}
		}

		int[][] res = new int[10][10];
		for(int k = 0; k < toFind.length; k++) {
			res[k] = myTrie.search(toFind[k]);
		}
		return res;
	}

	static void print2DArr(int[][] arr) {
    	System.out.println("");
    	for(int j = 0; j < arr.length; j++) {
	        for(int i = 0; i < arr[j].length; i++) {
	            System.out.println(arr[j][i]+" ");
	        }    		
    	}
    }


}

class Trie {
	TrieNode root;

	Trie() {
		root = new TrieNode(false);
	}

	void insert(String s, int position) {
		insertHelper(this.root, s, 0, position);
	}

	private void insertHelper(TrieNode currNode, String s, int i, int position) {
		if(i == s.length()) {
			currNode.wordEnd = true;
			currNode.wordPositions.add(position);
			return;
		} else {
			if(currNode.refs.containsKey(s.charAt(i))) {
				insertHelper(currNode.refs.get(s.charAt(i)), s, ++i, position);
			} else {
				TrieNode newNode = new TrieNode(false);
				currNode.refs.put(s.charAt(i), newNode);
				insertHelper(currNode.refs.get(s.charAt(i)), s, ++i, position);
			}			
		}
	}

	int[] search(String s) {
		int index = 0;
		return searchHelper(this.root, s, index);
	}

	private int[] searchHelper(TrieNode currNode, String s, int i) {
		if(i == s.length()) {
			if(currNode.wordEnd) {
				System.out.println("Found word: "+s);
				// convert Integer ArrayList into an int[] and return
				int[] arr = new int[currNode.wordPositions.size()];
				for(int k = 0; k < currNode.wordPositions.size(); k++) {
					arr[k] = currNode.wordPositions.get(k);
				}
				return arr;
			} else {
				int[] arr = new int[0];
				return arr;
			}
		} else {
			if(currNode.refs.containsKey(s.charAt(i))) {
				System.out.println("Found node for: "+s.charAt(i));
				return searchHelper(currNode.refs.get(s.charAt(i)), s, ++i);
			} else {
				int[] arr = new int[0];
				return arr;
			}			
		}
	}

	class TrieNode {
		boolean wordEnd;
		ArrayList<Integer> wordPositions = new ArrayList<Integer>();
		HashMap<Character, TrieNode> refs;
		TrieNode(boolean wordEnd) {
			this.wordEnd = wordEnd;
			refs = new HashMap<Character, TrieNode>();
		}
	}

}

