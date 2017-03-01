import java.util.Scanner;

public class sample
{
    private static Graph myGraph;
    private static BFS myBFS;
    private static Scanner inpScanner;

    public static void main(String[] args)
    {
        int vertices,edges,count,startVertex,endVertex,weight;
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
            System.out.print("Weight : ");
            weight = inpScanner.nextInt();
            myGraph.storeEdges(startVertex,endVertex,weight);
            //myGraph.storeEdges(endVertex,startVertex);    // For Undirected Graph

            count = count + 1;
        }

        System.out.printf("\nBefore BFS : \n\n");
        myGraph.printAdjacencyList();
        myBFS = new BFS(myGraph, myGraph.getOuterNode(1) );
        myBFS.startBFS();

        System.out.printf("\nAfter BFS : \n\n");
        myGraph.printAdjacencyList();

    }
}