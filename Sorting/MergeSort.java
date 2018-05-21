public class MergeSort {

	public static void main(String [] args) {

		int arr[] = {4,3,7,2,5,1,6};

		System.out.println("Unsorted Array");
		printArray(arr);

		sort(arr, 0, arr.length-1);

		System.out.println("Sorted Array");
		printArray(arr);

	}

	static void printArray(int[] arr) {
		for(int j : arr) {
			System.out.print(j+" ");
		}		
	}

	static void sort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = start+(end-start)/2;
			sort(arr, start, mid)
			sort(arr, mid+1, end)
			merge(arr );	
		}		
	}

	static int[] merge(int[] arr1, int[] arr2) {
		int l1 = arr1.length;
		int l2 = arr2.length;
		int[] newArr = new int[l1+l2];

		int i = 0;
		int j = 0;
		int k = 0;

		while( i < l1 && j < l2) {
			if(arr1[i] < arr2[j]) {
				newArr[k] = arr1[i];
				k++;
				i++;
			} else {
				newArr[k] = arr2[j];
				k++;
				j++;
			}
		}

		return newArr; 
	}


}