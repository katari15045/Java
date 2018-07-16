import java.util.LinkedList;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class Main{

	private static class Node{

		int val;
		boolean processed;
		ArrayList<Edge> edges;

		public Node(int val){
			this.val = val;
			processed = false;
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
		int vertices = 7;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(10);
		graph.add(arr1);
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(1);
		arr2.add(3);
		arr2.add(20);
		graph.add(arr2);
		ArrayList<Integer> arr3 = new ArrayList<>();
		arr3.add(2);
		arr3.add(4);
		arr3.add(30);
		graph.add(arr3);
		ArrayList<Integer> arr4 = new ArrayList<>();
		arr4.add(2);
		arr4.add(5);
		arr4.add(40);
		graph.add(arr4);
		ArrayList<Integer> arr5 = new ArrayList<>();
		arr5.add(3);
		arr5.add(6);
		arr5.add(50);
		graph.add(arr5);
		ArrayList<Integer> arr6 = new ArrayList<>();
		arr6.add(3);
		arr6.add(7);
		arr6.add(60);
		graph.add(arr6);
		foo(graph, vertices, 1);
	}

	private static void foo(ArrayList<ArrayList<Integer>> graph, int vertices, int root){
		ArrayList<Node> nodes = initGraph(graph, vertices);
		fillEdges(graph, nodes);
		printGraph(nodes);
		dfs(nodes, root);
		System.out.println();
	}

	private static void dfs(ArrayList<Node> nodes, int root){
		Node curNode = null;
		Edge curEdge = null;
		int curIndex = 0;
		curNode = nodes.get(root-1);
		nodes.get(root-1).processed = true;
		System.out.print(root + ", ");
		while(curIndex < curNode.edges.size()){
			curEdge = curNode.edges.get(curIndex);
			if(!nodes.get(curEdge.endNodeVal-1).processed){
				dfs(nodes, curEdge.endNodeVal);
			}
			curIndex = curIndex+1;
		}
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

	private static ArrayList<Node> initGraph(ArrayList<ArrayList<Integer>> graph, int vertices){
		ArrayList<Node> nodes = new ArrayList<Node>();
		int curIndex = 0;
		while(curIndex < vertices){
			Node newNode = new Node(curIndex+1);
			nodes.add(newNode);
			curIndex = curIndex+1;
		}
		return nodes;
	}
}