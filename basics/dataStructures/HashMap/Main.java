import java.util.ArrayList;
import java.util.HashMap;

public class Main{

	private static HashMap<Integer, Integer> hashMap = null;
	private static ArrayList<Integer> arr = null;

	public static void main(String[] args){
		hashMap = new HashMap<>();
		arr = new ArrayList<>();
		arr.add(100);
		arr.add(200);
		arr.add(300);
		arr.add(400);
		arr.add(500);
		preProcessing();
		search();
		System.out.println("\nO(1) to search an element in a HashMap, provided pre-processing is already done\n");
	}

	private static void search(){
		int curNum = 50;
		while(curNum <= 550){
			if(hashMap.get(curNum) != null){
				System.out.println(curNum + " -> Present");
			}else{
				System.out.println(curNum + " -> Absent");
			}
			curNum = curNum + 50;
		}
	}

	private static void preProcessing() {
		int curIndex = 0, curNum;
		while(curIndex < arr.size()){
			curNum = arr.get(curIndex);
			hashMap.put(curNum, curIndex);
			curIndex = curIndex+1;
		}
	}
}