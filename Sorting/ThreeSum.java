import java.util.*;

public class ThreeSum {

	public static void main(String[] args) {
		System.out.println("Find triplets that sum to 0!!");
		int[] arr = {10, 3, -4, 1, -6, 9};
		int sum = 0;
		printArrayList(threeSum(arr, sum));
	}

	static ArrayList<String> threeSum(int[] arr, int target) {
		//First sort the given input array
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length-1;
		ArrayList<String> results = new ArrayList<String>();
		
		for(int i = 1; i < arr.length-2; i++) {
			int currTotal = arr[left] + arr[i] + arr[right];
			if(currTotal == target) {
				results.add(String.valueOf(arr[left])+" "+String.valueOf(arr[i])+" "+String.valueOf(arr[right]));
			} else if(currTotal < target) {
				left++;
			} else if(currTotal > target) {
				right--;
			}
		}
		return results;
	}

	static void printArrayList(ArrayList<String> arr) {
        System.out.println("");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i)+" ");
        }
    }


}