public class SegregateOddsEvens {

	public static void main(String[] args) {
		System.out.println("Segregate Odds and Evens!");
		int[] arr = {3,5,6,2,9,8};
		printArray(segreate(arr));
	}

	static int[] segreate(int[] arr) {
		int i = 0;
		int j = arr.length-1;
		while(i < j) {
			while(arr[i] % 2 == 0 && i < j) {
				i++;
			}
			while(arr[j] % 2 != 0 && i < j) {
				j--;
			}
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return arr;
	}

	static void printArray(int[] arr) {
        System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}