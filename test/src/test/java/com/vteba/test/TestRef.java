package com.vteba.test;

public class TestRef {
	public static void main(String[] args) {
		Integer i = 127;
		Integer j = 127;
		Integer m = 200;
		Integer n = 200;
		System.out.println(i == j);
		System.out.println(m == n);
		System.out.println(i.equals(j));
		System.out.println(m.equals(n));
	}
}
