

public class sample
{
	private static String url;
	private static String result;
	private static HttpClient httpClient;

	public static void main(String[] args) throws Exception
	{
		url = "https://www.gigablast.com/search?q=test&format=xml&userid=12345&code=demo";
		httpClient = new HttpClient(url);
		httpClient.sendGetRequest();
		result = httpClient.getResult();

		System.out.println(result);
	}
}