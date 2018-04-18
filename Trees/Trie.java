import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(false);
	}

	public class TrieNode {
		HashMap<Character, TrieNode> references;
		boolean isCompleteWord;

		TrieNode() {
			references = new HashMap<Character, TrieNode>();
		}

		TrieNode(boolean isCompleteWord) {
			this.isCompleteWord = isCompleteWord; 
		}
	}

	public void insert(String toInsert) {
		TrieNode current = this.root;
		for(int i = 0; i < toInsert.length(); i++) {
			Character s = toInsert.charAt(i);
			if(current.references.get(s) != null) {
				current = current.references.get(s);
			} else {
				boolean isLast = (i+1 == toInsert.length());
				TrieNode nodeToAdd = new TrieNode(isLast);
				current.references.put(s, nodeToAdd);
			}
		}
	}

	public boolean search(String word) {
		TrieNode current = this.root;
		for(int i = 0; i < word.length(); i++) {
			Character s = word.charAt(i);
			if((current.isCompleteWord ==  true) && (i == word.length() - 1)) {
				return true;
			}
			if(current.references.get(s) != null) {
				current = current.references.get(s);
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String[]args) {
		Trie myTrie = new Trie();
		myTrie.insert("walk");
		myTrie.search("walk");
	}
}