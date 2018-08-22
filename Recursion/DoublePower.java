public class DoublePower {

	public static void main(String[] args) {
		System.out.println("Double Power!!");
		System.out.println(pow(.00001,2147483647));
	}

	static double pow(double base, int exp) {
		System.out.println(base+" "+exp);
		if(exp == 0) {
			return 1;
		} else if(exp > 0) {
			return base * pow(base, exp-1);	
		} 
		return 1/base * pow(base, exp+1);		
	}
}