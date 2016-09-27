package com.fisc.passwordservice.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.UUID;

public class EncryptUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String generateUniqueID() {
		UUID idOne = UUID.randomUUID();
		return idOne.toString();
	}

	public static String getMD5String(String target) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(target.getBytes());
			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}