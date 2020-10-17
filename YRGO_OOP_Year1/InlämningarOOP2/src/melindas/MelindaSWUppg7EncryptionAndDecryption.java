package melindas;

import java.util.Scanner;

public class MelindaSWUppg7EncryptionAndDecryption {
	
	private char[] keys = {'a', 'K', 'e', 'r', 'f', 'A', 'u', 'q', 'w', 'Q', 't', '9'};
	
	public String encrypt(String text) {
		
//		Varje char i texten ska xor'as mot chartecknen i nyckelarrayen.		
		StringBuilder encryptedText = new StringBuilder();
		char textCharArray[] = text.toCharArray();
		int keyArrayIndex = 0;
		
		for (int i = 0; i < textCharArray.length; i += 1) {
			
			encryptedText.append((textCharArray[i] ^ keys[keyArrayIndex]) + " ");
			
//			Om längden på stringen är längre än nyckeln så ska nyckeln börja om på position 0 igen.
			keyArrayIndex += 1;
			if (keyArrayIndex == keys.length) {
				keyArrayIndex = 0;
			}
		}
		
		return encryptedText.toString();
	}
	
	
	public String decrypt(String text) {
		
//		Varje värde i de xxorade tecknen ska xoras mot nyckeln igen.
		
		StringBuilder decryptedText = new StringBuilder();
		Scanner sc = new Scanner(text);
		int keyArrayIndex = 0;

		while (sc.hasNext()) {
			
			decryptedText.append((char) (sc.nextInt() ^ keys[keyArrayIndex]));
			
			keyArrayIndex += 1;
			if (keyArrayIndex == keys.length) {
				keyArrayIndex = 0;
			}
			
		}
		
		return decryptedText.toString();
	}
}


