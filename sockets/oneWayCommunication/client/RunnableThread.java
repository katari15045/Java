import java.net.Socket;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;

public class RunnableThread implements Runnable
{
	private String serverIPAddress;
	private int portNumber;
	private String userName;
	private String password;

	private Socket socket;
	private DataOutputStream dataOutputStream;
	private DataInputStream dataInputStream;

	public RunnableThread(String inpIPAddress, int inpPortNumber, String inpUserName, String inpPassword)
	{
		serverIPAddress = inpIPAddress;
		portNumber = inpPortNumber;
		userName = inpUserName;
		password = inpPassword;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Connecting to server...");
			socket = new Socket(serverIPAddress, portNumber);
			System.out.println("Connected to server -> " + socket.getInetAddress() + ":" + socket.getPort() + " on port " + socket.getLocalPort() );

			dataOutputStream = new DataOutputStream( socket.getOutputStream() );
			dataOutputStream.writeUTF(userName);
			dataOutputStream.writeUTF(password);

			dataOutputStream.close();
			socket.close();
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}