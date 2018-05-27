public class PrintExpressions {
	
	public static void main(String args[]) {
		System.out.println("Printing valid expressions");
		expPrintMain("222", 24);
		return; 
	}

	static void expPrintMain(String s, long target) {
		// convert the String into a char array, inserting an empty space in between each character, can this be initialized better?
		char[] arr = new char[s.length()*2-1];
		char[] charArray = {' ','*','+'};

		int i = 0;
		int j = 0;

		//Build char arry with spaces
		while(i < s.length()) {
			if(j%2 == 0) {
				arr[j] = s.charAt(i);
				i++;
			} else {
				arr[j] = ' ';
			}
			j++;
		}
		System.out.println("Arr length: "+arr.length);
		System.out.println("Arr: ");
		printArray(arr);
		expPrint(arr, 0, target);
		return;
	}

	static void expPrint(char[] arr, int i, long target) {
		// base case for when the expression is complete
		System.out.println("i: "+i);	
		if(i > arr.length -1) {
			i = 0;	
			printArray(arr);
			return;
		} else {
			if(arr[i] == ' ') {
				arr[i] = '+';
				expPrint(arr, ++i, target);
				arr[i] = '*';
				expPrint(arr, ++i, target);
				arr[i] = ' ';
				expPrint(arr, ++i, target);
			} else {
				expPrint(arr, ++i, target);
			}	
		}
	}

	// static void evaluateExp(char[] arr) {
	// 	// for(int i = 0; i < arr.length; i++) {
	// 	// 	if()
	// 	// }
	// 	System.out.println("");
	// 	for(i = ; i < s.length; i+=2) {
	// 		// arr[j] = s.charAt(i);
	// 		System.print(s[i]);
	// 	}
	// }

	static void printArray(char[] arr) {
		System.out.println("");
		for(int x = 0; x < arr.length; x++) {
			System.out.print(arr[x]);
		}
	}
}