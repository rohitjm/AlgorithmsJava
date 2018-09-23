public class PrintPalindromicPartitions {
	
	public static void main(String[] args) {

		System.out.println("Print all palindromic partitions of a String!");
		printPal("abracadabra");
		
	}

	static ArrayList<ArrayList<String>> printPal(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp, int index) {

		int len = s.length();
		ArrayList<String> curr = new ArrayList<String>(temp);
		String str = "";
		int i = index;

		for(; i < len; ++i) {

			str = str+s.charAt(i);

			if(isPalindrome(str)) {
				curr.add(str);
				if(i + 1 < len) {
					v = printPal(v, s, curr, index+1);
				} else {
					v.add(curr);
				}
			}

		}
		return v;
	}

	static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length-1;

		if(i == j) {
			return true;
		}

		while(j > i) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}



}