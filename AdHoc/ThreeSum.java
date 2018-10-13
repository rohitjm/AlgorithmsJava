public class ThreeSum {
	public static void main(String args[]) {
		System.out.println("3Sum!");
		//int[] input = {3,7,2,6,1,-3,4,10,22,11,3,6};
		int[] input = {1, 4, 45, 6, 10, 8};
		threeSumBF(input, 22);
	}

	static void threeSumBF(int[] arr, int target) {
		int[] res = new int[3];
		for(int i = 0; i < arr.length-2; i++) {
			for(int j = i+1; j < arr.length-1; j++) {
				for(int k = j+1; k < arr.length; k++) {
					int currSum = arr[i] + arr[j] + arr[k];
					if(currSum == target) {
						res[0] = arr[i];
						res[1] = arr[j];
						res[2] = arr[k];
						System.out.print("Triplet is " + arr[i] + 
                                     ", " + arr[j] + ", " + arr[k]);
						return;
					}
				}
			}
		}
		return;
	}

	static void printArray(int[] arr) {
		for(int i = 0; i < arr.length ;i++) {
			System.out.print(arr[i]);
		}
	} 
}