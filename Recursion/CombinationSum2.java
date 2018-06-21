import java.util.*;

public class CombinationSum2 {

	public static void main(String args[]) {
		System.out.println("Combination Sum 2! - Return any combinations of the input that sum to the given target");
		int[] arr = {10,1,2,7,6};
		print(SolutionMain(arr, 8));
	}

	// my solution - basically the same as generating all the subsets - expect instead of printing the array get the sum of the array and if matches the target add it to the resultSet

    static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<Integer> combo = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<ArrayList<Integer>>();
        return combinationSum2Rec(candidates, 0, combo, 0, target, resultSet);
    }
    
    static ArrayList<ArrayList<Integer>> combinationSum2Rec(int[] arr, int s, ArrayList<Integer> combo, int j, int target , ArrayList<ArrayList<Integer>> resultSet) {
        if(s != arr.length-1) {
	        combinationSum2Rec(arr, s+1, combo, j, target, resultSet);
	        combo.add(j, arr[s]);
	        combinationSum2Rec(arr, s+1, combo, j+1, target, resultSet);        	
        } 
        int comboSum = comboSum(combo);
        if(comboSum == target) {
        	resultSet.add(combo);
        }
        return  resultSet;        	
        
    }

    // Soultion from LeetCode - brute force to some degree iterating through every element and compiling a list till it is too large

    static List<List<Integer>> SolutionMain(int[] candidates, int target) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> resultSet = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
        Solution(resultSet, temp, candidates, target, 0);
        return resultSet;
    }

    static void Solution(List<List<Integer>> result, List<Integer> temp, int[] cand, int remain, int start) {
    	printArr(temp);
    	if(remain < 0) {
    		return;
    	}
   		if( remain == 0) {
   			System.out.println("match!");
    		result.add(new ArrayList<>(temp));
    	} else {
    		//Duplicate case
    		for(int i = start; i < cand.length; i++) {
    			if(i > start && cand[i] == cand[i-1]) {
    				continue;
    			}	
    			temp.add(cand[i]);
    			Solution(result, temp, cand, remain-cand[i], i+1);
    			temp.remove(temp.size() -1);
    		}
    		
    	}

    }


    //Helper functions for printing and adding elements of an array

    static void print(List<List<Integer>> toPrint) {
    	for(int i = 0; i < toPrint.size(); i++) {
    		System.out.print("[");
    		for(int j = 0; j < toPrint.get(i).size(); j++) {
    			System.out.print(toPrint.get(i).get(j));
    		}
    		System.out.print("]");
    		System.out.println(",");
    	}
    }

    static void printArr(List<Integer> arr) {
		System.out.print("[");
		for(int j = 0; j < arr.size(); j++) {
			System.out.print(arr.get(j));
		}
		System.out.print("]");
		System.out.println("");
    }

    static int comboSum(ArrayList<Integer> combo) {
    	int result = 0;
		for(int j = 0; j < combo.size(); j++) {
			result = result+combo.get(j);
		}
		return result;
    };
        
}
