// Tutorial -> https://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html

import java.lang.Exception;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MyAES
{
	private static String algo = "AES";
	private static int keySize = 256;
	private static SecretKey key;

	public static void start()
	{
		key = generateKey();
	}

	public static String decrypt(String cipherText)
	{
		Cipher cipher = null;
		byte[] decryptedTextBytes = null;

		try
		{
			cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decryptedTextBytes = cipher.doFinal( Base64.getDecoder().decode( cipherText.getBytes() ) );
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return new String(decryptedTextBytes);
	}

	public static String encrypt(String plainText)
	{
		Cipher cipher = null;
		byte[] cipherTextBytes = null;

		try
		{
			cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			cipherTextBytes = cipher.doFinal( plainText.getBytes() );
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return Base64.getEncoder().encodeToString(cipherTextBytes);
	}

	private static SecretKey generateKey()
	{
		KeyGenerator generator = null;
		SecretKey key = null;

		try
		{
			generator = KeyGenerator.getInstance(algo);
			generator.init(keySize);
			key = generator.generateKey();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return key;
	}
}