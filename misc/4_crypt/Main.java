import java.util.Base64;

import javax.crypto.SecretKey;

public class Main 
{
	private static MyRSA rsa = null;
	private static MyAES aes = null;
	private static MyHash hash = null;
	
	public static void main(String[] args)
	{
		String encrSymKeyWithPubKey = null;		
		String encrHashedSymKeyWithPrivKey = null;
		String decryptedHashedSymKey = null;
		String hashedSymKey = null;
		SecretKey decryptedSymKey = null;
		
		rsa = new MyRSA();
		aes = new MyAES();
		hash = new MyHash();
		
		rsa.start();
		aes.start();
	
		// Ensures Confidentiality - with dst_pub_key	
		encrSymKeyWithPubKey = aes.encryptSymKeyWithPubKey( rsa.getPublicKey() );
		System.out.println( "encr_sym_key : " + Base64.getDecoder().decode(encrSymKeyWithPubKey).length + " bytes");	
		
		// Ensures integrity (hash) and accountability (signing) - with src_priv_key
		hashedSymKey = hash.hash( aes.getSymKeyInStr() );
		encrHashedSymKeyWithPrivKey =rsa.encryptWithPrivKey(hashedSymKey);

		// Transfer encrSymKeyWithPubKey and encrHashedSymKeyWithPrivKey to the destination
		
		// Confidentiality verified. Yet to verify integrity and accountability
		decryptedSymKey = rsa.decryptSymKeyWithPrivKey(encrSymKeyWithPubKey);

		// Verifies Accountability
		decryptedHashedSymKey = rsa.decryptWithPubKey(encrHashedSymKeyWithPrivKey);

		if( hash.hash(decryptedSymKey).equals(decryptedHashedSymKey) )
		{
			// Integrity verified
			System.out.println("Availablity verified too");
		}
	}
}







