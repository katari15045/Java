import java.util.ArrayList;

public class Main
{
	private static int[] array = {2, 3, 4, 5};

	public static void main(String[] args)
	{
		ArrayList<Integer> retList = null;
		int[] temp = {2};
		
		retList = getNextArrays(temp, array);
		System.out.println(retList);
	}

	private static ArrayList<Integer> getNextArrays(int[] subArray, int[] wholeArray)
	{
		int subLastNum = subArray[ subArray.length-1 ];
		int currentIndex = 0;
		ArrayList<Integer> listToRet = new ArrayList<>();

		while( currentIndex < wholeArray.length )		
		{
			if( wholeArray[currentIndex] == subLastNum )			
			{
				break;
			}

			currentIndex = currentIndex + 1;
		}		

		currentIndex = currentIndex + 1;

		while( currentIndex < wholeArray.length )
		{
			listToRet.add( wholeArray[currentIndex] );
			currentIndex = currentIndex + 1;
		}

		return listToRet;
	}
}
