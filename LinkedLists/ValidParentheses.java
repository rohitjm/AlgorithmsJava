import java.util.*;

class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("Check if () String is valid!");
        String s = "[()]";
        System.out.println(isValid(s));
    }

    static boolean isValid(String s) {
        
        Stack<Character> stk = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                Character popped = stk.pop();
                if(s.charAt(i) == ']' && popped == '[') {
                     continue;   
                } else if(s.charAt(i) == ')' && popped == '(') {
                    continue;   
                } else if(s.charAt(i) == '}' && popped == '{') {
                    continue;   
                } else {
                    return false;
                } 
            }          
        }
        if(!stk.isEmpty()) {
            return false;
        }
        return true;
    }
}