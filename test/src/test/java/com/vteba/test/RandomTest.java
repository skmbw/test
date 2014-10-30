package com.vteba.test;

import java.util.Random;

import org.junit.Test;

public class RandomTest {
	
	@Test
	public void test() {
		Random random = new Random();
		int result = random.nextInt(200);
		System.out.println(result);
	}
}
