
public class Main
{
	public static void main(String[] args)
	{
		String plainText = null;
		String encryptedData = null;
		String decryptedData = null;
		
		plainText = "All is well";
		MyRSA.start();
		encryptedData = MyRSA.encryptWithPrivKey(plainText);
		decryptedData = MyRSA.decryptWithPubKey(encryptedData);
		
		System.out.println("Decrypted data -> " + decryptedData);
	}
}