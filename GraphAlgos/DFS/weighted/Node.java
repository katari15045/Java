
import java.util.LinkedList;

public class Node
{
	private int id;
	private LinkedList<Edge> edgeList;
	private int discoverTime;
	private int finishTime;
	private String color;
	private Node predecessor;

	public Node()
	{
		edgeList = new LinkedList<Edge>();
		color = new String("white");
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

	public void addInnerVertex(int inpVertex, int inpWeight)
	{
		Edge newEdge = new Edge(inpVertex,inpWeight);
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

	public void setDiscoverTime(int inpTime)
	{
		discoverTime = inpTime;
	}

	public int getDiscoverTime()
	{
		return discoverTime;
	}

	public void setFinishTime(int inpTime)
	{
		finishTime = inpTime;
	}

	public int getFinishTime()
	{
		return finishTime;
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