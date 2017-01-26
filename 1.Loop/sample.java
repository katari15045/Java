

public class sample
{
	public static void main(String[] args)
	{
		recursiveFunction(5);
	}

	public static void recursiveFunction(int num)
	{
		if( num == 0 )
		{
			return;
		}

		recursiveFunction(num-1);
		System.out.println(num);
	}
}