import java.util.Scanner;
import java.util.ArrayList;

public class sample
{
	private static Scanner scanner;
	private static ArrayList<Integer> arrayList;
	private static MergeSort mergeSort;

	public static void main(String[] args)
	{
		int length;
		scanner = new Scanner(System.in);
		

		System.out.print("Length : ");
		length = scanner.nextInt();

		initializeClassVariables(length);
		takeUserInput(length);
		mergeSort.startMergeSort();

		System.out.println( mergeSort.getSortedArray() );

	}

	private static void initializeClassVariables(int length)
	{
		arrayList = new ArrayList<Integer>(length);
		mergeSort = new MergeSort(arrayList);
	}

	private static void takeUserInput(int length)
	{
		int count = 0;
		int userNum = 0;
		System.out.print("Elements : ");

		while( count < length )
		{
			userNum = scanner.nextInt();
			arrayList.add(count,userNum);
			count = count + 1;
		}
	}
}