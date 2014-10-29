package com.vteba.test;

import org.junit.Test;

public class Exchange {
	
	@Test
	public void change() {
		int a = 345;
		int b = 456;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a);
		System.out.println(b);
		
		String c = "345";
		String d = "456";
		c = c + d;
		d = c.replace(d, "");
		c = c.replace(d, "");
		System.out.println(c);
		System.out.println(d);
		switch (c) {
		case "a":
			
			break;

		default:
			break;
		}
		
//		long e = 4;
//		switch (e) {
//		case 5:
//			
//			break;
//
//		default:
//			break;
//		}
	}
}
