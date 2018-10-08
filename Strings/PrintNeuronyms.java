import java.util.*;

public class PrintNeuronyms {

	public static void main(String[] args) {

		System.out.println("Print all the Neuronyms for a String!!");

		String s = "nailed";
		String[] res = printNeuroUtil(s);

		for(int j = 0; j < res.length; j++) {
			System.out.print(res[j]+" ");			
		}
	}

	static String[] printNeuroUtil(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		printNeuro(s, 0, s.length()-1, map);
		String[] res = new String[map.size()];
		int i = 0;

		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			res[i] = entry.getKey();
			i++;
		}

		return res;
	}

	static void printNeuro(String s, int start, int end, HashMap<String, Integer> map) {

		if((end - start - 1) < 2) {
			return;
		}

		StringBuffer buff = new StringBuffer();

		for(int i = 0; i <= start; i++) {
			buff.append(s.charAt(i));
		}

		buff.append(end-start-1);
		
		for(int j = end; j < s.length(); j++) {
			buff.append(s.charAt(j));
		}

		if(!map.containsKey(buff.toString())) {
			map.put(buff.toString(), 1);
		}

		printNeuro(s, start+1, end, map);
		printNeuro(s, start, end-1, map);
	}

}