import java.lang.StringBuilder;
import java.util.ArrayList;

public class Main{

	private static class Node{

		int val;
		ArrayList<Edge> edges;

		public Node(int val){
			this.val = val;
			edges = new ArrayList<>();
		}

		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(val).append(" -> ");
			int curIndex = 0;
			while(curIndex < edges.size()){
				sb.append(edges.get(curIndex));
				curIndex = curIndex+1;
			}
			return sb.toString();
		}
	}

	private static class Edge{
		int weight;
		int endNodeVal;

		public Edge(int weight, int endNodeVal){
			this.weight = weight;
			this.endNodeVal = endNodeVal;
		}

		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(endNodeVal).append(" (").append(weight).append("), ");
			return sb.toString();
		}
	}

	private static int totalNodes = 4;

	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(10);
		graph.add(arr1);
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(2);
		arr2.add(3);
		arr2.add(20);
		graph.add(arr2);
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(3);
		arr3.add(4);
		arr3.add(30);
		graph.add(arr3);
		ArrayList<Integer> arr4 = new ArrayList<>();
		arr4.add(1);
		arr4.add(4);
		arr4.add(40);
		graph.add(arr4);
		foo(graph);
	}

	private static void foo(ArrayList<ArrayList<Integer>> graph){
		ArrayList<Node> nodes = initGraph(graph);
		fillEdges(graph, nodes);
		printGraph(nodes);
	}

	private static void printGraph(ArrayList<Node> nodes){
		int curIndex = 0;
		Node curNode;
		while(curIndex < nodes.size()){
			curNode = nodes.get(curIndex);
			System.out.println(curNode);
			curIndex = curIndex+1;
		}
	}

	private static void fillEdges(ArrayList<ArrayList<Integer>> graph, ArrayList<Node> nodes){
		int curIndex = 0;
		ArrayList<Integer> curArr = null;
		int startNode, endNode, weight;
		while(curIndex < graph.size()){
			curArr = graph.get(curIndex);
			startNode = curArr.get(0);
			endNode = curArr.get(1);
			weight = curArr.get(2);
			Edge newEdge = new Edge(weight, endNode);
			Edge newEdge2 = new Edge(weight, startNode);
			nodes.get(startNode-1).edges.add(newEdge);
			nodes.get(endNode-1).edges.add(newEdge2);
			curIndex = curIndex+1;
		}
	}

	private static ArrayList<Node> initGraph(ArrayList<ArrayList<Integer>> graph){
		ArrayList<Node> nodes = new ArrayList<Node>();
		int curIndex = 0;
		while(curIndex < graph.size()){
			Node newNode = new Node(curIndex+1);
			nodes.add(newNode);
			curIndex = curIndex+1;
		}
		return nodes;
	}
}