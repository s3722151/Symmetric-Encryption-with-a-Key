# Symmetric-Encryption-with-a-Key
Summary
This project involves implementing a program in Java that uses symmetric encryption to secure text. It will allow users to input a shared key and text, encrypt the text using a symmetric encryption algorithm (e.g., AES), and then decrypt the text back to its original form. The project will give you hands-on experience with cryptographic libraries, handling byte arrays, and basic exception management.

# Deadline
January 15, 2025 (2 weeks from now).

# Step-by-Step Explanation
1.Understand Symmetric Encryption:

Symmetric encryption uses a single shared key for both encryption and decryption.
Example: If the shared key is "123456", the program will use this key to scramble (encrypt) and unscramble (decrypt) a message.

2.Setup the Development Environment:

Ensure Java is installed on your system.
Use an IDE like IntelliJ IDEA or Eclipse.
Import necessary cryptographic libraries (javax.crypto).

3.User Input:

The program will prompt the user to input the text they want to encrypt and a shared key.
E.g.
Enter text to encrypt: HelloWorld  
Enter encryption key: MySecretKey

4.Encryption Process:

The text is converted into a byte array.
A cryptographic library (like AES) encrypts the byte array using the shared key.
The encrypted byte array is converted back into a readable format (e.g., Base64 string).

E.g. Encrypted Text: TWFuIGlzIGRpc3Q=

5.Decryption Process:

The user can input the encrypted text and the shared key.
The program will reverse the encryption process, converting the Base64 string back to a byte array, and decrypting it using the same shared key.
Example Output:

Decrypted Text: HelloWorld

6.Error Handling:

Handle incorrect inputs, such as a wrong key or malformed encrypted text.
Example: If the user enters the wrong key, the program should display an error message:
vbnet
Copy code
Error: Decryption failed. Check the key and try again.

7.Test Scenarios:

Test with different texts and keys to ensure the encryption and decryption work correctly.
Example Test:
Input:
makefile
Copy code
Text: Confidential  

Key: SafeKey123

Encrypted Text: bXlwa3NlcQ==

Decrypted Text: Confidential


# LOG
1/1/2025
Created the project

2/1/2025
Created the project files. Looked at this: https://www.youtube.com/watch?v=LPT7v69guVY&t=376s

3/1/2025
Created the java class and comments.