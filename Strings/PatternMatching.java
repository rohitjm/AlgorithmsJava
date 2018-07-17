import java.util.*;

public class PatternMatching {
	
	public static void main(String[] args) {
		System.out.println("Pattern matching! Naive and KMP");
		String string = "Our business is our business, none of your business";
		String pattern = "business";
		printArray(KMP(string, pattern));
	}

	static int[] findPattern_Naive(String t, String p) {

        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int k = 0;
        int saveTheFirst = -1;
        // res.set(0, saveTheFirst);
        res.add(-1);
        char[] big = t.toCharArray();
        char[] small = p.toCharArray();
        char first = small[0];
        
        if(small.length > big.length) {
        	return convertIntegers(res);
        }
        
        for(int i = 0; i < big.length; i++) {
            if(big[i] == first) {
                int j = 0;
                saveTheFirst = i;
                while((big[i] == small[j]) && i < big.length) {
                    i++;
                    j++;
                    if(j == small.length-1) {
                    	res.set(k, saveTheFirst);
                		k++;
                		break;
                	}
                }

            }


        }

        return convertIntegers(res);
	}

	static int[] KMP(String s, String p) {
		
		// Create the lps from the pattern
		int sLen = s.length();
		int pLen = p.length();
		int[] lps = new int[pLen];
		ArrayList<Integer> resList = new ArrayList<Integer>();
		int k = 0; // index for result array
		int i = 0; // index for walking through pattern
		int j = 1; // index for walking through lps
		lps[0] = 0;
		while(j < pLen) {
			if(p.charAt(i) == p.charAt(j)) {
				i++;
				lps[j] = i;
				j++;
			} else {
				if(i != 0) {
					i = lps[i-1];	
				} else {
					lps[j] = i;
					j++;
				}			
			}
		}

		// Use to find the matching pattern
		int m = 0; // index for walking through string
		int n = 0; // index for walking through pattern to find
		while(m < sLen) {
			if(s.charAt(m) == p.charAt(n)) {
				m++;
				n++;
			}
			if(n == pLen) {
				resList.add(m-n);
				n = lps[n-1];
			}
			else if(s.charAt(m) != p.charAt(n)) {
				if(n != 0) {
					n = lps[n-1];
				} else {
					m = m+1;
				}
			}
		}

		// Do Arraylist to array nonsense
		if(resList.isEmpty()) {
			resList.add(-1);
		}
		int[] res = convertIntegers(resList);

		return res;
	}

	static void printArray(int[] arr) {
    	System.out.println("");
    	for(int i = 0; i < arr.length; i++) {
    		System.out.println(arr[i]+" ");
    	}
    }

    public static int[] convertIntegers(List<Integer> integers) {
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
}