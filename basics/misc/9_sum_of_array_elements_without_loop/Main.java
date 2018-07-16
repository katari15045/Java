import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		System.out.println(sum(arr, 0));
	}

	private static int sum(ArrayList<Integer> arr, int ind){
		if(ind == (arr.size()-1)){
			return arr.get(ind);
		}
		return arr.get(ind) + sum(arr, ind+1);
	}
}