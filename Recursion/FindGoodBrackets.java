import java.util.*;

public class FindGoodBrackets {
	
	public static void main(String[] args) {
		System.out.println("Find all well-formed brackets!!");
		printArray(find_all_well_formed_brackets(3));
	}

    static String[] find_all_well_formed_brackets(int n) {
        ArrayList<String> res = new ArrayList<String>();
        char[] currentString = new char[2*n];
        int index = 0;
        currentString[index] = '(';
        findBracketsRec(currentString, index, 2*n, res);
        String[] resArr = new String[res.size()];
		resArr = res.toArray(resArr);	
		return resArr;
    }
    
    // Recursively generate all the permutations starting w/ ( and containing 2n characters 
    static void findBracketsRec(char[] curr, int index, int limit, ArrayList<String> res) {
        
        if(index == limit-1) {
            if(isValidString(curr)) {
                String b = new String(curr);
                res.add(b);
                return;
            }
            return;
        }
        index++;
        curr[index] = ')';
        findBracketsRec(curr, index, limit, res);
        curr[index] = '(';
        findBracketsRec(curr, index, limit, res);
    }
    
    // Check if the input char[] is a valid bracket set
    static boolean isValidString(char[] arr) {
        
        Stack<Character> s = new Stack<Character>();
        
        for(int i = 0; i < arr.length; i++) {
            Character curr = arr[i];
            if(curr == '(') {
                s.push(curr);
            } else {
                if(s.isEmpty()) {
                    return false;
                } else if(s.pop() == '(') {
                    continue;
                } else {
                    return false;    
                }
                
            }
        }
        
        if(!s.isEmpty()) {
            return false;
        }
        return true;
    }

    static void printArray(String[] arr) {
    	System.out.println("");
    	for(int i = 0; i < arr.length; i++) {
    		System.out.println(arr[i]+" ");
    	}
    }
}