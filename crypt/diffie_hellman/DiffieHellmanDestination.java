import java.lang.Exception;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.spec.DHParameterSpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;

public class DiffieHellmanDestination
{
	private String algo = "DH";
	private KeyPair keyPair = null;
	private KeyAgreement agreement = null;
	private PublicKey srcPubKey = null;

	String start(String srcPubKeyStr)
	{
		String pubKeyStr = null;
		DHParameterSpec dhSpec = null;

		srcPubKey = getPubKey(srcPubKeyStr);		
		dhSpec = ((DHPublicKey) srcPubKey).getParams();
		generateKeys(dhSpec);
		signAgreement();
		pubKeyStr = getPubStr();
		
		return pubKeyStr;
	}	

	byte[] end()
	{
		byte[] secret = null;	
				
		try
		{
			agreement.doPhase(srcPubKey, true);
			secret = agreement.generateSecret();
		}

		catch(Exception e)		
		{
			e.printStackTrace();
		}

		return secret;
	}

	private String getPubStr()
	{
		byte[] pubKeyBytes = null;

		pubKeyBytes = keyPair.getPublic().getEncoded();
		return Base64.getEncoder().encodeToString(pubKeyBytes);
	}

	private void signAgreement()
	{
		try
		{	
			agreement = KeyAgreement.getInstance(algo);
			agreement.init( keyPair.getPrivate() );
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void generateKeys(DHParameterSpec dhSpec)
	{
		KeyPairGenerator generator = null;
		
		try
		{
			generator = KeyPairGenerator.getInstance(algo);
			generator.initialize(dhSpec);
			keyPair = generator.generateKeyPair();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private PublicKey getPubKey(String pubKeyStr)
	{
		KeyFactory keyFactory = null;
		X509EncodedKeySpec x509 = null;

		try
		{
			keyFactory = KeyFactory.getInstance(algo);
			x509 = new X509EncodedKeySpec( Base64.getDecoder().decode( pubKeyStr.getBytes() ) );
	
			return keyFactory.generatePublic(x509);
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
