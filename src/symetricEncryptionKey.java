import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.util.Scanner;  // Import the Scanner class


public class symetricEncryptionKey {
	public static void main(String[] args) throws Exception {
	
    	//Step 0: Take in user input
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter a text string");
	    String textString = myObj.nextLine();  // Read user input
	    System.out.println("The unencrypted string is: " + textString);

        // Step 1: Convert the text to bytes.
        //byte[] message = "Hello, World!".getBytes();
        byte[] message = textString.getBytes();

        // Step 2: Create a KeyGenerator object - Generate a secret (symmetric) key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");

        // Step 3: Initialize KeyGenerator - tell how many bytes we want our key to be.
        keyGen.init(256);

        // Step 4: Generate the key
        Key key = keyGen.generateKey();

        // Step 5: Create a Cipher object -  handle our encryption and decryption
        Cipher cipher = Cipher.getInstance("AES");

        // Step 6: Initialize the Cipher object - Tell to encrypt
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Step 7: Give the Cipher our message
        cipher.update(message);

        // Step 8: Encrypt the message
        byte[] ciphertext = cipher.doFinal();

        // Step 9: Print the ciphertext
        System.out.println("Plain message, unencrypted input is: " + new String(message, "UTF8"));
        System.out.println("Ciphertext, encrypted input is now: " + new String(ciphertext, "UTF8"));

        // Step 10: Change the Cipher object's mode - Tell to decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Step 11: Give the Cipher object our ciphertext
        cipher.update(ciphertext);

        // Step 12: Decrypt the ciphertext
        byte[] decrypted = cipher.doFinal();
        System.out.println("Cipher text that was decrypted is: " + new String(decrypted, "UTF8"));
	}//Main Method End
}//Class End


/*
References
What is AES: https://www.techtarget.com/searchsecurity/definition/Advanced-Encryption-Standard
	What are bits: https://www.youtube.com/watch?v=y8Aw6AnQMws
	What are data leaks: https://abnormalsecurity.com/glossary/data-leak
	Difference between Symmetric and asymmetric data: https://www.youtube.com/watch?v=nRou-J4YN4Y


How to do Symmetric Encryption: https://gregorycernera.medium.com/encrypting-and-decrypting-a-message-using-symmetric-keys-with-java-explained-step-by-step-with-a523b67877d8
	Broken example: https://www.geeksforgeeks.org/symmetric-encryption-cryptography-in-java/
	Complicated example: https://www.baeldung.com/java-aes-encryption-decryption

Notes
- AES is a form of symmetric encryption 
- Symmetric encryption is good if you decryot with private key

Does it work?
My code works as part of project requirements

Areas of improvement 
1.Key Size Initialization:
	You initialize the key generator with 256 bits, which is fine, 
	but note that using a 256-bit key in AES requires additional configuration in Java 
	(e.g., installing the Unlimited Strength Jurisdiction Policy Files in older JDK versions). 
	If not installed, the program might throw an exception on some systems.
	To ensure broader compatibility, you might consider using a 128-bit key (keyGen.init(128)).

2.Readable Ciphertext Output:
	The ciphertext is printed using new String(ciphertext, "UTF8"), 
	which might not display correctly because ciphertext bytes can include non-printable characters. 
	Using Base64 encoding (Base64.getEncoder().encodeToString(ciphertext)) 
	is more appropriate for readable output.

3.Error Handling:
	Your program uses a blanket throws Exception, which could mask specific issues (e.g., invalid inputs, cryptographic errors). 
	Catching and handling exceptions like IllegalBlockSizeException or BadPaddingException would improve robustness.

4.Code Modularity:
Separating encryption and decryption logic into reusable methods would improve readability and maintainability.


*/