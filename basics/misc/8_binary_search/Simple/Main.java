import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Main{

	private static class Foo{
		int index;
		int val;

		Foo(int index, int val){
			this.index = index;
			this.val = val;
		}

		public String toString(){
			return String.valueOf(val);
		}
	}

	public static void main(String[] args){
		ArrayList<Foo> arr = new ArrayList<>();
		arr.add(new Foo(0, 100));
		arr.add(new Foo(1, 90));
		arr.add(new Foo(2, 80));
		arr.add(new Foo(3, 70));
		arr.add(new Foo(4, 60));
		System.out.println(arr);
		Collections.sort(arr, new Comparator<Foo>(){
			public int compare(Foo a, Foo b){
				return a.val-b.val;
			}
		});
		System.out.println(arr);
		System.out.println(binSearch(arr, 0, arr.size()-1, 995));
	}

	private static int binSearch(ArrayList<Foo> arr, int startIndex, int endIndex, int tarVal){
		if(startIndex == endIndex){
			if(arr.get(startIndex).val == tarVal){
				return startIndex;
			}
			return -1;
		}
		int midIndex = (startIndex+endIndex)/2;
		int midNum = arr.get(midIndex).val;
		if(midNum == tarVal){
			return midIndex;
		}
		if(tarVal < midNum){
			if(startIndex == midIndex){
				return -1;
			}
			return binSearch(arr, startIndex, midIndex-1, tarVal);
		}
		if(midIndex == endIndex){
			return -1;
		}
		return binSearch(arr, midIndex+1, endIndex, tarVal);
	}
}