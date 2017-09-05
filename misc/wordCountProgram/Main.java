import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
	private static BufferedReader bufferedReader;
	private static BufferedOutputStream bufferedOutputStream;

	public static void main(String[] args) throws IOException
	{
		bufferedReader = new BufferedReader( new FileReader("sample.txt") );
		bufferedOutputStream = new BufferedOutputStream(System.out);

		readFile();

		bufferedReader.close();
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}

	private static void readFile() throws IOException
	{
		String[] strArray;
		long wordCount = 0l;
		String line;

		while(true)
		{
			line = bufferedReader.readLine();

			if( line == null )
			{
				break;
			}

			strArray = line.split(" ");
			wordCount = wordCount + strArray.length;
		}

		bufferedOutputStream.write( ("Word count : " + String.valueOf(wordCount) + "\n").getBytes() );
	}
}