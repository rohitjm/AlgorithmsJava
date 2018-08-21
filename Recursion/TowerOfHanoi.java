public class TowerOfHanoi {
	
	public static void main(String[] args) {
		System.out.println("Tower Of Hanoi!!");
		printSteps(2, "A", "C", "B");
	}

	static void printSteps(int n, String from, String to, String aux) {
        if(n == 1) {
            System.out.println("Move disk from "+from+" to "+to);
            return;
        } else {
        	printSteps(n-1, from, aux, to);
        	System.out.println("Move disk from "+from+" to "+to);
        	printSteps(n-1, aux, to, from);
        }

    }
}