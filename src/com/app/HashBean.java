package com.app;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashBean {
	public static String getMd5(String passsword) {
		try {
			MessageDigest dig = MessageDigest.getInstance("MD5");
			byte[] hash;
			dig.reset();
			hash = dig.digest(passsword.getBytes());
			String hashPass;
			hashPass = new BigInteger(1,hash).toString(16);
			return hashPass;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		
	}
}
