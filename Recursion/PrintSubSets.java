public class PrintSubSets {
	
	public static void main(String[]args) {
		char[] inputArray = {'t','b','c','o'};
		System.out.println("Printing all subsets of: ");
		printArrayOnOneLine(inputArray);
		printSubSetsMain(inputArray);
	}

	static void printSubSetsMain(char[] inp) {
		char[] s = new char[inp.length];
		printSubSets(inp, 0, s);

	}

	static void printArrayOnOneLine(char[] arr) {
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);	
		}		
	}

	static void printSubSets(char[] a, int i, char[] s) {
		int n = a.length;
		if(i == n) {
			printArrayOnOneLine(s);
			return;
		}
		s[i] = ' ';
		printSubSets(a, i+1, s);
		s[i] = a[i];
		printSubSets(a, i+1, s);
		return;
	}

}