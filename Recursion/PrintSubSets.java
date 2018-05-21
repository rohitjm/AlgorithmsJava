public class PrintSubSets {
	
	public static void main(String[]args) {
		char[] inputArray = {'t','b','c','o'};
		System.out.println("Printing all subsets of: ");
		printArrayOnOneLine(inputArray, 0);
		printSubSetsMain(inputArray);
	}

	static void printSubSetsMain(char[] inp) {
		char[] s = new char[inp.length];
		printSubSets(inp, 0, s, 0);

	}

	static void printArrayOnOneLine(char[] arr, int x) {
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);	
		}		
	}

	static void printSubSets(char[] a, int i, char[] s, int j) {
		int n = a.length;
		if(i == n) {
			printArrayOnOneLine(s, j);
			return;
		}
		printSubSets(a, i+1, s, j);
		s[j] = a[i];
		printSubSets(a, i+1, s, j+1);
		return;
	}

}