public class JoinWordsPalindrome {

	public static void main(String[] args) {
		System.out.println("Find words in an array that make a palindrome!!");
		String[] arr = {"bat", "tab", "cat"};
		String[] res = joinWords(arr);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	static String[] joinWords(String[] words) {
		// Brute force method, go through all the words and join all the words. Test if the joined word is a palindrome
		String [] res = new String[2];
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words.length; j++) {
				if(i == j) {
					continue;
				} else {
					if(testPalindrome(words[i], words[j])) {
						System.out.println("true");
						res[0] = words[i];
						res[1] = words[j];

						return res;
					}
				}				
			}
		}
		return res;
	}

	static boolean testPalindrome(String w1, String w2) {
		String joined = w1.concat(w2);
		int ptr2 = joined.length()-1;

		for(int ptr1 = 0; ptr1 < ptr2/2; ptr1++) {
			if(!(joined.charAt(ptr1) == joined.charAt(ptr2-ptr1))) {
				return false;
			}
		}

		return true;
	}
}