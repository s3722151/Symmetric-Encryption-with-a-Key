# Symmetric-Encryption-with-a-Key
The project involves creating a Java program that implements a symmetric encryption algorithm, such as AES (Advanced Encryption Standard). he program will allow the user to encrypt and decrypt text using a shared key. This project introduces you to the fundamentals of cryptography, Java cryptographic libraries, and working with data in different formats (byte arrays and strings). It also includes basic exception handling to manage potential errors during encryption and decryption.

# Deadline
January 31, 2025
You have about a month to complete the project, which should provide sufficient time to learn, implement, and test the program.

# Step-by-Step Explanation
Understand Symmetric Encryption

Symmetric encryption uses the same key for both encryption and decryption.
Example: If the key is mysecretkey123, the plaintext "Hello" could be transformed into ciphertext "A12b34!@". The same key is required to reverse the ciphertext back to "Hello".
Project Flow

Input Phase:
The user provides a text string and a shared key.
Example: Input text is "Confidential Message" and the key is "MySecureKey!".

Encryption Phase:
The text is encrypted using the shared key.
Example: The program transforms "Confidential Message" into "3cL7pQ==%!".

Decryption Phase:
The encrypted text is decrypted back into its original form using the same key.
Example: "3cL7pQ==%!" is decrypted to "Confidential Message".

Java Cryptographic Libraries

Use the javax.crypto package, which provides classes and methods for encryption and decryption.
Example: Classes like Cipher help you apply cryptographic transformations.
Working with Byte Arrays

Text is converted to a byte array before encryption and vice versa during decryption.
Example: "Hello" is converted into bytes [72, 101, 108, 108, 111] before encryption.
Error Handling

Implement basic exception handling to ensure the program doesn't crash when invalid inputs are provided or if encryption fails.
Example: If the key length is incorrect, the program should display a clear error message like "Invalid key length!".
Examples of Use Case

User Input:

Plaintext: "My Secret Text"
Key: "Secure123!"
Program Output:

Encrypted Text: "7@f92T+Zf!"
Decrypted Text: "My Secret Text"
Testing the Program

Test with various keys and plaintext inputs.
Handle edge cases, such as empty input or incorrect keys during decryption.
