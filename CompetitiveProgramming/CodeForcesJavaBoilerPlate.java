import java.io.*;
import java.util.*;
 
 
public class Main{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

      // Stop writing your solution here. -------------------------------------

     int n = sc.nextInt();
     int[] arr = new int[n];

     for (int i = 0; i < arr.length; i++) {
        arr[i] = sc.nextInt();
     }

	 out.println(magicSubset(n, arr));
     out.close();
   }

   	static int magicSubset(int n, int[] arr) {

		int psum = 0;
		int nsum = 0;
		int incPsum = 0;
		int incNsum = 0;

		for(int i = 1; i < arr.length; i++) {

			if(arr[i] < 0) {
				nsum += arr[i];
			} else if(arr[i] >= 0) {
				psum += arr[i];		
			}
		}	

		incPsum = (arr[0] + psum) * -1;
		incPsum = (arr[0] + nsum) * -1;

		return maxNum(psum, nsum, incPsum, incNsum);
	}

	static int maxNum(int a, int b, int c, int d) {
		int max = a;

		if (b > max)
	    	max = b;
		if (c > max)
	    	max = c;
		if (d > max)
	    	max = d;

		return max;
	}

     

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}