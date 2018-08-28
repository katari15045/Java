import java.util.HashSet;
import java.util.Iterator;

public class Main{
	public static void main(String[] args){
		HashSet<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set.size());

		Iterator<Integer> iter = set.iterator();
		int num = -1;
		while(iter.hasNext()){
			num = iter.next();
			System.out.print(num + ", ");
		}
		System.out.println();

		if(set.contains(1)){
			System.out.println("1 is present");
		}
		set.remove(1);
		if(set.contains(1)){
			System.out.println("1 is present");
		}
	}
}
