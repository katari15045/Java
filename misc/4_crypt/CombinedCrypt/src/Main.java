import java.util.Base64;

import javax.crypto.SecretKey;

public class Main 
{
	private static MyRSA rsa = null;
	private static MyAES aes = null;
	
	public static void main(String[] args)
	{
		String encrSymKey = null;		
		String encryptedPlainText = null;
		String plainText = null;
		String decryptedText = null;
		SecretKey symKey = null;
		
		plainText = "all is well";
		rsa = new MyRSA();
		aes = new MyAES();
		
		rsa.start();
		aes.start();
		
		encrSymKey = aes.encryptSymKeyWithPubKey( rsa.getPublicKey() );
		System.out.println( "encr_sym_key : " + Base64.getDecoder().decode(encrSymKey).length + " bytes");
		
		symKey = rsa.decryptSymKeyWithPrivKey(encrSymKey);
		
		encryptedPlainText = aes.encrypt(plainText);
		decryptedText = aes.decrypt(encryptedPlainText, symKey);
		
		System.out.println("Decrypted text : " + decryptedText);
	}
}
