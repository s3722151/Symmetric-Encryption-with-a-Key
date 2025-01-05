import java.util.Scanner;  // Import the Scanner class
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class symetricEncryptionKey {
//Methods
    private static final String AES = "AES";
	// We are using a Block cipher(CBC mode)
	private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";
	private static Scanner message;
	
    // Function to create a secret key
    public static SecretKey createAESKey()
        throws Exception
    {
        SecureRandom securerandom = new SecureRandom();
        KeyGenerator keygenerator = KeyGenerator.getInstance(AES);
        keygenerator.init(256, securerandom);
        SecretKey key = keygenerator.generateKey();
        return key;
    }
    // Function to initialize a vector with an arbitrary value
    public static byte[] createInitializationVector()
    {
 
        // Used with encryption
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext,
    // the key with an initialization
    // vector to convert plainText
    // into CipherText.
    public static byte[] do_AESEncryption(
        String plainText,
        SecretKey secretKey,
        byte[] initializationVector)
        throws Exception
    {
        Cipher cipher= Cipher.getInstance(
                AES_CIPHER_ALGORITHM);
 
        IvParameterSpec ivParameterSpec
            = new IvParameterSpec(
                initializationVector);
 
        cipher.init(Cipher.ENCRYPT_MODE,
                    secretKey,
                    ivParameterSpec);
 
        return cipher.doFinal(
            plainText.getBytes());
    }
 
    // This function performs the
    // reverse operation of the
    // do_AESEncryption function.
    // It converts ciphertext to
    // the plaintext using the key.
    public static String do_AESDecryption(
        byte[] cipherText,
        SecretKey secretKey,
        byte[] initializationVector)
        throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
 
        IvParameterSpec ivParameterSpec
            = new IvParameterSpec(
                initializationVector);
 
        cipher.init(
            Cipher.DECRYPT_MODE,
            secretKey,
            ivParameterSpec);
 
        byte[] result
            = cipher.doFinal(cipherText);
 
        return new String(result);
    }    
	
//Main Method
	public static void main(String[] args) {
		//Input Phase: The user provides a text string and a shared key. Example: Input text is "Confidential Message" and the key is "MySecureKey!".
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter a text string");
	    String textString = myObj.nextLine();  // Read user input
	    System.out.println("The unencrypted string is: " + textString);
	    
	    
	    //Key generation phase:
	    

	    //Encryption Phase: The text is encrypted using the shared key. Example: The program transforms "Confidential Message" into "3cL7pQ==%!".
	    System.out.println("The encrypted string is: ");


	    //Decryption Phase: The encrypted text is decrypted back into its original form using the same key. Example: "3cL7pQ==%!" is decrypted to "Confidential Message".
	    System.out.println("The decrypted string is: ");
	}//Main Method End
}//Class End





/*
References
What is AES: https://www.techtarget.com/searchsecurity/definition/Advanced-Encryption-Standard
	What are bits: https://www.youtube.com/watch?v=y8Aw6AnQMws
	What are data leaks: https://abnormalsecurity.com/glossary/data-leak
	Difference between Symmetric and asymmetric data: https://www.youtube.com/watch?v=nRou-J4YN4Y

How to do Symmetric Encryption: https://www.geeksforgeeks.org/symmetric-encryption-cryptography-in-java/
	Complicated example: https://www.baeldung.com/java-aes-encryption-decryption

Notes
- AES is a form of symmetric encryption 
*/