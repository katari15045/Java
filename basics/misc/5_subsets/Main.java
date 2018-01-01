import java.util.ArrayList;

public class Main
{
	private static ArrayList<Integer> originalList;

	public static void main(String[] args)
	{
		ArrayList< ArrayList<Integer> > retList = null;
		ArrayList<Integer> temp = null;
		int currentIndex = 0;
		int currentNum;
		
		originalList = new ArrayList<>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(3);
		originalList.add(4);
		originalList.add(5);
	
		while( currentIndex < originalList.size() )
		{
			currentNum = originalList.get(currentIndex);
			retList = new ArrayList<>();
			temp = new ArrayList<>();
			temp.add(currentNum);
			retList.add(temp);

			while(true)			
			{
				retList = getNextArrays(retList.get(0), originalList);
				System.out.println(retList);		
				break;
			}

			currentIndex = currentIndex + 1;
			break;
		}

	}


	private static ArrayList< ArrayList<Integer> > getNextArrays(ArrayList<Integer> subArray, ArrayList<Integer> wholeList)
	{
		int subLastNum = subArray.get( subArray.size()-1 );
		int currentIndex = 0;
		ArrayList<Integer> nextList = new ArrayList<>();
		ArrayList< ArrayList<Integer> > retList = new ArrayList<>();

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
			nextList.add( wholeList.get(currentIndex) );
			currentIndex = currentIndex + 1;
		}

		currentIndex = 0;

		while( currentIndex < nextList.size() )
		{
			ArrayList<Integer> newList = new ArrayList<>( subArray );			
			newList.add( nextList.get(currentIndex) );
			retList.add(newList);

			currentIndex = currentIndex + 1;
		}

		return retList;
	}
}











