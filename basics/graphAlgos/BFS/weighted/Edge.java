

public class Edge
{
	private int endVertex;
	private int weight;

	public Edge(int inpEndVertex, int inpWeight)
	{
		endVertex = inpEndVertex;
		weight = inpWeight;
	}

	public void setEndVertex(int inpEndVertex)
	{
		endVertex = inpEndVertex;
	}

	public int getEndVertex()
	{
		return endVertex;
	}

	public void setWeight(int inpWeight)
	{
		weight = inpWeight;
	}

	public int getWeight()
	{
		return weight;
	}

}