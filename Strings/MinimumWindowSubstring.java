import java.util.*;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		System.out.println("Minimum Window Substring!!");
		
		// String t = "AYZABOBECODXBANC";
		// String s = "ABC";

		// String t = "acdbddddddddaaaaaaaadabbbba";
		// String s = "baad";

		// String t = "ADOBECODEBANC";
		// String s = "ZYD";	

		String t = "A";
		String s = "A";	

		System.out.println(findMinWindow(t,s));
	}

	static String findMinWindow(String t, String s) {

		// HashMap w/ count of the characters, when you reach all chars atleast 1. note the start and end indcies
		// Move slow till 1 drops out
		// Move fast till that one is in the set again
		// fast and slow runner pattern

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		int fast = 0;
		int slow = 0;
		int currLen = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;
		int minEnd = 0;
		int currVal = 0;

		for(int i = 0; i < s.length(); i++) {
			if(hm.containsKey(s.charAt(i))) {
				currVal = hm.get(s.charAt(i));
				currVal++;
				hm.put(s.charAt(i), currVal);
			} else {
				hm.put(s.charAt(i), 1);
			}
		}

		for(; fast < t.length(); fast++) {
			if(hm.containsKey(t.charAt(fast))) {
				currVal = hm.get(t.charAt(fast));
				currVal--;
				hm.put(t.charAt(fast), currVal);
			}

			while(keysBelowZero(hm)) {
				currLen = fast - slow +1;				
				if(currLen < minLen && keysAreZero(hm)) {
					minLen = currLen;
					minStart = slow;
					minEnd = fast;
				}
				if(hm.containsKey(t.charAt(slow))) {
					currVal = hm.get(t.charAt(slow));
					currVal++;
					hm.put(t.charAt(slow), currVal);
				}
				slow++;				
			}
		}

		System.out.println("minStart: "+minStart+" minEnd: "+minEnd);
		System.out.println("fast: "+fast+" slow: "+slow);
		if(fast == t.length() && slow == 0) {
			return "";
		} else {
			return t.substring(minStart, minEnd+1);	
		}		
	}

	static boolean keysAreZero(HashMap<Character, Integer> hm) {
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() != 0) {				
				return false;
			}
		}
		return true;
	}

	static boolean keysBelowZero(HashMap<Character, Integer> hm) {
		for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if(entry.getValue() > 0) {				
				return false;
			}
		}
		return true;
	}

}