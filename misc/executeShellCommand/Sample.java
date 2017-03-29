import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Sample
{
	private static Scanner scanner;
	private static String command;
	private static StringBuilder output;

	public static void main(String[] args)
	{
		takeUserInput();
		executeCommand();

		System.out.println("\nResult -> \n" + output.toString() );
	}

	private static void takeUserInput()
	{
		scanner = new Scanner(System.in);

		System.out.print("Command -> ");
		command = scanner.nextLine();
	}

	private static void executeCommand()
	{
		Process process;
		BufferedReader bufferedReader = null;
		String currentLine;

		output = new StringBuilder();

		try
		{
			process = Runtime.getRuntime().exec(command);
			process.waitFor();
			bufferedReader = new BufferedReader( new InputStreamReader( process.getInputStream() ) );
			currentLine = bufferedReader.readLine();

			while( currentLine != null )
			{
				output.append(currentLine);
				output.append("\n");
				currentLine = bufferedReader.readLine();
			}

			bufferedReader.close();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}