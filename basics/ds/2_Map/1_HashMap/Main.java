import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main{
	public static void main(String[] args){
		HashMap<Integer, Integer> h = new HashMap<>();
		h.put(5, 25);
		h.put(6, 36);
		h.put(7, 49);
		System.out.println(h.size());

		Iterator<Map.Entry<Integer, Integer>> iter = h.entrySet().iterator();
		Map.Entry entry = null;
		while(iter.hasNext()){
			entry = (Map.Entry)iter.next();
			System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ")" + " | ");
		}
		System.out.println();

		if(h.containsKey(6)){
			System.out.println("6 is present");
		}
		h.remove(6);
		if(h.containsKey(6)){
			System.out.println("6 is present");
		}
	}
}
