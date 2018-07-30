public class MagicSubset {

	public static void main(String[] args) {

		System.out.println("Competitive Programming - Magic Subset!");

		int arr[] = {-3,1,-4,1,5,-9,2,6,-5,3,5};
		int n = 11;

		System.out.println(magicSubset(n, arr));
	}

	static int magicSubset(int n, int[] arr) {

		int psum = 0;
		int nsum = 0;
		int incPsum = 0;
		int incNsum = 0;

		for(int i = 1; i < arr.length; i++) {

			if(arr[i] < 0) {
				nsum += arr[i];
			} else if(arr[i] >= 0) {
				psum += arr[i];		
			}
		}	

		incPsum = (arr[0] + psum) * -1;
		incPsum = (arr[0] + nsum) * -1;

		return maxNum(psum, nsum, incPsum, incNsum);
	}

	static int maxNum(int a, int b, int c, int d) {
		int max = a;

		if (b > max)
	    	max = b;
		if (c > max)
	    	max = c;
		if (d > max)
	    	max = d;

		return max;
	}

}
