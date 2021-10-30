package mixedproblem;

public class Test {

	public static void main(String[] args) {
		int x = 5;

		// System.out.println(" " + myfunction(x));
		// System.out.println("Factorial using looping mechanism : " + fact(x));
		int n = 100;
		switch(n) {
			case 1 : {
				for(int i = 0 ; i < 3; i ++) {
					System.out.println(i);
				}
				break;
			}
			default: {
				System.out.println("Always go to default");
			}
		}
	}

	static int myfunction(int x) {
		if (x == 0)
			return 1;
		return (x) * myfunction(x - 1);
	}

	public static int fact(int x) {
		int fact = 1;
		for (int i = 1; i <= x; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
