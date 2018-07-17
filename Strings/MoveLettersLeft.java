import java.util.*;

public class MoveLettersLeft {
	

	public static void main(String[] args) {
		System.out.println("Move all the letters int the String to the left w/ the least amount of memory");
		// System.out.println(moveLeft("0a193zbr"));
		System.out.println(moveLeft("Ab8"));
	}

	static String moveLeft(String str) {

		char[] charArr = str.toCharArray();

		int ptr1 = 0; // fast pointer only stops at letters
		while(ptr1 < charArr.length && !Character.isLetter(charArr[ptr1])) {
			ptr1++;
		}
		int ptr2 = 0; // goes through every element

		while(ptr1 < charArr.length ) {
			
			if (Character.isLetter(charArr[ptr1]) && charArr[ptr1] != charArr[ptr2]) {
				charArr[ptr2] = charArr[ptr1];
			}


			ptr1++;
			while(ptr1 < charArr.length && !Character.isLetter(charArr[ptr1])) {
				ptr1++;
			}

			if(ptr1 == charArr.length) {
				break;
			}

			ptr2++;	
		}

		String res = new String(charArr);
		return res;
	}


	static void printArray(char[] arr) {
    	System.out.println("");
    	for(int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i]);
    	}
    }

}