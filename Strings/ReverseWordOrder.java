public class ReverseWordOrder {

	public static void main(String[] args) {
		System.out.println("Reverse the Ordering of Words In A String!");
		String s = "i    love you";
		System.out.println(reverseString(s));
	}

	static String reverseString(String s) {

		char[] sArr = s.toCharArray();
		int ptr1 = 0;
		int ptr2 = sArr.length - 1;

		while(ptr1 < ptr2) {
			System.out.println("ptr1: "+ptr1+" ptr2: "+ptr2);
			Character temp = sArr[ptr1];
			sArr[ptr1] = sArr[ptr2];
			sArr[ptr2] = temp;
			ptr1++;
			ptr2--;
		}

		String res = new String(sArr);
		return res;
	}

}