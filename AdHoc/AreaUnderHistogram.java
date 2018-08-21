import java.util.*;

public class AreaUnderHistogram {

	public static void main(String[] args) {
		System.out.println("Area Under Histrogram!!!");
		int[] histo = {6, 2, 5, 4, 5, 1, 6 };
		System.out.println(findArea(histo));
	}

	static int findArea(int[] arr) {

		// use a stack to add the units of the histogram in order and process them one by one
		Deque<Integer> s = new ArrayDeque<Integer>();
		int maxArea = 0;
		int i = 0;

		while(i < arr.length) {
			if(s.isEmpty() || arr[i] >= arr[s.peek()]) {
				s.push(i);
				i++;
			} else {
				int curr = s.pop();
				int currA = arr[curr] * (s.isEmpty() ? i : i - s.peek() - 1);
				if(currA > maxArea) {
					maxArea = currA;
				}
			}
		}

		while(s.isEmpty() == false) {
			int curr = s.pop();
			int currA = arr[curr] * (s.isEmpty() ? i : i - s.peek() - 1);
			if(currA > maxArea) {
				maxArea = currA;
			}
		}

		return maxArea;
	}
}