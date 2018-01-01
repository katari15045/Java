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
		int countSets = 0;
		
		originalList = new ArrayList<>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(3);
	
		System.out.println("Subsets of " + originalList + " : \n");
		System.out.println( new ArrayList() );
		countSets = countSets + 1;

		while( currentIndex < originalList.size() )
		{
			currentNum = originalList.get(currentIndex);
			retList = new ArrayList<>();
			temp = new ArrayList<>();
			temp.add(currentNum);
			retList.add(temp);

			while(true)			
			{
				if( retList.isEmpty() )
				{
					break;
				}
		
				ArrayList<Integer> tempTwo = retList.remove(0);
				System.out.println(tempTwo);
				countSets = countSets + 1;
				retList.addAll( getNextArrays(tempTwo, originalList) );
			}

			currentIndex = currentIndex + 1;
		}
		
		System.out.println("\nTotal sets : " + countSets);
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











