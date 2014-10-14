package com.vteba.test.thread.sub1;

public class ThreadDemo {

	public static void main(String argv[]) throws InterruptedException {
		ThreadA ta = new ThreadA();
		ta.setName("ThreadA");
		ta.start();
		Thread.sleep(2000);
		System.out.println(ta.getName() + "正在被中断...");
		//ta.stop();
		//ta.interrupt();
		Thread.currentThread().interrupt();
		System.out.println("ta.isInterrupted()=" + ta.isInterrupted());
	}

}
