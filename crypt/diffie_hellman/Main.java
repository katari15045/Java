import java.lang.Exception;
import javax.crypto.Cipher;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

public class Main
{
	private static DiffieHellmanSource dhSrc = null;
	private static DiffieHellmanDestination dhDst = null;
	private static String algo = "AES";

	public static void main(String[] args)
	{
		String srcPubKeyStr = null;
		String dstPubKeyStr = null;
		byte[] srcSecret = null;
		byte[] dstSecret = null;
		SecretKeySpec srcSecretKeySpec = null;
		SecretKeySpec dstSecretKeySpec = null;

		dhSrc = new DiffieHellmanSource();
		dhDst = new DiffieHellmanDestination();

		srcPubKeyStr = dhSrc.start();
		dstPubKeyStr = dhDst.start(srcPubKeyStr);
		srcSecret = dhSrc.end(dstPubKeyStr);
		dstSecret = dhDst.end();

		// [0, 32] means 1st 32 bytes i.e 32*8 bits = 256-bit symmetric Key
		srcSecretKeySpec = new SecretKeySpec(srcSecret, 0, 32, algo);
		dstSecretKeySpec = new SecretKeySpec(dstSecret, 0, 32, algo);

		testDH(srcSecretKeySpec, dstSecretKeySpec);
	}

	private static void testDH(SecretKeySpec srcKey, SecretKeySpec dstKey)
	{
		Cipher srcCipher = null;
		Cipher dstCipher = null;
		byte[] plainBytes = null;
		byte[] encrBytes = null;
		byte[] decrBytes = null;
	
		try
		{
			plainBytes = "All is well".getBytes();
	
			srcCipher = Cipher.getInstance(algo);		
			srcCipher.init(Cipher.ENCRYPT_MODE, srcKey);
			encrBytes = srcCipher.doFinal(plainBytes);

			dstCipher = Cipher.getInstance(algo);
			dstCipher.init(Cipher.DECRYPT_MODE, dstKey);
			decrBytes = dstCipher.doFinal( Base64.getDecoder().decode( Base64.getEncoder().encodeToString(encrBytes).getBytes() ) );
		
			System.out.println( "Decrypted text : " +  new String(decrBytes) );
		}

		catch(Exception e)
		{		
			e.printStackTrace();
		}
	}
}



















