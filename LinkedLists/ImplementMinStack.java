import java.util.*;

public class ImplementMinStack {

	public static void main(String[] args) {

		System.out.println("Implement a min stack!");
		// int[] ops = {10, 5, 0, -1, 0};
		// int[] res = minStack(ops);
		// printArr(res);

		MinStack myMinStack = new MinStack();
		myMinStack.push(5);
		myMinStack.push(10);
		myMinStack.push(2);
		myMinStack.push(15);
		myMinStack.pop();
		myMinStack.pop();
		System.out.println(myMinStack.getMin());
	}

	static void printArr(int[] arr) {
        System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}

class MinStack {

		// Initialize 2 stacks - 1 for the values and 1 to maintain the running min
		Deque<Integer> vals = new ArrayDeque<Integer>();
	    Deque<Integer> min = new ArrayDeque<Integer>();

		MinStack() {
			 vals = new ArrayDeque<Integer>();
			 min = new ArrayDeque<Integer>();
			 System.out.println("Initialized min stack");
		}

		public void push(int val) {
			if(min.peek() == null || val <= min.peek()) {
				min.push(val);
			}
			vals.push(val);
		}

		public int pop() {
			Integer curr = vals.pop();
			if(curr != null && curr == min.peek()) {
				min.pop();
			}
			return curr;
		}

		public int getMin() {
			return min.peek();
		}

}