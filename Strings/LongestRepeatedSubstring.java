import java.util.*;

/**
The real way to do this is to learn how to do a Suffix Tree
**/

public class LongestRepeatedSubstring {

	public static void main(String[] args) {
		System.out.println("Given a string, find the longest repeated substring in it.");
		System.out.println(longestRepeatedMain("fgqklmpbkl"));
	}

	static String longestRepeatedMain(String s) {
		char[] sArr = s.toCharArray();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		char[] ex = new char[sArr.length];

		longestRepeated(sArr, 0, ex, 0, map);

		Iterator it = map.entrySet().iterator();
		String greatest = "";
		int greatestCount = 0;
   		while (it.hasNext()) {
        	Map.Entry pair = (Map.Entry)it.next();
        	if(pair.getValue() > greatestCount) {
        		greatestCount = pair.getValue();
        		greatest = pair.getKey();
        	}        	
    	}

    	return greatest;
	}

	static void longestRepeated(char[] init, int i, char[] next, int j, HashMap<String, Integer> map) {

		if(i == init.length) {
			String s = new String(next);
			int curr = map.get(s);
			curr += 1;
			map.put(s, curr);
			return;
		}

		longestRepeated(init, i++, next, j, map);
		next[j] = init[i];
		longestRepeated(init, i++, next, j++, map);
	}


}