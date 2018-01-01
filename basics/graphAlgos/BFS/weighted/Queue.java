
import java.util.LinkedList;

public class Queue
{
	private LinkedList<Integer> linkedList;

	public Queue()
	{
		linkedList = new LinkedList<Integer>();
	}

	public void enqueue(int inpElement)
	{
		linkedList.addLast(inpElement);
	}

	public int dequeue()
	{
		return linkedList.poll();
	}

	public int size()
	{
		return linkedList.size();
	}

}