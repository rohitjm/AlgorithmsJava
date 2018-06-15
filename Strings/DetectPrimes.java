public class DetectPrimes {
	public static void main(String args[]) {
		System.out.println("Detect Primes!");
		int[] nums = {3,5,7,11};
		System.out.println(detect_primes(nums));
	}

	static String detect_primes(int[] a) {
        /*
         * Write your code here.
         */
         char[] res = new char[a.length];
    
         for(int i = 0; i < a.length; i++) {
         	if(isPrime(a[i]) == true) {
         		res[i] = '1';
         	} else {
         		res[i] = '0';
         	}
         }
         String resString = new String(res);
         return resString;
    }

    static boolean isPrime(int n) {
    	if (n == 1 || n == 0) return true;
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
    	return true;
	}
}