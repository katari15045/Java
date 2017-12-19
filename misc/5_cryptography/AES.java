// Tutorial -> https://www.quickprogrammingtips.com/java/how-to-encrypt-and-decrypt-data-in-java-using-aes-algorithm.html

import java.lang.Exception;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AES
{
	private static String plainText;
	private static SecretKey key;
	private static byte[] cipherText;
	private static String decryptedText;

	public static void main(String[] args)
	{
		plainText = "Saketh";
		key = generateKey();
		cipherText = encrypt(plainText.getBytes(), key);
		decryptedText = decrypt(cipherText, key);

		System.out.println("Plain Text : " + plainText);
		System.out.println("Decrypted text : " + decryptedText);
	}

	private static String decrypt(byte[] cipherText, SecretKey key)
	{
		Cipher cipher;
		byte[] decryptedTextBytes = null;

		try
		{
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			decryptedTextBytes = cipher.doFinal(cipherText);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return new String(decryptedTextBytes);
	}

	private static byte[] encrypt(byte[] plainText, SecretKey key)
	{
		Cipher cipher;
		byte[] cipherTextBytes = null;

		try
		{
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			cipherTextBytes = cipher.doFinal(plainText);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return cipherTextBytes;
	}

	private static SecretKey generateKey()
	{
		KeyGenerator generator;
		SecretKey key = null;

		try
		{
			generator = KeyGenerator.getInstance("AES");
			generator.init(256);
			key = generator.generateKey();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return key;
	}
}