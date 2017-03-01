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

	private String username;
	private String password;


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
				username = dataInputStream.readUTF();
				password = dataInputStream.readUTF();
				System.out.println( "Username -> " + username );
				System.out.println( "Password -> " + password );

				if( hashMap.containsKey(username) )
				{
					if( hashMap.get(username).equals(password) )
					{
						System.out.println("Credentials verified!");
					}

					else
					{
						System.out.println("Invalid Credentials!");
					}
				}

				else
				{
					System.out.println("No such username!");
				}

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