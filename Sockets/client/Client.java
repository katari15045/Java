import java.util.Scanner;

public class Client
{
	private static Scanner scanner;
	private static String username;
	private static String password;

	private static String serverIPAddress;
	private static int portNumber;

	private static Thread thread;
	private static RunnableThread runnableThread;

	public static void main(String[] args)
	{
		initializeSocketDetails();
		takeUserInput();
		initializeThread();

		thread.start();
	}

	private static void initializeSocketDetails()
	{
		serverIPAddress = "localhost";
		portNumber = 6969;
	}

	private static void initializeThread()
	{
		runnableThread = new RunnableThread(serverIPAddress, portNumber, username, password);
		thread = new Thread(runnableThread);
	}

	private static void takeUserInput()
	{
		scanner = new Scanner(System.in);

		System.out.print("Username -> ");
		username = scanner.nextLine();
		System.out.print("Password -> ");
		password = scanner.nextLine();
	}
}