import java.util.*;

public class RunLengthEncoding {
	
	public static void main(String[] args) {
		System.out.println("Run Length Encoding!!");
		String s = "BAAAB";
		String t = "AAAAA";
		String res = encodeString(s);
		System.out.println(res);
		String newRes = decodeString(res);
		System.out.println(newRes);
	}

	static String encodeString(String s) {

		StringBuffer res = new StringBuffer();
		int fast = 0;
		int encoder = 1;
		int eCount = 0;

		if(s.charAt(fast) == s.charAt(encoder)) {
			eCount++;
		}

		for(; fast < s.length(); fast++) {

			while(encoder < s.length() && s.charAt(encoder) == s.charAt(fast)) {
				encoder++;
				eCount++;
			}

			if(eCount > 1) {
				res.append(eCount);	
			}
			res.append(s.charAt(fast));

			fast = encoder-1;
			eCount = 0;			
		}

		return res.toString();
	}

	static String decodeString(String s) {
		StringBuffer res = new StringBuffer();

		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				for(int j = 0; j < Character.getNumericValue(s.charAt(i))-1; j++) {
					res.append(s.charAt(i+1));
				}
			} else {
				res.append(s.charAt(i));				
			}			
		}

		return res.toString();
	}


}