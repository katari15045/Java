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

		heapify = new Heapify(arrayList);
		heapify.start();
	}

	private static void takeUserInput()
	{
		arrayList = new ArrayList<Double>(length);
		int count = 0;
		double inpDouble;
		System.out.print("Elements : ");

		while( count < length )
		{
			inpDouble = scanner.nextDouble();
			arrayList.add(count,inpDouble);

			count = count + 1;
		}

	}
}