import java.util.TreeSet;
import java.util.Iterator;

public class Main{
	public static void main(String[] args){
		TreeSet<Integer> t = new TreeSet<>();
		t.add(1);
		t.add(4);
		t.add(9);
		System.out.println(t.size());

		Iterator<Integer> iter = t.iterator();
		int num = -1;
		while(iter.hasNext()){
			num = iter.next();
			System.out.print(num + ", ");
		}
		System.out.println();

		if(t.contains(4)){
			System.out.println("4 is present");
		}
		t.remove(4);
		if(t.contains(4)){
			System.out.println("4 is present");
		}
	}
}
