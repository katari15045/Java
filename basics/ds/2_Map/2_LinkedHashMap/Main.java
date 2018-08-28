import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class Main{
	public static void main(String[] args){
		LinkedHashMap<Integer, Integer> h = new LinkedHashMap<>();
		h.put(10, 20);
		h.put(50, 100);
		h.put(200, 400);
		System.out.println(h.size());

		Iterator<Map.Entry<Integer, Integer>> iter = h.entrySet().iterator();
		Map.Entry entry = null;
		while(iter.hasNext()){
			entry = (Map.Entry)iter.next();
			System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") | ");
		}
		System.out.println();

		if(h.containsKey(50)){
			System.out.println("50 is present");
		}
		h.remove(50);
		if(h.containsKey(50)){
			System.out.println("50 is present");
		}
	}
}
