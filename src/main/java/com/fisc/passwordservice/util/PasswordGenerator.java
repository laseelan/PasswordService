package com.fisc.passwordservice.util;

import java.security.SecureRandom;
import java.util.Random;

public class PasswordGenerator {

	private static final Random RANDOM = new SecureRandom();
	/**
	 * Generate a random String suitable for use as a temporary password.
	 */
	public static String generateRandomPassword(int passwordLength) {

		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

		String pw = "";
		for (int i = 0; i < passwordLength; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw += letters.substring(index, index + 1);
		}
		return pw;
	}

}