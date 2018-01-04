import java.nio.file.Files;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.lang.Exception;

public class Main
{
	private static File file = null;
	private static byte[] fileBytes = null;
	private static BufferedImage bufferedImage = null;

	public static void main(String[] args)
	{
		try
		{
			file = new File("pic.jpg");
			fileBytes = Files.readAllBytes( file.toPath() ); 
			bufferedImage = ImageIO.read( new ByteArrayInputStream(fileBytes) ); 
			System.out.println( bufferedImage.getWidth() + " x " + bufferedImage.getHeight() );
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
