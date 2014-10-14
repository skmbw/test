package com.vteba.test.thread;

/**
 * 通过interrupted中断线程，停止线程的执行.
 * 
 * @version V1.0 ,2011-4-15
 * @author xiahui
 */
public class InterruptThread3 extends Thread {
    private double d = 0.0;

    public void run() {
        // 检查程序是否发生中断
        while (!Thread.interrupted()) {
            System.out.println("I am running!");

            for (int i = 0; i < 900000; i++) {
                d = d + (Math.PI + Math.E) / d;
            }
        }
        System.out.println("线程接受中断了。退出");
    }

    public static void main(String[] args) throws Exception {
        // 将任务交给一个线程执行
        InterruptThread3 t = new InterruptThread3();
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
    }
}
