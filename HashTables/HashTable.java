
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class HashTable {

	public static class LinkedHashEntry {
		private int key;
		private int value;
		private LinkedHashEntry next;

		LinkedHashEntry(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LinkedHashEntry getNext() {
			return next;
		}

		public void setNext(LinkedHashEntry next) {
			this.next = next;
		}
	}

	public static class HashMap {
		// Hard coding the size here, can also take this as a parameter on initialization
		private final static int TABLE_SIZE = 128;

		LinkedHashEntry[] table;

		HashMap() {
			table = new LinkedHashEntry[TABLE_SIZE];
			for(int i = 0; i < TABLE_SIZE; i++) {
				table[i] = null;
			}
		}

		public int get(int key) {
			int hash = (key % TABLE_SIZE);
			if(table[hash] == null) {
				return -1;
			} else {
				LinkedHashEntry entry = table[hash];
				while(entry != null) {
					if(entry.key == key) {
						return entry.getValue();
					}
					entry = entry.getNext();
				}
				return -1;
			}
		}

		public void put(int key, int value) {
			int hash = (key % TABLE_SIZE);
			LinkedHashEntry newEntry = new LinkedHashEntry(key, value);
			if(table[hash] == null) {
				table[hash] = newEntry;
			} else {
				LinkedHashEntry current = table[hash];
				while(current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(newEntry);
			}
		}

		public void remove(int key) {
			int hash = (key % TABLE_SIZE);
			if(table[hash] == null) {
				System.out.println("No value found for key.");
			} else {
				LinkedHashEntry entry = table[hash];
				if(entry.key == key){
					table[hash] = entry.next;
					entry = null;
					return;
				}
				while(entry != null) {
					if(entry.next.key == key) {
						entry.next = entry.next.next;
						return;
					}
					entry = entry.next;
				}
			}
		}
	}

	public static void main(String []args) {
		HashMap myHT = new HashMap();
		myHT.put(2,10);
		System.out.println(myHT.get(2));
		myHT.remove(2);
		System.out.println(myHT.get(2));
		myHT.remove(2);
	}

}
