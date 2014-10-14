package com.vteba.test;

public class ThreadTest implements Runnable {

	public static void main(String[] args) {
		ThreadTest target = new ThreadTest();
		Thread thread = new Thread(target);
		thread.interrupt();
		for (;!thread.isInterrupted();) {
			
		}

	}

	@Override
	public void run() {
		
		
	}

}
