package com.vteba.security;

import java.security.spec.PKCS8EncodedKeySpec;

public class SecTest {

	public static void main(String[] args) {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(new byte[1]);
		keySpec.getEncoded();
//		Provider provider = new sun.security.pkcs11.SunPKCS11();
//		Security.addProvider(provider);
	}

}
