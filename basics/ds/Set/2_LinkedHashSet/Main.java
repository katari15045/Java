import java.util.LinkedHashSet;
import java.util.Iterator;

public class Main{
	public static void main(String[] args){
		LinkedHashSet<Integer> l = new LinkedHashSet<>(3);
		l.add(10);
		l.add(20);
		l.add(30);
		System.out.println(l.size());

		Iterator<Integer> iter = l.iterator();
		int num = -1;
		while(iter.hasNext()){
			num = iter.next();
			System.out.print(num + ", ");
		}
		System.out.println();

		if(l.contains(20)){
			System.out.println("20 is present");
		}
		l.remove(20);
		if(l.contains(20)){
			System.out.println("20 is present");
		}
	}
}
