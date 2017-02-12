
import java.util.Iterator;

public class BFS
{
	private Graph myGraph;
	private Queue myQueue;
	private Node startNode;

	public BFS(Graph inpGraph, Node inpNode)
	{
		myGraph = inpGraph;
		myQueue = new Queue();
		startNode = inpNode;
	}

	public void startBFS()
	{
		Iterator iterator;
		Edge currentEdge;
		Node mainNode;
		Node adjacentNode;

		startNode.setColor("gray");
		startNode.setDistance(0);
		myQueue.enqueue( startNode.getId() );

		while( myQueue.size() != 0 )
		{
			mainNode = myGraph.getOuterNode( myQueue.dequeue() );
			iterator = mainNode.getEdgeList().iterator();

			while( iterator.hasNext() )
			{
				currentEdge = (Edge)iterator.next();
				adjacentNode = myGraph.getOuterNode( currentEdge.getEndVertex() );

				if( adjacentNode.getColor().equals("white") )
				{
					adjacentNode.setColor("gray");
					adjacentNode.setDistance( mainNode.getDistance() + 1 );
					adjacentNode.setPredecessor(mainNode);
					myQueue.enqueue( adjacentNode.getId() );
				}
			}

			mainNode.setColor("black");

		}
	}

}