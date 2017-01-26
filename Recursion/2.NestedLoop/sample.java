

public class sample
{
	public static void main(String[] args)
	{
		recursiveFunction(3);
	}

	public static void recursiveFunction(int loopNum)
	{
		if( loopNum == 0 )
		{
			return;
		}

		recursiveFunction(loopNum-1);
		
		System.out.println("Outer Loop : " + loopNum );
		int count = 1;

		while( count <= 3 )
		{
			System.out.println("Inner Loop : " + count);
			count = count + 1;
		}
		System.out.println("----- X -----");
	}
}