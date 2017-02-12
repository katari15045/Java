
import java.util.ArrayList;
import java.util.Iterator;

public class Graph
{
    private ArrayList<Node> outerList;
    private int vertices;
    private int edges;

    public Graph(int inpVertices, int inpEdges)
    {
    	vertices = inpVertices;
    	edges = inpEdges;
    	initializeOuterList();
    }

    private void initializeOuterList()
    {
        outerList = new ArrayList<Node>(vertices+1);
        int count = 0;

        while( count <= vertices )
        {
            Node newNode = new Node();
            newNode.setId(count);
            outerList.add(count,newNode);

            count = count + 1;
        }
    }


    public Node getOuterNode(int index)
    {
    	return outerList.get(index);
    }

    public int getVertices()
    {
    	return vertices;
    }

    public int getEdges()
    {
    	return edges;
    }

    public void storeEdges(int startVertex, int endVertex)
    {
      outerList.get(startVertex).addInnerVertex(endVertex);      
    }

    public void printAdjacencyList()
    {
        int countOuter = 1;
        Edge currentEdge;
        Node currentNode;
        Iterator iterator;

        while( countOuter <= vertices )
        {
            System.out.print(countOuter + " : ");
            currentNode = outerList.get(countOuter);
            iterator = currentNode.getEdgeList().iterator();

            while( iterator.hasNext() )
            {
                currentEdge = (Edge)iterator.next();
                System.out.print( currentEdge.getEndVertex() + ", " );
            }

            System.out.println(" --- " + currentNode.getId() + " -> " + currentNode.getColor() + ", " + currentNode.getDiscoverTime() + ", " + currentNode.getFinishTime());

            countOuter = countOuter + 1;
        }

        System.out.println("------------------------------------");
    }

    
}