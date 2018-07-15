import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		System.out.println(arr);
		mergeSort(arr, 0, arr.size()-1);
		System.out.println(arr);
	}

	private static void mergeSort(ArrayList<Integer> arr, int startIndex, int endIndex){
		if(startIndex == endIndex){
			return;
		}
		int midIndex = (startIndex+endIndex)/2;
		mergeSort(arr, startIndex, midIndex);
		mergeSort(arr, midIndex+1, endIndex);
		merge(arr, startIndex, midIndex, endIndex);
	}

	private static void merge(ArrayList<Integer> inpArray, int startIndex, int midIndex, int endIndex){
		ArrayList<Integer> mergedArr = new ArrayList<>();
		int p1, p2, val1, val2;
		p1 = startIndex;
		p2 = midIndex+1;
		while( p1 <= midIndex && p2 <= endIndex){
			val1 = inpArray.get(p1);
			val2 = inpArray.get(p2);
			if(val1 <= val2){
				mergedArr.add(val1);
				p1 = p1+1;
			}else{
				mergedArr.add(val2);
				p2 = p2+1;
			}
		}
		while(p1 <= midIndex){
			mergedArr.add(inpArray.get(p1));
			p1 = p1+1;
		}
		while(p2 <= endIndex){
			mergedArr.add(inpArray.get(p2));
			p2 = p2+1;
		}
		p1 = startIndex;
		p2 = 0;
		while(p1 <= endIndex){
			inpArray.set(p1, mergedArr.get(p2));
			p1 = p1+1;
			p2 = p2+1;
		}
	}
}