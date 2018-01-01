import java.util.Scanner;

public class sample
{
    private static Graph myGraph;
    private static DFS myDFS;
    private static Scanner inpScanner;

    public static void main(String[] args)
    {
        int vertices,edges,count,startVertex,endVertex;
        inpScanner = new Scanner(System.in);

        System.out.print("Vertices : ");
        vertices = inpScanner.nextInt();
        System.out.print("Edges : ");
        edges = inpScanner.nextInt();

        myGraph = new Graph(vertices,edges);
        count = 0;

        while(count < edges)
        {
            System.out.print("Start Vertex : ");
            startVertex = inpScanner.nextInt();
            System.out.print("End Vertex : ");
            endVertex = inpScanner.nextInt();
            myGraph.storeEdges(startVertex,endVertex);

            count = count + 1;
        }

        System.out.printf("\nBefore DFS, G : \n\n");
        myGraph.printAdjacencyList();
        System.out.printf("\nBefore DFS, G Transpose : \n\n");
        myGraph.getTransposeGraph().printAdjacencyList();
        myDFS = new DFS(myGraph);
        myDFS.dfs();

        System.out.printf("\nAfter DFS : \n\n");
        myGraph.printAdjacencyList();

    }
}