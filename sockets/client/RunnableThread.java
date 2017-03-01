import java.net.Socket;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class RunnableThread implements Runnable
{
	private String serverIPAddress;
	private int serverPort;
	private String userName;
	private String password;

	private Socket socket;
	private DataOutputStream dataOutputStream;
	private DataInputStream dataInputStream;

	public RunnableThread(String inpIPAddress, int inpPortNumber, String inpUserName, String inpPassword)
	{
		serverIPAddress = inpIPAddress;
		serverPort = inpPortNumber;
		userName = inpUserName;
		password = inpPassword;
	}

	@Override
	public void run()
	{
		try
		{
			connectToServer();
			sendDataToServer();
			receiveDataFromServer();
			closeConnection();
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private void connectToServer() throws IOException
	{
		System.out.println("Connecting to server...");
		socket = new Socket(serverIPAddress, serverPort);
		System.out.println("Connected to server -> " + socket.getInetAddress() + ":" + socket.getPort() +  " on port " + socket.getLocalPort() );
	}

	private void sendDataToServer() throws IOException
	{
		dataOutputStream = new DataOutputStream( socket.getOutputStream() );
		dataOutputStream.writeUTF(userName);
		dataOutputStream.writeUTF(password);
	}

	private void receiveDataFromServer() throws IOException
	{
		String input;

		dataInputStream = new DataInputStream( socket.getInputStream() );
		input = dataInputStream.readUTF();
		System.out.println(input);
	}

	private void closeConnection() throws IOException
	{
		dataOutputStream.close();
		socket.close();
	}
}