package com.common.filter.encrypt;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Sha512PasswordWrapper extends HttpServletRequestWrapper{

	public Sha512PasswordWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getParameter(String name) {
		
		String value = "";
		
		
				if(name.equals("password")) {
					
					value = getSHA512(super.getParameter(name));
					
				} else {
					
					value = super.getParameter(name);
				}
		
		return value;
	}
	
	
	private String getSHA512(String parameter) {
		String encPwd="";
		MessageDigest md = null;
		
			try {
					md=MessageDigest.getInstance("SHA-512");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		byte[] bytes = parameter.getBytes(Charset.forName("UTF-8"));
		md.update(bytes);
		
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		
		return encPwd;
	}

}
