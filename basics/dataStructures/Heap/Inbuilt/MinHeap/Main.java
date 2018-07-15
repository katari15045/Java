import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
	public static void main(String[] args){
		PriorityQueue<Integer> q = new PriorityQueue<>(6, new Foo());
		q.add(4);
		System.out.println(q.peek());
		q.add(2);
		System.out.println(q.peek());
		q.add(3);
		System.out.println(q.peek());
		q.add(1);
		System.out.println(q.peek());
		q.add(5);
		System.out.println(q.peek());
		q.add(9);
		System.out.println(q.peek());
		print(q);
	}

	private static class Foo implements Comparator<Integer>{
		public int compare(Integer a, Integer b){
			return a-b;
		}
	}

	private static void print(PriorityQueue<Integer> q){
		int count = 0;
		int maxCount = q.size();
		while(count != maxCount){
			System.out.print(q.poll() + ", ");
			count = count+1;
		}
		System.out.println("\n" + maxCount + " elements!");
	}
}