import java.util.ArrayList;

public class Main
{
	private static ArrayList<Integer> originalList;

	public static void main(String[] args)
	{
		ArrayList< ArrayList<Integer> > initialList = null;
		ArrayList< ArrayList<Integer> > currentList = null;
		int countSets = 0;
				
		originalList = new ArrayList<>();
		originalList.add(1);
		originalList.add(2);
		originalList.add(3);
		originalList.add(4);
		originalList.add(5);

	
		System.out.println("Subsets of " + originalList + " : \n");
		System.out.println( new ArrayList<Integer>() );
		countSets = countSets + 1;

		initialList = getInitialList(originalList);
		currentList = initialList;

		while(true)
		{
			if( currentList.isEmpty() )
			{
				break;
			}
	
			print2DList(currentList);
			countSets = countSets + currentList.size();
			currentList = getNextSizeSets(currentList, originalList);		
		}

		System.out.println("\nTotal sets : " + countSets);
	}

	private static void print2DList(ArrayList< ArrayList<Integer> > inpList)
	{
		int currentIndex = 0;

		while( currentIndex < inpList.size() )
		{
			System.out.println( inpList.get(currentIndex) );
			currentIndex = currentIndex + 1;
		}
	}

	private static ArrayList< ArrayList<Integer> > getInitialList(ArrayList<Integer> originalList)
	{
		ArrayList< ArrayList<Integer> > initialList = new ArrayList<>();
		int currentIndex = 0;
		int currentNum;
		int countSets = 0;

		while( currentIndex < originalList.size() )
		{
			currentNum = originalList.get(currentIndex);
			ArrayList<Integer> newList = new ArrayList<>();
			newList.add(currentNum);
			initialList.add(newList);
	
			currentIndex = currentIndex + 1;
		}
		
		return initialList;
	}
	
	private static ArrayList< ArrayList<Integer> > getNextSizeSets(ArrayList< ArrayList<Integer> > inpList, ArrayList<Integer> originalList)
	{
		ArrayList< ArrayList<Integer> > retList = new ArrayList<>();
		int currentIndex = 0;
		ArrayList<Integer> currentArray = null;

		while( currentIndex < inpList.size() )
		{
			currentArray = inpList.get(currentIndex);
			retList.addAll( getNextArrays(currentArray, originalList) );			

			currentIndex = currentIndex + 1;
		}

		return retList;
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











