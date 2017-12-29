
public class Main
{
	public static void main(String[] args)
	{
		String plainText = null;
		byte[] encryptedData = null;
		byte[] decryptedData = null;
		
		plainText = "All is well";
		MyRSA.start();
		encryptedData = MyRSA.encryptWithPubKey( plainText.getBytes() );
		decryptedData = MyRSA.decryptWithPrivKey(encryptedData);
		
		System.out.println( new String(decryptedData) );
	}
}