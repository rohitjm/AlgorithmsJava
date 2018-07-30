import java.util.*;

public class SmallestStringConcatenation {
	
	public static void main(String[] args) {
		System.out.println("Competitive Programming - Smallest String Concatenation!");
		String[] arr = {"xxaaa", "xxaa", "xxa", "xx", "x"};
		System.out.println(stringConcat(arr));
	}


	static String stringConcat(String[] arr) {
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr, new java.util.Comparator<String>() {
	    @Override
	    	public int compare(String s1, String s2) {
	        // TODO: Argument validation (nullity, length)
	        	return s2.length() - s1.length();// comparision
	    	}
		});

		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();
	}

}