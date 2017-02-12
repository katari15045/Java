import java.util.ArrayList;

public class MergeSort
{
	private ArrayList<Double>  arrayList;

	public MergeSort( ArrayList<Double> inpArrayList )
	{
		arrayList = inpArrayList;
	}

	public void startMergeSort()
	{
		mergeSort(0, arrayList.size()-1 );
	}

	private void mergeSort(int startIndex, int endIndex)
	{
		int middleIndex = 0;

		if( startIndex < endIndex )
		{
			middleIndex = (startIndex + endIndex) / 2;
			mergeSort(startIndex,middleIndex);
			mergeSort(middleIndex+1,endIndex);
			merge(startIndex,middleIndex,endIndex);
		}

	}

	private void merge(int startIndex, int middleIndex, int endIndex)
	{
		ArrayList<Double> mergedArray = new ArrayList<Double>( (endIndex-startIndex) + 1 );
		int count = 0, targetCount = 0, countTwo = 0;
		int pointerOne, pointerTwo;
		double firstElement = 0, secondElement = 0;

		pointerOne = startIndex;
		pointerTwo = middleIndex + 1;
		targetCount = (endIndex - startIndex) + 1;

		while( count < targetCount )
		{
			if( pointerOne > middleIndex || pointerTwo > endIndex )
			{
				break;
			}

			firstElement = arrayList.get(pointerOne);
			secondElement = arrayList.get(pointerTwo);

			if( firstElement <= secondElement )
			{
				mergedArray.add(count,firstElement);
				pointerOne = pointerOne + 1;
			}

			else
			{
				mergedArray.add(count,secondElement);
				pointerTwo = pointerTwo + 1;
			}

			count = count + 1;
		}

		while( pointerOne <= middleIndex )
		{
			firstElement = arrayList.get(pointerOne);
			mergedArray.add(count,firstElement);

			count = count + 1;
			pointerOne = pointerOne + 1;
		}

		while( pointerTwo <= endIndex )
		{
			secondElement = arrayList.get(pointerTwo);
			mergedArray.add(count,secondElement);

			count = count + 1;
			pointerTwo = pointerTwo + 1;
		}

		count = startIndex;
		countTwo = 0;

		while( count <= endIndex )
		{
			arrayList.set( count, mergedArray.get(countTwo) );

			countTwo = countTwo + 1;
			count = count + 1;
		}

	}

	public ArrayList<Double> getSortedArray()
	{
		return arrayList;
	}
}