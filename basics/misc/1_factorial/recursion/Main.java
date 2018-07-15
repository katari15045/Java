public class Main{
	public static void main(String[] args){
		System.out.println(factorial(1));
		System.out.println(factorial(2));
		System.out.println(factorial(3));
		System.out.println(factorial(4));
		System.out.println(factorial(5));
		System.out.println(factorial(6));
		System.out.println(factorial(7));
		System.out.println(factorial(8));
	}

	private static int factorial(int n){
		if( n <= 1){
			return 1;
		}
		return n*factorial(n-1);
	}
}