import java.util.Iterator;
import java.util.LinkedList;

public class Main{

	private static void printLinkedList(LinkedList<Integer> linkedList){
		Iterator<Integer> iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + "|");
		}
		System.out.println();
	}

	public static void main(String[] args){
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(0);
		linkedList.add(1);
		linkedList.add(2);
		printLinkedList(linkedList);
		int polled_node = linkedList.poll();
		System.out.println("poll: " + polled_node);
		polled_node = linkedList.poll();
		System.out.println("poll: " + polled_node);
		int peeked_node = linkedList.peek();
		System.out.println("peek: " + peeked_node);
		polled_node = linkedList.poll();
		System.out.println("poll: " + polled_node);
	}
}