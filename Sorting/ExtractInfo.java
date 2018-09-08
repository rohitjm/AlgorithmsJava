import java.util.*;

public class ExtractInfo {

	public static void main(String[] args) {

		System.out.println("Extract Info!!");
		String[] input = {
			"key1 abcd",
			"key2 zzzz",
			"key1 hello",
			"key3 world",
			"key1 hello"
		};

		String[] input2 = {
			"mark zuckerberg",
			"tim cook",
			"mark twain",
		};

		String[] res = extract(input2);
		printArr(res);
	}

	static String[] extract(String[] input) {

		HashMap<String, Integer> count = new HashMap<String, Integer>();
		HashMap<String, String> maxTrack = new HashMap<String, String>();

		// Iterate through input
		for(int i = 0; i < input.length; i++) {

			String[] keyVal = input[i].split(" ");
			String key = keyVal[0];
			String val = keyVal[1];

			// if the key is in the count hash, increment the count, otherwise add it
			if(count.containsKey(key)) {
				count.put(key, count.get(key)+1);
			} else {
				count.put(key, 1);
			}

			// if the val is lexicographically greater than the val in maxTrack, then replace it, else just add the kay and value
			if(maxTrack.containsKey(key)) {
				if(val.compareTo(maxTrack.get(key)) > 0) {
					maxTrack.put(key, val);
				}
			} else {
				maxTrack.put(key, val);
			}

		}

		String[] res = new String[count.size()];
		int j = 0;
	    for (Map.Entry<String, Integer> entry : count.entrySet()) {
	    	String thisKey = entry.getKey();
	    	res[j] = thisKey+":"+entry.getValue()+","+maxTrack.get(thisKey);
	        j++;
	    }
	    return res;
	}

	static void printArr(String[] arr) {
    	System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
    }

}