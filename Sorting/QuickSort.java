public class QuickSort {

	public static void main(String [] args) {

		System.out.println("QuickSort implementation in Java");

		// int arr[] = {200,10,33,20,98,30,71,40,55,80,90,91};
		int arr[] = {4,3,7,2,5,1,6};

		System.out.println("Unsorted Array");
		printArray(arr);
		
		sort(arr, 0, arr.length-1);
		System.out.println("");
		System.out.println("Sorted Array");
		printArray(arr);
	}

	static void printArray(int[] arr) {
		for(int j : arr) {
			System.out.print(j+" ");
		}		
	}

	static int partitionLoMutos(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i= start-1;
		for(int j = start; j < end-1; j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp2 = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp2;

		return i+1;
	}

	static int partitionBruteForce(int[] arr, int start, int end) {
		int pivot = end;
		int[] arr2 = new int[arr.length];
		int lessCount = 0;
		System.out.println("start: "+start+" end: "+end);
		for(int i : arr) {
			if(i < arr[pivot]) {
				lessCount++;
			}
		}
		arr2[lessCount] = arr[pivot];
		int lessIndex = 0;
		int greatIndex = lessCount+1;
		for(int i : arr) {
			if(i > arr[pivot]) {
				arr2[lessIndex] = i;
				lessIndex++;
			} else if(i > arr[pivot]) {
				arr2[greatIndex] = i;
				greatIndex++;
			}
		}
		return lessCount;
	}

	static void sort(int[] arr, int start, int end) {
		if(start == end+1) {
			return;
		}
		int p = partitionLoMutos(arr, start, end);
		// int p = partitionBruteForce(arr, start, end);
		System.out.println("pivot: "+p);
		sort(arr, start, p-1);
		sort(arr, p+1, end);
	}


}