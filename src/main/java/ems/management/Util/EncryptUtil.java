package ems.management.Util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	
	public static String encryptPassword(String input) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger bigInteger = new BigInteger(1, messageDigest);
        String hashTxt = bigInteger.toString(16);
        while (hashTxt.length()<32){
            hashTxt = "0" + hashTxt;
        }
        return hashTxt;
	}

}
