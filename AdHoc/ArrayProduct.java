public class ArrayProduct {
	
	public static void main(String[] args) {
		System.out.println("Array Product!!!");
		int[] nums = {1,2,3,4,5};
		int[] res = getProductArr(nums);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}		
	}

	static int[] getProductArr(int[] nums) {
        int[] rTot = new int[nums.length];
        int[] lTot = new int[nums.length];
        int[] res = new int[nums.length];
        int currTot = 1;
        int i = 0;

        for(; i < nums.length; i++) {
            rTot[i] = currTot;
            currTot = nums[i] * currTot;
        }
        
        currTot = 1;
        i = nums.length-1;
        
        for(; i >= 0; i--) {
            lTot[i] = currTot;
            currTot = nums[i] * currTot;
        }
        
        i = 0;
        
        for(; i < nums.length; i++) {
            res[i] = rTot[i] * lTot[i];
        }
        
        return res;
	}
}