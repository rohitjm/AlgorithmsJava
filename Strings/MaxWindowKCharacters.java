import java.util.*;

public class MaxWindowKCharacters {
	
	public static void main(String[] args) {

		System.out.println("Find max window w/ K distinct characters!!");
		String s = "ACCBBST";	
		String t = "AAAAAAAAAAAAAAAC";	
		String j = "C";	
		String k = "ABCDEF";	

		System.out.println(findMinWindow(j, 1));
	}

	static int findMinWindow(String s, int k) {

		// HashMap w/ count of the characters, when you reach all chars atleast 1. note the start and end indcies

		// Move slow till 1 drops out

		// Move fast till that one is in the set again


		// fast and slow runner pattern
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int fast = 0;
		int slow = 0;
		int maxLength = 0;
		int currVal = 0;

		for(; fast < s.length(); fast++) {

			if(hm.containsKey(s.charAt(fast))) {
				currVal = hm.get(s.charAt(fast));
				hm.put(s.charAt(fast), currVal++);
			} else {
				hm.put(s.charAt(fast), 1);
			}

			while(hm.size() > k) {
				if(hm.containsKey(s.charAt(slow))) {
					currVal = hm.get(s.charAt(slow));
					if(currVal == 1) {
						hm.remove(s.charAt(slow));
					} else {
						hm.put(s.charAt(slow), currVal--);	
					}
				}
				slow++;
			}

			// int diff = s.substring(slow, fast).length();
			int diff = fast-slow+1;

			//System.out.println(diff);

			if(diff > maxLength) {
				maxLength = diff;
			}
		}

		if(hm.size() < k) {
			return -1;
		} else {
			return maxLength;
		}
	}
}