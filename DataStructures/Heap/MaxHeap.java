import java.util.ArrayList;

public class MaxHeap
{
	private ArrayList<Double> arrayList;

	public MaxHeap(ArrayList<Double> inpArrayList)
	{
		arrayList = inpArrayList;
	}

	public void start()
	{
		int currentIndex = ( arrayList.size()-1 ) / 2;

		while( currentIndex >= 1 )
		{
			heapify(currentIndex);
			currentIndex = currentIndex - 1;
		}
	}

	private void heapify(int parentIndex)
	{
		int leftChildIndex, rightChildIndex, largestElementIndex;

		leftChildIndex = 2 * parentIndex;
		rightChildIndex = leftChildIndex + 1;

		if( leftChildIndex < arrayList.size() && arrayList.get(leftChildIndex) > arrayList.get(parentIndex) )
		{
			largestElementIndex = leftChildIndex;
		}

		else
		{
			largestElementIndex = parentIndex;
		}

		if( rightChildIndex < arrayList.size() && arrayList.get(rightChildIndex) > arrayList.get(largestElementIndex) )
		{
			largestElementIndex = rightChildIndex;
		}

		if( parentIndex != largestElementIndex )
		{
			swap(parentIndex,largestElementIndex);
			heapify(largestElementIndex);
		}
	}

	private void swap(int parentIndex, int largestElementIndex)
	{
		double temp = arrayList.get(parentIndex);
		arrayList.set( parentIndex, arrayList.get(largestElementIndex) );
		arrayList.set( largestElementIndex, temp );
	}

	public double extractMax()
	{
		double toReturn = arrayList.get(1);

		arrayList.set( 1, arrayList.get( arrayList.size()-1 ) );
		arrayList.subList( arrayList.size()-1, arrayList.size() ).clear();
		heapify(1);

		return toReturn;
	}

	public void increaseKey(int keyIndex ,double newKeyValue)
	{
		arrayList.set(keyIndex, newKeyValue);
		int currentIndex = keyIndex;

		while( currentIndex > 1 )
		{
			if( arrayList.get(currentIndex) > arrayList.get( currentIndex/2 ) )
			{
				swap(currentIndex, currentIndex/2 );
				currentIndex = currentIndex / 2;
			}

			else
			{
				return;
			}
		}
	}

	public void decreaseKey(int keyIndex, double newKeyValue)
	{
		arrayList.set( keyIndex,newKeyValue );
		heapify(keyIndex);
	}

	public void insertKey(double newKeyValue)
	{
		arrayList.add( arrayList.size(),newKeyValue-1 );
		increaseKey( arrayList.size()-1, newKeyValue );
	}

	public ArrayList<Double> getArrayList()
	{
		return arrayList;
	}
}