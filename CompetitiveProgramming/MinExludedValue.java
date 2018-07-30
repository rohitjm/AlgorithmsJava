import java.util.*;
import java.io.*;

public class MinExludedValue{

	public static void main(String[] args) {

		System.out.println("Competitive Programming - Minimum Exluded Value!");
		int[] arr = {1,1,1,1,1};
		System.out.println(findMinExluded(arr));
	}

	static int findMinExluded(int[] arr) {

		ArrayList<Integer> libr = new ArrayList<Integer>();
		int[] current = new int[arr.length];
		printSubSets(arr, 0, current, 0, libr);

		int curr = 1;
		while(curr < Integer.MAX_VALUE) {
			if(!libContains(libr, curr)) {
				return curr;
			}
			curr++;			
		}

		return -1;
	}

	static void printSubSets(int[] a, int i, int[] s, int j, ArrayList<Integer> lib) {
		int n = a.length;
		if(i == n) {
			Integer sum = 0;
			for(int x = 0; x < s.length; x++) {
				sum += s[x];
			}
			lib.add(sum);
		}
		printSubSets(a, i+1, s, j);
		s[j] = a[i];
		printSubSets(a, i+1, s, j+1);
		return;
	}

	static boolean libContains(ArrayList<Integer> lib, int n) {
		for(int i = 0; i < lib.size(); i++) {
			if(lib.get(i) == n) {
				return true;
			}
		}
		return false;
	}
}