package com.vteba.security;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.jose.jwe.JWEBuilder;
import org.jboss.resteasy.jose.jwe.JWEInput;
import org.jboss.resteasy.jose.jws.JWSBuilder;
import org.jboss.resteasy.jose.jws.JWSInput;
import org.jboss.resteasy.jose.jws.crypto.RSAProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.junit.Assert;
import org.junit.Test;

public class JSecTest {
	private String name;
	private Integer age;
	private Date birth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public static void main(String[] args) throws Exception {
		File file = new File("");
		URI uri = file.toURI();
		try {
			URL url = uri.toURL();
			System.out.println(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

//		@SuppressWarnings("restriction")
//		Provider provider = new sun.security.pkcs11.SunPKCS11();
//		Security.addProvider(provider);
		
		PrivateKey privateKey = keyPair.getPrivate();
		Signature signature = Signature.getInstance("SHA512withRSA");
		signature.initSign(privateKey);
		System.out.println(signature);
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
	}

	private static KeyPair keyPair = null;
	@SuppressWarnings("unused")
	private static KeyPair dsaKeyPair = null;
	static {
		try {
			dsaKeyPair = KeyPairGenerator.getInstance("DSA").genKeyPair();// 和方法generateKeyPair等同
			KeyPairGenerator rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPair = rsaKeyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 私钥签名，公钥验证
	 * @throws Exception
	 */
	@Test
	public void testRSAWithContentType() throws Exception {
		

		String encoded = new JWSBuilder().content("Hello World".getBytes())
//				.contentType(MediaType.TEXT_PLAIN_TYPE)//这个也是可以的
//				.content("Hello World", MediaType.TEXT_PLAIN_TYPE)
				.rsa256(keyPair.getPrivate());

		System.out.println("testRSAWithContentType encoded: " + encoded);

		JWSInput input = new JWSInput(encoded,
				ResteasyProviderFactory.getInstance());
//		System.out.println(input.getHeader());
		String msg = (String) input.readContent(String.class);
		Assert.assertEquals("Hello World", msg);
		Assert.assertTrue(RSAProvider.verify(input, keyPair.getPublic()));

	}

	/**
	 * 公钥签名，私钥解密
	 * @throws Exception
	 */
	@Test
	public void testRSA() throws Exception {
		//KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();

		String content = "Live long and prosper.";

		{
			
			PublicKey publicKey = keyPair.getPublic();
			RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
			String encoded = new JWEBuilder()
					.contentBytes(content.getBytes())
					.RSA1_5(rsaPublicKey);
			System.out.println("encoded: " + encoded);
			byte[] raw = new JWEInput(encoded).decrypt(
					(RSAPrivateKey) keyPair.getPrivate()).getRawContent();
			String from = new String(raw);
			Assert.assertEquals(content, from);
		}
		{
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			String encoded = new JWEBuilder().contentBytes(content.getBytes())
					.RSA_OAEP(rsaPublicKey);
			System.out.println("encoded: " + encoded);
			byte[] raw = new JWEInput(encoded).decrypt(
					(RSAPrivateKey) keyPair.getPrivate()).getRawContent();
			String from = new String(raw);
			Assert.assertEquals(content, from);
		}
		{
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			String encoded = new JWEBuilder().contentBytes(content.getBytes())
					.A128CBC_HS256().RSA1_5(rsaPublicKey);
			System.out.println("encoded: " + encoded);
			byte[] raw = new JWEInput(encoded).decrypt(
					(RSAPrivateKey) keyPair.getPrivate()).getRawContent();
			String from = new String(raw);
			Assert.assertEquals(content, from);
		}
		{
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			String encoded = new JWEBuilder().contentBytes(content.getBytes())
					.A128CBC_HS256()
					.RSA_OAEP(rsaPublicKey);
			System.out.println("encoded: " + encoded);
			byte[] raw = new JWEInput(encoded).decrypt(
					(RSAPrivateKey) keyPair.getPrivate()).getRawContent();
			String from = new String(raw);
			Assert.assertEquals(content, from);
		}
	}

	/**
	 * 直接加密和解密，不签名，不使用公钥和私钥
	 * @throws Exception
	 */
	@Test
	public void testDirect() throws Exception {
		String content = "Live long and prosper.";
		String encoded = new JWEBuilder().contentBytes(content.getBytes())./*dir是加入盐值*/dir("geheimaa");
		System.out.println("encoded: " + encoded);
		byte[] raw = new JWEInput(encoded).decrypt("geheimaa").getRawContent();
		String from = new String(raw);
		Assert.assertEquals(content, from);

	}
	
}

