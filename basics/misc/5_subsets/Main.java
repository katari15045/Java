import java.util.ArrayList;

public class Main
{
	private static ArrayList<Integer> originalList;

	public static void main(String[] args)
	{
		ArrayList<Integer> retList = null;
		
		originalList = new ArrayList<>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(3);
		originalList.add(4);
		originalList.add(5);
	
		retList = new ArrayList<Integer>();
		retList.add(1);	
		retList.add(3);
	
		retList = getNextArrays(retList, originalList);
		System.out.println(retList);
	}

	private static ArrayList<Integer> getNextArrays(ArrayList<Integer> subArray, ArrayList<Integer> wholeList)
	{
		int subLastNum = subArray.get( subArray.size()-1 );
		int currentIndex = 0;
		ArrayList<Integer> listToRet = new ArrayList<>();

		while( currentIndex < wholeList.size() )		
		{
			if( wholeList.get(currentIndex) == subLastNum )			
			{
				break;
			}

			currentIndex = currentIndex + 1;
		}		

		currentIndex = currentIndex + 1;

		while( currentIndex < wholeList.size() )
		{
			listToRet.add( wholeList.get(currentIndex) );
			currentIndex = currentIndex + 1;
		}

		return listToRet;
	}
}
