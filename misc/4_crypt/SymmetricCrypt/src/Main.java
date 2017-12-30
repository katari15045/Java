
public class Main 
{
	private static String plainText = null;
	private static String encryptedText = null;
	private static String decryptedText = null;
	
	public static void main(String[] args)
	{
		plainText = "Saketh";
		MyAES.start();
		encryptedText = MyAES.encrypt(plainText);
		decryptedText = MyAES.decrypt(encryptedText);

		System.out.println("Decrypted text : " + decryptedText);
	}
}
