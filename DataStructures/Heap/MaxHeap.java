import java.util.ArrayList;

public class MaxHeap
{
	private ArrayList<Double> arrayList;
	private Heapify heapify;

	public MaxHeap(ArrayList<Double> inpArrayList)
	{
		arrayList = inpArrayList;
		heapify = new Heapify(arrayList);
	}

	public void start()
	{
		int currentIndex = ( arrayList.size()-1 ) / 2;

		while( currentIndex >= 1 )
		{
			heapify.setStartIndex(currentIndex);
			heapify.start();
			currentIndex = currentIndex - 1;
		}
	}

	public ArrayList<Double> getArrayList()
	{
		return arrayList;
	}
}