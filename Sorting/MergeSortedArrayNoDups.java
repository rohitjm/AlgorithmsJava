import java.util.*;

public class MergeSortedArrayNoDups {

	public static void main(String[] args) {

		System.out.println("Merge 2 sorted arrays, with no duplicates!!");

		int[] arr1 = {1,2,4,5,6};
		int[] arr2 = {3,5,6,6,6,6,6,6,6,8,9,10,11,12};

		int[] res = merge(arr1, arr2);

		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}
	}

	static int[] merge(int[] arr1, int[] arr2) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		int ptr1 = 0;
		int ptr2 = 0;
		int ind = 1;
		int valToPlace;

		while(ptr1 != arr1.length && ptr2 != arr2.length) {
			if(arr1[ptr1] <= arr2[ptr2]) {
				valToPlace = arr1[ptr1];
				ptr1++;
			} else {
				valToPlace = arr2[ptr2];
				ptr2++;
			}

			if(res.size() == 0) {
				res.add(valToPlace);
				ind++;
			} else if(res.size() >= 1 && res.get(res.size() - 1) != valToPlace) {
				res.add(valToPlace);				
				ind++;
			}
		}

		while(ptr1 != arr1.length) {
			if(res.get(res.size() - 1) != arr1[ptr1]) {
				res.add(arr1[ptr1]);	
			}				
			ptr1++;
			ind++;
		}

		while(ptr2 != arr2.length) {
			if(res.get(res.size() - 1) != arr2[ptr2]) {
				res.add(arr2[ptr2]);	
			}			
			ptr2++;
			ind++;
		}

		System.out.println("ptr1: "+ptr1+" ptr2: "+ptr2);

		// Convert ArrayList to Array
		int[] resArr = new int[res.size()];
		Iterator<Integer> itr = res.iterator();
		for(int i = 0; i < res.size(); i++) {
			resArr[i] = itr.next().intValue();
		}

		return resArr;
	}
}