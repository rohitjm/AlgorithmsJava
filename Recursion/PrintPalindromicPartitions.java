import java.util.*;

public class PrintPalindromicPartitions {
	
	public static void main(String[] args) {

		System.out.println("Print all palindromic partitions of a String!");

		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> s = new ArrayList<String>();

		res = printPal(res, "abracadabra", s, 0);		

		for(int i = 0; i < res.size(); i++) {
            printArrayList(res.get(i));
        }
		// System.out.println(isPalindrome("abaf"));
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
				if(i != len-1) {
					curr.add("|");
				}
				if(i + 1 < len) {
					v = printPal(v, s, curr, i+1);
				} else {
					v.add(curr);
				}
			}

		}
		return v;
	}

	static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;

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

	static void printArrayList(ArrayList<String> arr) {
        System.out.println("");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
    }

}



/** IK Submission 

    static String[] generate_palindromic_decompositions(String s) {

		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();

		res = printPal(res, s, temp, 0);
		
		String[] resArray = new String[res.size()];
		
        StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < res.size(); i++) {
		    sb.delete(0,sb.length()-1);
            for (String str : res.get(i))
            {
                sb.append(str);
                sb.append("\t");
            }
            resArray[i] = sb.toString();
		}
		
		return resArray;
    }
    
    
    // Recursive function to generate Palindromes
    static ArrayList<ArrayList<String>> printPal(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp, int index) {

		int len = s.length();
		ArrayList<String> curr = new ArrayList<String>(temp);
		String str = "";
		int i = index;

		for(; i < len; ++i) {

			str = str+s.charAt(i);

			if(isPalindrome(str)) {
				curr.add(str);
				if(i != len-1) {
					curr.add("|");
				}
				if(i + 1 < len) {
					v = printPal(v, s, curr, i+1);
				} else {
					v.add(curr);
				}
			}

		}
		return v;
	}
	
	// function to check if given string is a Palindrome
	static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;

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

***/