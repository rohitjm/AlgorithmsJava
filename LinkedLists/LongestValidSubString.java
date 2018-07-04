import java.util.*;

public class LongestValidSubString {
	
	public static void main(String[] args) {
		System.out.println("Find the Length of the longest valid substring!");
		String s = "(((()()";
		System.out.println(longestValidSubString(s));	
	}

	static int longestValidSubString(String s) {

		Stack<Integer> stk = new Stack<Integer>();
		int res = 0;

		stk.push(-1);

		for(int i = 0; i < s.length(); i++) {

			if(s.charAt(i) == '(') {
				stk.add(i);
			} else {
				stk.pop();
				if(!stk.isEmpty()) {
					int lastInd = stk.peek();
					if(res <= (i - lastInd)) {
						res = i - lastInd;
					}					
				} else {
					stk.push(i);
				}
			}
		}
		return res;
	}
}