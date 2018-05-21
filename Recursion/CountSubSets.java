public class CountSubSets {
	
	public static void main(String [] args) {
		int[] arr = {2,3,8,6};
		System.out.println("Total # of subsets for input are: "+countSubSetsMain(arr));
	}

	static int countSubSetsMain(int[] a) {
		int[] b = new int[a.length];
		return countSubSets(a, 0, b, 0);
	}

	static int countSubSets(int[] a, int i, int[] b, int j) {
		if(i == a.length) {
			return 1;
		}
		return countSubSets(a, i+1, b, j) + countSubSets(a, i+1, b, j+1);
	}
}