import java.util.ArrayList;
import java.util.Scanner;

public class ShiftCipher {
	public static String encrypt(String input, int shift) {
		ArrayList<Character> cipherText = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			int letter = input.charAt(i);

			if (Character.isUpperCase(letter)) {
				letter = letter + shift;
				if (letter > 'Z') {
					letter = letter - 26;
				}
			} else if (Character.isLowerCase(letter)) {
				letter = letter + shift;
				if (letter > 'z') {
					letter = letter - 26;
				}
			}
			cipherText.add((char) letter);
		}

		StringBuilder builder = new StringBuilder();
		for (Character value : cipherText) {
			builder.append(value);
		}

		String encryptedText = builder.toString();
		return encryptedText;
	}

	public static String decrypt(String input, int shift) {
		ArrayList<Character> plainText = new ArrayList<Character>();
		for (int i = 0; i < input.length(); i++) {
			int letter = input.charAt(i);

			if (Character.isUpperCase(letter)) {
				letter = letter - shift;
				if (letter < 'A')
					letter = letter + 26;
			} else if (Character.isLowerCase(letter)) {
				letter = letter - shift;
				if (letter < 'a')
					letter = letter + 26;
			}
			plainText.add((char) letter);
		}

		StringBuilder cbuilder = new StringBuilder();
		for (Character value : plainText) {
			cbuilder.append(value);
		}

		String decrypted = cbuilder.toString();
		return decrypted;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Type in a word: ");
		String input = in.nextLine();

		System.out.print("Type in shift value: ");
		int shift = in.nextInt();

		System.out.println("Encrypted: " + encrypt(input, shift));

		String cipher = encrypt(input, shift);

		System.out.print("Do you want to decrypt messgae (y/n): ");
		String userInput = in.next().toLowerCase();

		if (userInput.equals("y")) {
			System.out.println("Decrypted: " + decrypt(cipher, shift));
		}

		in.close();

	}
}
