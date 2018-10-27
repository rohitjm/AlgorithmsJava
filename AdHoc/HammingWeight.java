import java.util.*;

public class HammingWeight {
	
	public static void main(String[] args) {
		System.out.println("Get the Hamming Weight!!!");
		int[] arr = {2147483647,3};
		System.out.println(printCountOfBitsSet(arr));
		
		//System.out.println(printCountOfBitsSetHAM(arr)); ***DO NOT RUN - WILL CRASH HEAP
	}

	static int printCountOfBitsSet(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int res = 0;
		int currCount;

		for(int i = 0; i < arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				res += hm.get(arr[i]);
			} else {
				currCount = getBitCount(arr[i]);
				hm.put(arr[i], currCount);
				res += currCount;
			}
		}

		return res;
	}

	static int getBitCount(int num) {
		int onCount = 0;
		String binString = Integer.toBinaryString(num);
		for(int i = 0; i < binString.length(); i++) {
			if(binString.charAt(i) == '1') {
				onCount++;
			}
		}
		return onCount;
	}

	static int printCountOfBitsSetHAM(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int res = 0;
		int currCount = 0;

		// create lookup table w/ all the possible int values
		for(int j = 0; j <= Integer.MAX_VALUE; j++) {
			currCount = getBitCount(j);
			hm.put(j, currCount);
		}

		// iterate through input and lookup vals and add to res
		for(int i = 0; i < arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				res += hm.get(arr[i]);
			}
		}

		return res;
	}


}