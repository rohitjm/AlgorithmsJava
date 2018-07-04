public class HowManyBST {

	public static void main(String[] args) {

		System.out.println("How many unique BSTs can you make from n!");
		int n = 5;
		System.out.println("Can make "+countTrees(n)+" from n="+n);

	}


	static int countTrees(int n) {
		if(n == 1) {
			return 1;
		}

		int sum = 0; 
		int left = 0; 
		int right = 0; 
		int root = 0;

		for(root = 1; root < n; root++) {
			left = countTrees(root-1);
			right = countTrees(n-root);
		}
		sum+=left*right;
		return sum;
	}

}