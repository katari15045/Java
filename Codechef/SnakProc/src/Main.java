import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main 
{
	private static int totalReports;
	private static ArrayList<String> reportArray;
	
	public static void main(String[] args) 
	{
		takeUserInput();
		Iterator<String> iterator = reportArray.iterator();
		
		while( iterator.hasNext() )
		{
			processReport( iterator.next() );
		}
	}

	private static void takeUserInput()
	{
		Scanner scanner = new Scanner(System.in);
		totalReports = scanner.nextInt();
		int count = 0;
		reportArray = new ArrayList<String>(totalReports);
		
		while( count < totalReports )
		{
			scanner.nextInt();	// length of each string
			scanner.nextLine();
			reportArray.add( scanner.nextLine() );
			count = count + 1;
		}
		
		scanner.close();
	}
	
	private static void processReport(String report)
	{
		int count = 0;
		int length = report.length();
		char currentChar;
		int statusFoundH = 1, statusFoundT = 1;
		
		while( count < length )
		{
			currentChar = report.charAt(count);
			
			if( currentChar == 'H' )
			{
				statusFoundH = statusFoundH + 1;
				statusFoundT = statusFoundT - 1;
			}
			
			else if( currentChar == 'T' )
			{
				statusFoundT = statusFoundT + 1;
				statusFoundH = statusFoundH - 1;
			}
			
			if( !( (statusFoundH == 1 && statusFoundT == 1) || (statusFoundH == 2 && statusFoundT == 0) ) )
			{
				System.out.println("Invalid");
				return;
			}
			
			count = count + 1;
		}
		
		if( statusFoundH == 1 && statusFoundT == 1 )
		{
			System.out.println("Valid");	
		}
		
		else
		{
			System.out.println("Invalid");
		}
	}
}
