/* 
 *	To generate key Pair and store them :  https://www.javamex.com/tutorials/cryptography/rsa_encryption.shtml
 *  To encrypt and decrypt data : http://www.informit.com/articles/article.aspx?p=170967&seqNum=4
 *  To get public key from a file : https://stackoverflow.com/questions/18757114/java-security-rsa-public-key-private-key-code-issue
*/
import java.security.PublicKey;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import java.security.spec.RSAPrivateKeySpec;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.lang.Exception;

public class MyRSA
{
	private static KeyPair keyPair;
	
	private static String algoFull = "RSA/ECB/PKCS1PADDING";
	private static String algoHalf = "RSA";
	private static int keySize = 8192;

	public static void start()
	{
		keyPair = generateKeyPair();
		//storeKeys(keyPair);
		//getPublicKey("public.key");
	}
	
	public static String encryptWithPubKey(String plainText)
	{
		Cipher cipher = null;
		byte[] encryptedText = null;
		
		try
		{
			cipher = Cipher.getInstance(algoFull);
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
			
			encryptedText = cipher.doFinal( plainText.getBytes() );
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(encryptedText);
	}
	
	public static String decryptWithPrivKey(String encryptedData)
	{
		Cipher cipher = null;
		byte[] decryptedText = null;
		
		try
		{
			cipher = Cipher.getInstance(algoFull);
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			
			decryptedText = cipher.doFinal( Base64.getDecoder().decode( encryptedData.getBytes() ) );
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new String(decryptedText);
	}
	
	private static KeyPair generateKeyPair()
	{
		KeyPairGenerator generator = null;
		KeyPair keyPair = null;

		try
		{
			generator = KeyPairGenerator.getInstance(algoHalf);
			generator.initialize(keySize);
			keyPair = generator.genKeyPair();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return keyPair;
	}

	private static void storeKeys(KeyPair keyPair)
	{
		KeyFactory factory = null;
		RSAPublicKeySpec pubKeySpec = null;
		RSAPrivateKeySpec privKeySpec = null;

		try
		{
			factory = KeyFactory.getInstance(algoHalf);
			pubKeySpec = factory.getKeySpec( keyPair.getPublic(), RSAPublicKeySpec.class );
			privKeySpec = factory.getKeySpec( keyPair.getPrivate(), RSAPrivateKeySpec.class );

			writeKeyToFile("private.key", pubKeySpec.getModulus(), pubKeySpec.getPublicExponent());
			writeKeyToFile("public.key", privKeySpec.getModulus(), privKeySpec.getPrivateExponent());
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void writeKeyToFile(String fileName, BigInteger modulus, BigInteger exponent)
	{
		ObjectOutputStream oos = null;

		try
		{
			oos = new ObjectOutputStream (new BufferedOutputStream( new FileOutputStream(fileName) ));
			oos.writeObject(modulus);
			oos.writeObject(exponent);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				oos.close();
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public static PublicKey getPublicKey(String fileName)
	{
		InputStream inputStream = null;
		ObjectInputStream oin = null;	
		BigInteger modulus = null;
		BigInteger exponent = null;
		KeyFactory factory = null;
		PublicKey publicKey = null;	

		try
		{
			inputStream = new FileInputStream(fileName);
			oin = new ObjectInputStream( new BufferedInputStream(inputStream) );
					
			modulus = (BigInteger)oin.readObject();
			exponent = (BigInteger)oin.readObject();
			factory = KeyFactory.getInstance(algoHalf);
			publicKey = factory.generatePublic( new RSAPublicKeySpec(modulus, exponent) );
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{	
				oin.close();
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return publicKey;
	}
}
