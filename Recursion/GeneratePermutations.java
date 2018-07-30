public class GeneratePermutations {

	public static void main(String[] args) {

		System.out.println("Generate all Permutations of a String!");
		String s = "test";
		permute(s, 0, s.length()-1);

	}

	static void permute(String s, int l, int r) {
		if(l == r) {
			System.out.println(s);
		} else {

			for(int i = l; i <= r; i++) {
				s = swap(s,i,l);
				permute(s, l+1, r);
				s = swap(s,i,l);
			}
		}
	}

	static String swap(String s, int i, int j) {
		char[] arr = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		String res = new String(arr);
		return res;
	}

}