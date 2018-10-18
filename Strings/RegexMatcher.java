public class RegexMatcher {
	
	public static void main(String[] args) {

		System.out.println("Regex Matcher!!");
		// System.out.println(isMatch("abchhhhhijxyhijaahijk", "abc.*hhhij.*hijk.*"));
		System.out.println(isMatch("abbbbbbb", "ab*"));

	}

	static boolean isValidRegex(String text, String reg) {

		int i = 0; // text walker
		int j = 0; // regex walker

		while(i < text.length() && j < reg.length()) {

			System.out.println("i: "+i+" j: "+j);

			if(reg.charAt(j) == '*') {
				char prevChar = reg.charAt(j-1);
				while(i < text.length() && isValid(text.charAt(i), prevChar)) {
					i++;
				}
			}
			if(i < text.length()) {
				if(isValid(text.charAt(i), reg.charAt(j))) {
					i++;
					j++;
				} else {
					return false;
				}	
			} 			
		}
		if(i != text.length() || j != reg.length()) {
			return false;
		}
		return true;
	}

	static boolean isValid(char base, char reg) {
		if(reg == '.' && Character.isLetter(base)) {
			return true;
		} else {
			if(reg == base) {
				return true;
			}
		}
		return false;
	}



	static boolean isMatch(String s, String p) {
        int j=0;
        for(int i=0;i<p.length();i++){
            if(i!=p.length()-1 && p.charAt(i+1)=='*'){
                for(;j<s.length();j++){
                    if(p.charAt(i)!='.' && s.charAt(j)!=p.charAt(i))   break;
                    if(isMatch(s.substring(j,s.length()), p.substring(i+2,p.length())))    return true;
                }
                return isMatch(s.substring(j), p.substring(i+2));      
            }else{
                if(j>=s.length() || (p.charAt(i)!='.' && s.charAt(j)!=p.charAt(i)))   return false;
                j++;
            }
        }
        return j==s.length();
	}

}