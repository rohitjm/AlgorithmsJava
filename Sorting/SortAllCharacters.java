import java.util.*;

public class SortAllCharacters {

	public static void main(String[] args) {
		System.out.println("Sort All the Characters in the Array!!");
		String s = "this is a test for my code.";
		String res = sortChars(s);
		System.out.println(res);
	}

	// This is an implementaion of a technique called Counting Sort
	static String sortChars(String s) {

		//generate a HashMap w/ all the ASCII Characters
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int c=0; c<=255; c++) {
    		map.put((char)c, 0);
   		} 
   		System.out.println(map.get('a'));
		// System.out.println(map.size());

		//iterate through the input String and keep a count of the # of times a character appears
		for(int i=0; i < s.length(); i++) {
			Character currChar = s.charAt(i);
			Integer currVal = map.get(currChar);
			currVal++;
    		map.put(currChar, currVal);
   		}

		//iterate throught the HashMap and increment every count by the sum of the counts preceding it

		char[] s_arr = s.toCharArray();

		for(int j=0; j<=255; j++) {
    		Integer count = map.get((char)j);
    		int index = 0;
    		for(int k = 0; k < count; k++) {
    			s_arr[k] = (char)j;
    			System.out.println((char)j);
    			index++;
    		}
   		} 

   		String resString = new String(s_arr);

		//iterate through the HashMap and save the char to the old array, from starting to end
		return resString;
	}

}