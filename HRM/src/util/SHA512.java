package util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @brief sha512 암호화 클래스입니다
 * @author 이현우
 * @version v 1.00 (2020.02.23)
 * @see 
 *      
 */
public class SHA512 {

    public static String getSHA512(String input){

	String toReturn = null;
	try {
	    MessageDigest digest = MessageDigest.getInstance("SHA-512");
	    digest.reset();
	    digest.update(input.getBytes("utf8"));
	    toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
	return toReturn;
    }
    
}
