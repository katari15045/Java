public class Main{
	public static void main(String[] args){
		System.out.println(factorial(110));
	}

	private static long factorial(int n){
		int multiplier = n;
		long res = 1;
		while(multiplier >= 1){
			res = res*multiplier;
			multiplier = multiplier-1;
		}
		return res;
	}
}