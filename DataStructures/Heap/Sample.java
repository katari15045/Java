import java.util.Scanner;
import java.util.ArrayList;

public class Sample
{
	private static Scanner scanner;
	private static ArrayList<Double> arrayList;
	private static int length;

	private static MaxHeap maxHeap;

	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		System.out.print("Length : ");
		length = scanner.nextInt();

		takeUserInput();

		maxHeap = new MaxHeap(arrayList);
		maxHeap.start();
		System.out.println( "After Max-Heap : " + maxHeap.getArrayList() );
		maxHeap.insertKey(7.0);
		System.out.println("After insertKey : " + maxHeap.getArrayList() );
	}

	private static void takeUserInput()
	{
		arrayList = new ArrayList<Double>(length+1);
		int count = 1;
		double inpDouble;
		System.out.print("Elements : ");
		arrayList.add(0,0.0);

		while( count <= length )
		{
			inpDouble = scanner.nextDouble();
			arrayList.add(count,inpDouble);

			count = count + 1;
		}

	}
}