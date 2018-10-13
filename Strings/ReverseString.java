public class ReverseString{

	public static void main(String args[]) {
		System.out.println("Reverse String!");
		String s = "reverseme";
		System.out.println(reverse(s));
	}

	static String reverse(String s) {
		char[] k  = new char[s.length()];
		int j = 0;
		for(int i = s.length()-1; i != 0; i--) {
			k[j] = s.charAt(i);
			j++;
		}
		String rev = new String(k);
		return rev;
	}


}