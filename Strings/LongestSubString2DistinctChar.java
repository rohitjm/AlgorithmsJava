import java.util.*;

public class LongestSubString2DistinctChar {

	public static void main(String[] args) {
		System.out.println("Longest SubString w/ Exactly 2 Distinct Characters!!");
		// String s = "eceba";
		String s = "ababababa";
		// String s = "baabcbab";
		// String s = "abcdef";
		System.out.println("Longest substring in "+s+" is "+findSubString(s));
	}

	static int findSubString(String s) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int currCount = 0;
		int maxCount = 0;
		int i = 0;

		while(i < s.length()) {
			if(i == 0 || s.charAt(i) != s.charAt(i-1)) {
				map.put(s.charAt(i), i);
			}
			if(map.size() > 2) {
				Character lastChar = s.charAt(i-1);
				currCount = i - map.get(lastChar);

				// loop through map and remove anything that isnt s.charAt(i) or s.charAt(i-1);
				Iterator<Map.Entry<Character, Integer>> entryIt = map.entrySet().iterator();
				while(entryIt.hasNext()) {
					Map.Entry<Character, Integer> entry = entryIt.next();
					if(!entry.getKey().equals(s.charAt(i)) && !entry.getKey().equals(s.charAt(i-1))) {
						entryIt.remove();
					}
				}
			}
			currCount++;
			if(currCount > maxCount) {
				maxCount = currCount;
			}
			i++;
		}
		if(map.size() == 1) {
			maxCount = 0;
		}
		return maxCount;
	}
}