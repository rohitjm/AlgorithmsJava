public class ParenSubstring {

	public static void main(String args[]) {

		System.out.println("Competitive Programming - Parentheses ParenSubstring");
		String s = "))))(()(";
		System.out.println(checkParen(s));
	}

	static String checkParen(String s) {

		int i = 0;
		int j = 1;

		while(j < s.length()) {
			if((s.charAt(i) == '(') && (s.charAt(j) == ')')) {
				return "YES";
			}
			i++;
			j++;
		}
		return "NO";
	}
}