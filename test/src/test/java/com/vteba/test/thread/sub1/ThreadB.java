package com.vteba.test.thread.sub1;

/**
 * 不能正常退出的线程
 */
public class ThreadB extends Thread {
	int count = 0;

	public void run() {
		System.out.println(getName() + "将要运行...");
		while (!this.isInterrupted()) {
			System.out.println(getName() + "运行中" + count++);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// 一个线程抛出中断异常后，标志位会变为false，所以while中检查又为true了，会继续执行
				System.out.println(getName() + "从阻塞中退出...");
				System.out.println("this.isInterrupted()="
						+ this.isInterrupted());

			}
		}
		System.out.println(getName() + "已经终止!");
	}
}