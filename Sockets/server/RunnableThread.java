import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.HashMap;
import java.io.DataInputStream;
import java.io.DataOutputStream;


public class RunnableThread implements Runnable
{
	private ServerSocket serverSocket;
	private Socket socket;
	private int portNumber;

	private HashMap<String, String> hashMap;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;


	public RunnableThread(HashMap<String,String> inpHashMap, int inpPortNumber)
	{
		hashMap = inpHashMap;
		portNumber = inpPortNumber;
	}

	@Override
	public void run()
	{
		
		while(true)
		{
			try
			{
				serverSocket = new ServerSocket(portNumber);
				System.out.println("Waiting for client");
				socket = serverSocket.accept();
				System.out.println("Client Connected");
				dataInputStream = new DataInputStream( socket.getInputStream() );
				System.out.println( "Username -> " + dataInputStream.readUTF() );
				System.out.println( "Password -> " + dataInputStream.readUTF() );
				dataInputStream.close();
				socket.close();
				serverSocket.close();
			}

			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}