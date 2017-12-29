
public class Main
{
	public static void main(String[] args)
	{
		String plainText = null;
		String encryptedData = null;
		String decryptedData = null;
		
		plainText = "All is well";
		MyRSA.start();
		encryptedData = MyRSA.encryptWithPubKey(plainText);
		decryptedData = MyRSA.decryptWithPrivKey(encryptedData);
		
		System.out.println(decryptedData);
	}
}