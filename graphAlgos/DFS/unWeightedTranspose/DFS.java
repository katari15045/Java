
import java.util.Iterator;

public class DFS
{
	private Graph myGraph;
	private int currentTime;

	public DFS(Graph inpGraph)
	{
		myGraph = inpGraph;
	}

	public void dfs()
    {
        int countOuter = 1;
        Node currentOuterVertex;

        currentTime = 0;

        while( countOuter <= myGraph.getVertices() )
        {
            currentOuterVertex = myGraph.getOuterNode(countOuter);

            if( currentOuterVertex.getColor().equals("white") )
            {
                dfsVisit(currentOuterVertex);
            }

            countOuter = countOuter + 1;
        }

    }

    public void dfsVisit(Node mainVertex)
    {
        Node currentAdjacentVertex;
        Iterator iterator = mainVertex.getEdgeList().iterator();
        Edge currentEdge;

        currentTime = currentTime + 1;
        mainVertex.setDiscoverTime(currentTime);
        mainVertex.setColor("Gray");

        while( iterator.hasNext() )
        {
            currentEdge = (Edge)iterator.next();
            currentAdjacentVertex = myGraph.getOuterNode( currentEdge.getEndVertex() );

            if( currentAdjacentVertex.getColor().equals("white") )
            {
                currentAdjacentVertex.setPredecessor(mainVertex);
                dfsVisit(currentAdjacentVertex);
            }
        }

        mainVertex.setColor("black");
        currentTime = currentTime + 1;
        mainVertex.setFinishTime(currentTime);

    }


}