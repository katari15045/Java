import java.util.ArrayList;
import java.util.Iterator;


public class Kruskal
{
	private Graph graph;
	private ArrayList<Edge> sortedEdgeList;
	private Iterator iterator;

	public Kruskal(Graph inpGraph)
	{
		graph = inpGraph;
	}

	public void start()
	{
		fillSortedEdgeList();
	}

	private void fillSortedEdgeList()
	{
		int countVertices, vertices;
		Node currentNode;

		countVertices = 0;
		vertices = graph.getVertices();

		while( countVertices < vertices )
		{
			currentNode = graph.outerList.get(countVertices);
			iterator = graph.getEdgeList().iterator();

			while( iterator.hasNext() )
			{
				
			}

			countVertices = countVertices + 1;
		}
	}
}