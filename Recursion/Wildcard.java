import java.util.*;

public class Wildcard {

	public static void main(String[] args) {

		System.out.println("Wildcard!!");

		String s = "10?";
		char[] curr = new char[s.length()];
		ArrayList<String> res = new ArrayList<String>();

		genWildcard(s, 0, curr, res);

		printArrayList(res);
	}

	static void genWildcard(String s, int i, char[] curr, ArrayList<String> res) {
		if(i > s.length()-1) {
			String done = new String(curr);
			res.add(done);
			return;
		}

		int index = i;
		while(s.charAt(index) != '?' && index < s.length()) {
			System.out.println("index: "+index+" char at: "+s.charAt(index));
			curr[index] = s.charAt(index);
			index+=1;
		}
		System.out.println("index out: "+index);
		curr[index] = '1';
		genWildcard(s, index+1, curr, res);
		curr[index] = '0';
		genWildcard(s, index+1, curr, res);
	}

	static void printArrayList(ArrayList<String> arr) {
        System.out.println("");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
    }

}