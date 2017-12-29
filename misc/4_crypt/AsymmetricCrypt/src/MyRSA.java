// Tutorial -> To generate key Pair and store them :  https://www.javamex.com/tutorials/cryptography/rsa_encryption.shtml
//	    -> To get public key from a file : https://stackoverflow.com/questions/18757114/java-security-rsa-public-key-private-key-code-issue

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

import javax.crypto.Cipher;

import java.security.spec.RSAPrivateKeySpec;
import java.io.ObjectOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.lang.Exception;

public class MyRSA
{
	private static KeyPair keyPair;
	
	private static String algo = "RSA";
	private static int keySize = 8192;

	public static void start()
	{
		keyPair = generateKeyPair();
		//storeKeys(keyPair);
		//getPublicKey("public.key");
	}
	
	public static byte[] encryptWithPubKey(byte[] plainText)
	{
		Cipher cipher = null;
		byte[] encryptedText = null;
		
		try
		{
			cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
			
			encryptedText = cipher.doFinal(plainText);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return encryptedText;
	}
	
	public static byte[] decryptWithPrivKey(byte[] encryptedData)
	{
		Cipher cipher = null;
		byte[] decryptedText = null;
		
		try
		{
			cipher = Cipher.getInstance(algo);
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
			
			decryptedText = cipher.doFinal(encryptedData);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return decryptedText;
	}
	
	private static KeyPair generateKeyPair()
	{
		KeyPairGenerator generator = null;
		KeyPair keyPair = null;

		try
		{
			generator = KeyPairGenerator.getInstance(algo);
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
			factory = KeyFactory.getInstance(algo);
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
			factory = KeyFactory.getInstance(algo);
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
