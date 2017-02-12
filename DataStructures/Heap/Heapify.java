import java.util.ArrayList;


public class Heapify
{
	private ArrayList<Double> arrayList;
	private int startIndex;

	public Heapify(ArrayList<Double> inpArrayList)
	{
		arrayList = inpArrayList;
	}

	public void start()
	{
		heapify(startIndex);
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

		if( rightChildIndex <= arrayList.size() && arrayList.get(rightChildIndex) > arrayList.get(largestElementIndex) )
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

	public void setStartIndex(int inpStartIndex)
	{
		startIndex = inpStartIndex;
	}

	public ArrayList<Double> getArrayList()
	{
		return arrayList;
	}
}