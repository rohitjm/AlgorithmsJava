import java.util.*;

public class ReverseWordOrder {

	public static void main(String[] args) {
		System.out.println("Reverse the Ordering of Words In A String!");
		String s = "Where there is a will, there is a way.";
		//String b = "What a beauty.";
		System.out.println(reverseString(s));
		// System.out.println(reverseWords(s));		
	}

	static String reverseString(String s) {

		char[] sArr = s.toCharArray();
		int ptr1 = 0;
		int ptr2 = sArr.length - 1;

		reverseUtil(ptr1, ptr2, sArr);

		ptr1 = 0;
		ptr2 = 0;

		// walk through sArr reversing the words as we go
		while(sArr[ptr1] == ' ' && sArr[ptr2] == ' ' ) {
			ptr1++;
			ptr2++;
			if(ptr1 == sArr.length-1 || ptr2 == sArr.length-1) {
				break;
			}		
		}
		
		System.out.println("sArr: "+sArr.length);

		while(ptr1 < sArr.length-1) {

			while(sArr[ptr1+1] != ' ') {
				ptr1++;
				if(ptr1 == sArr.length-1) {
					break;
				}
			}

			System.out.println("start ptr1: "+ptr1+" ptr2: "+ ptr2);
			printArray(sArr);
			if(ptr1 == ptr2) {
				ptr1++;
			} else {
				reverseUtil(ptr2, ptr1, sArr);	
			}
			

			printArray(sArr);

			// checking the pervious or next element to find the start/end indecies for a word is always going to cause problems
			if(ptr1 != 0) {
				while(!( sArr[ptr1-1] == ' ' && sArr[ptr1] != ' ') && ptr1 < sArr.length-1) {
					ptr1++;
				// System.out.println("ptr1: "+ptr1+" ptr2: "+ ptr2);
				}
			} else {
				ptr1++;
			}

			ptr2 = ptr1;
			System.out.println("end ptr1: "+ptr1+" ptr2: "+ ptr2);
		}


		String res = new String(sArr);
		return res;
	}

	static void reverseUtil(int ptr1, int ptr2, char[] sArr) {
		while(ptr1 < ptr2) {
			// System.out.println("ptr1: "+ptr1+" ptr2: "+ptr2);
			Character temp = sArr[ptr1];
			sArr[ptr1] = sArr[ptr2];
			sArr[ptr2] = temp;
			ptr1++;
			ptr2--;
		}
	}

	static void printArray(char[] arr) {
    	System.out.println("");
    	for(int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i]);
    	}
    	System.out.println("");
    }

}