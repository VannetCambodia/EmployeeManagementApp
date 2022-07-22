package ems.management.Util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import ems.management.model.EmployeeModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
	
	private static String SECRET_KEY = "abcdefghijklmnOPQRSTUVWXYZ";
	
	@SuppressWarnings("deprecation")
	public static String generateAccessToken(EmployeeModel employeeModel) {
		return Jwts.builder()
				.setSubject(String.format("%s %s", employeeModel.getId(), employeeModel.getEmailAddress()))
				.setIssuer("EmployeeManagement")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
}
