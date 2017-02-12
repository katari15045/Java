import java.util.Scanner;
import java.util.ArrayList;

public class Sample
{
	private static Scanner scanner;
	private static ArrayList<Double> arrayList;
	private static int length;

	private static Heapify heapify;

	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);
		System.out.print("Length : ");
		length = scanner.nextInt();

		takeUserInput();
		System.out.println("Before Heapify : " + arrayList);

		heapify = new Heapify(arrayList,2);
		heapify.start();
		System.out.println( "After Heapify : " + heapify.getArrayList() );
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