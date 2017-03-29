import java.io.*;
import java.net.*;

public class HttpClient
{
	private URL url;
	private String urlString;
	private HttpURLConnection connection;
	private BufferedReader br;
	private String line;
	private StringBuilder result;

	public HttpClient(String inpURL)
	{
		urlString = inpURL;
	}

	public void sendGetRequest() 
	{
		try
		{
			initializeObjects();
			makeConnection();
			readResponse();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void initializeObjects() throws MalformedURLException
	{
		result = new StringBuilder();
		url = new URL(urlString);
	}

	private void makeConnection() throws IOException, ProtocolException
	{
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
	}

	private void readResponse() throws IOException
	{
		br = new BufferedReader( new InputStreamReader( connection.getInputStream() ) );
		line = br.readLine();

		while( line != null )
		{
			result.append(line);
			line = br.readLine();
		}
	}

	public String getResult()
	{
		return result.toString();
	}
}