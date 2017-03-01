
import java.util.LinkedList;

public class Node
{
	private int id;
	private LinkedList<Edge> edgeList;
	private int distance;
	private String color;
	private Node predecessor;

	public Node()
	{
		edgeList = new LinkedList<Edge>();
		color = new String("white");
		setDistance(-1);
	}

	public LinkedList<Edge> getEdgeList()
	{
		return edgeList;
	}

	public void setId(int inpId)
	{
		id = inpId;
	}

	public int getId()
	{
		return id;
	}

	public void addInnerVertex(int inpVertex)
	{
		Edge newEdge = new Edge(inpVertex);
		edgeList.addFirst(newEdge);
	}

	public int getListSize()
	{
		return edgeList.size();
	}

	public void setColor(String inpColor)
	{
		color = inpColor;
	}

	public String getColor()
	{
		return color;
	}

	public void setDistance(int inpDistance)
	{
		distance = inpDistance;
	}

	public int getDistance()
	{
		return distance;
	}

	public void setPredecessor(Node inpPredecessor)
	{
		predecessor = inpPredecessor;
	}

	public Node getPredecessor()
	{
		return predecessor;
	}

}