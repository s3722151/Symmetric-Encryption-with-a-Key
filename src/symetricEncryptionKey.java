import java.util.Scanner;  // Import the Scanner class

public class symetricEncryptionKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Input Phase: The user provides a text string and a shared key. Example: Input text is "Confidential Message" and the key is "MySecureKey!".
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter a text string");

	    String textString = myObj.nextLine();  // Read user input
//
//		Encryption Phase: The text is encrypted using the shared key. Example: The program transforms "Confidential Message" into "3cL7pQ==%!".
//
//		Decryption Phase: The encrypted text is decrypted back into its original form using the same key. Example: "3cL7pQ==%!" is decrypted to "Confidential Message".


	}

}
