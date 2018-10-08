public class ReverseIndex {

	public static void main(String[] args) {

		System.out.println("Minimum Window SubString!!");

		String s = "AYZABOBECODXBANC";
		String t = "ABC";

		System.out.println(findMinWindow(s,t));
	}

	static String findMinWindow(String s, String t) {	
		int fast = 0;
		int slow = 0;
		HashMap<Character, Integer> fullMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> currMap = new HashMap<Character, Integer>();

		for(int i = 0; i < t.length(); i++) {
			if(fullMap.contains(t.charAt(i))) {
				currVal = fullMap.get(t.charAt(i));
				currVal++;
				fullMap.put(t.charAt(i), currVal);
			} else {
				fullMap.put(t.charAt(i), 1);
			}			
		}

		while(fast != s.length()) {
			while(mapUtil(currMap, fullMap) != '') {
				if(currMap.contains(t.charAt(i))) {
					currVal = currMap.get(t.charAt(i));
					currVal++;
					currMap.put(t.charAt(i), currVal);
				} else {
					currMap.put(t.charAt(i), 1);
				}
				fast++;
			}


			while(!fullMap.contains(t.charAt(slow))) {
				slow++;
			}
			// push the results to the res array for now just printing so we know the windows are being found
			System.out.print("fast: "+fast+" slow: "+slow);
			// move the slow up one so that a character drops out
			dropCharVal = currMap.get(s.charAt(slow));
			dropCharVal--;
			currMap.put(s.charAt(slow), dropCharVal);
			slow++
		}





	}

	// 	enter map and return which char arent in the window, if any, if none return ''; 
	static Character mapUtil(HashMap<Character, Integer> currMap, HashMap<Character, Integer> fullMap) {
		// loop through fullMap and check if the value for the key in currmap matches the value in fullMap, if it doesnt push the key(Charactet) to the res array
	}


}