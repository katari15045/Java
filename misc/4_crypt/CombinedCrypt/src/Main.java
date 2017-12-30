import javax.crypto.SecretKey;

public class Main 
{
	private static MyRSA rsa = null;
	private static MyAES aes = null;
	
	private static String encryptedSymKey = null;
	private static String encryptedPlainText = null;
	
	public static void main(String[] args)
	{
		String plainText = null;
		String decryptedText = null;
		SecretKey symKey = null;
		
		plainText = "all is well";
		rsa = new MyRSA();
		aes = new MyAES();
		
		rsa.start();
		aes.start();
		
		encryptedSymKey = aes.encryptSymKeyWithPubKey( rsa.getPublicKey() );
		symKey = rsa.decryptSymKeyWithPrivKey(encryptedSymKey);
		
		encryptedPlainText = aes.encrypt(plainText);
		decryptedText = aes.decrypt(encryptedPlainText, symKey);
		
		System.out.println("Decrypted text : " + decryptedText);
	}
}
