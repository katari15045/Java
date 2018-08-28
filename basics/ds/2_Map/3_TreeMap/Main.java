import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

public class Main{
	public static void main(String[] args){
		TreeMap<Integer, Integer> t = new TreeMap<>();
		t.put(10, 100);
		t.put(11, 121);
		t.put(12, 144);
		System.out.println(t.size());

		Iterator<Map.Entry<Integer, Integer>> iter = t.entrySet().iterator();
		Map.Entry entry = null;
		while(iter.hasNext()){
			entry = (Map.Entry) iter.next();
			System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") | ");
		}
		System.out.println();
		
		if(t.containsKey(11)){
			System.out.println("11 is present");
		}
		t.remove(11);
		if(t.containsKey(11)){
			System.out.println("11 is Present");
		}
	}
}
