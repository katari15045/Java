import java.util.Scanner;

public class Sample
{
	private static Scanner scanner;
	private static Graph graph;
	private static Kruskal kruskal;

	public static void main(String[] args)
	{
		takeUserInput();
		kruskal = new Kruskal(graph);
		kruskal.start();
	}

	private static void takeUserInput()
	{
		int vertices, edges, count, startVertex, endVertex, weight;
		scanner = new Scanner(System.in);

		System.out.print("Vertices : ");
		vertices = scanner.nextInt();
		System.out.print("Edges : ");
		edges = scanner.nextInt();

		graph = new Graph(vertices, edges);
		count = 0;

		while( count < edges )
		{
			System.out.print("Start Vertex : ");
			startVertex = scanner.nextInt();

			System.out.print("End Vertex : ");
			endVertex = scanner.nextInt();

			System.out.print("Weight ; ");
			weight = scanner.nextInt();

			graph.storeEdges(startVertex, endVertex, weight);

			count = count + 1;
		}
	}
}