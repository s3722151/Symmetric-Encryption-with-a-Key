import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.util.Scanner;  // Import the Scanner class

public class Demo1 {
    public static void main(String[] args) throws Exception {
    	
    	//Step 0: Take in user input
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter a text string");
	    String textString = myObj.nextLine();  // Read user input
	    System.out.println("The unencrypted string is: " + textString);

        // Step 1: Convert the text to bytes.
        //byte[] message = "Hello, World!".getBytes();
        byte[] message = textString.getBytes();

        // Step 2: Create a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");

        // Step 3: Initialize the KeyGenerator with a keysize
        keyGen.init(256);

        // Step 4: Generate the key
        Key key = keyGen.generateKey();

        // Step 5: Create a Cipher object
        Cipher cipher = Cipher.getInstance("AES");

        // Step 6: Initialize the Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Step 7: Give the Cipher our message
        cipher.update(message);

        // Step 8: Encrypt the message
        byte[] ciphertext = cipher.doFinal();

        // Step 9: Print the ciphertext
        System.out.println("message: " + new String(message, "UTF8"));
        System.out.println("ciphertext: " + new String(ciphertext, "UTF8"));

        // Step 10: Change the Cipher object's mode
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Step 11: Give the Cipher objectour ciphertext
        cipher.update(ciphertext);

        // Step 12: Decrypt the ciphertext
        byte[] decrypted = cipher.doFinal();
        System.out.println("Cipher text that was decrypted is: " + new String(decrypted, "UTF8"));
    }

}

//Source
//https://gregorycernera.medium.com/encrypting-and-decrypting-a-message-using-symmetric-keys-with-java-explained-step-by-step-with-a523b67877d8
