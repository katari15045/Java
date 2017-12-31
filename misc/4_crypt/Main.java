import java.util.Base64;

import javax.crypto.SecretKey;

public class Main 
{
	private static MyRSA rsaSrc = null;
	private static MyAES aesSrc = null;
	private static MyRSA rsaDst = null;
	private static MyAES aesDst = null;
	private static MyHash hashSrc = null;
	private static MyHash hashDst = null;
	
	public static void main(String[] args)
	{
		String encrSymKeyWithPubKey = null;		
		String encrHashedSymKeyWithPrivKey = null;
		String decryptedHashedSymKey = null;
		String hashedSymKey = null;
		SecretKey decryptedSymKey = null;
		
		rsaSrc = new MyRSA();
		rsaDst = new MyRSA();
		aesSrc = new MyAES();
		aesDst = new MyAES();
		hashSrc = new MyHash();
		hashDst = new MyHash();
		
		rsaSrc.start();
		rsaDst.start();
		aesSrc.start();
		aesDst.start();
	
		// Ensures Confidentiality - with dst_pub_key	
		encrSymKeyWithPubKey = aesSrc.encryptSymKeyWithPubKey( rsaDst.getPublicKey() );
		System.out.println( "encr_sym_key : " + Base64.getDecoder().decode(encrSymKeyWithPubKey).length + " bytes");	
		
		// Ensures integrity (hash) and accountability (signing) - with src_priv_key
		hashedSymKey = hashSrc.hash( aesSrc.getSymKeyInStr() );
		encrHashedSymKeyWithPrivKey =rsaSrc.encryptWithPrivKey(hashedSymKey);

		// Transfer encrSymKeyWithPubKey and encrHashedSymKeyWithPrivKey to the destination
		
		// Confidentiality verified. Yet to verify integrity and accountability
		decryptedSymKey = rsaDst.decryptSymKeyWithPrivKey(encrSymKeyWithPubKey);

		// Verifies Accountability
		decryptedHashedSymKey = rsaDst.decryptWithPubKey(encrHashedSymKeyWithPrivKey, rsaSrc.getPublicKey());

		if( hashDst.hash(decryptedSymKey).equals(decryptedHashedSymKey) )
		{
			// Integrity verified
			System.out.println("Availablity verified too");
		}
	}
}







