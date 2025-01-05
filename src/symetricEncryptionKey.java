import java.util.Scanner;  // Import the Scanner class

public class symetricEncryptionKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Input Phase: The user provides a text string and a shared key. Example: Input text is "Confidential Message" and the key is "MySecureKey!".
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter a text string");
	    String textString = myObj.nextLine();  // Read user input
	    System.out.println("The unencrypted string is: " + textString);
	    
	    
	    //Key generation phase:
	    
	    
	    //Encryption Phase: The text is encrypted using the shared key. Example: The program transforms "Confidential Message" into "3cL7pQ==%!".
	    System.out.println("The encrypted string is: ");


//		Decryption Phase: The encrypted text is decrypted back into its original form using the same key. Example: "3cL7pQ==%!" is decrypted to "Confidential Message".
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