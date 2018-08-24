public class NutsAndBolts {

	public static void main(String[] args) {

		System.out.println("Nuts And Bolts!!");

		int[] nuts = {2,3,7,9,6};
		int[] bolts = {3,9,2,6,7};

		quickSortIsh(nuts, bolts, 0, nuts.length-1);

		printArr(nuts);
		printArr(bolts);
	}

	static void quickSortIsh(int[] nuts, int[] bolts, int start, int end) {

		if(start >= end) {
			return;
		}

		int pIndex = partition(nuts, start, end, bolts[end]);
		partition(bolts, start, end, nuts[pIndex]);

		quickSortIsh(nuts, bolts, start, pIndex-1);
		quickSortIsh(nuts, bolts, pIndex+1, end);
	}

	static int partition(int[] arr, int start, int end, int pivot) {

		int pIndex = start;

		for(int i = start; i < end; i++) {
			if(arr[i] < pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			} else if(arr[i] == pivot) {
				swap(arr, i, end);
				i--; // decrement i so that we reprocess the element that was just swapped into this place.
			}
		}

		swap(arr, pIndex, end);
		return pIndex;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	static void printArr(int[] arr) {
        System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}