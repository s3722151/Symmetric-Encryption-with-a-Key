import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.util.Base64;
import java.util.Scanner; // Import the Scanner class

public class chatGptImprovements {
    public static void main(String[] args) {
        try {
            // Step 0: Take in user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a text string:");
            String plaintext = scanner.nextLine();
            System.out.println("The unencrypted string is: " + plaintext);

            // Step 1: Convert the text to bytes
            byte[] messageBytes = plaintext.getBytes("UTF-8");

            // Step 2: Create a KeyGenerator object - Generate a secret (symmetric) key
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");

            // Step 3: Initialize KeyGenerator - Set key size to 128 bits for compatibility
            keyGen.init(128);

            // Step 4: Generate the key
            Key key = keyGen.generateKey();

            // Step 5: Encrypt the message
            byte[] ciphertext = encryptMessage(messageBytes, key);

            // Step 6: Print the encrypted message in Base64 format
            String encodedCiphertext = Base64.getEncoder().encodeToString(ciphertext);
            System.out.println("Ciphertext (Base64 encoded): " + encodedCiphertext);

            // Step 7: Decrypt the message
            byte[] decryptedBytes = decryptMessage(ciphertext, key);

            // Step 8: Convert decrypted bytes to string and print
            String decryptedMessage = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted message: " + decryptedMessage);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Encrypts a message using AES and the provided key.
     *
     * @param messageBytes The plaintext message as a byte array.
     * @param key The AES key for encryption.
     * @return The encrypted message as a byte array.
     * @throws Exception If an error occurs during encryption.
     */
    private static byte[] encryptMessage(byte[] messageBytes, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(messageBytes);
    }

    /**
     * Decrypts a ciphertext using AES and the provided key.
     *
     * @param ciphertext The encrypted message as a byte array.
     * @param key The AES key for decryption.
     * @return The decrypted message as a byte array.
     * @throws Exception If an error occurs during decryption.
     */
    private static byte[] decryptMessage(byte[] ciphertext, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(ciphertext);
    }
}
