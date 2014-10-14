package com.vteba.test.thread;

/**
 * 中断一个正在执行的线程，但是并未实现中断.
 * @version V1.0 ,2011-4-15
 * @author xiahui
 */
public class InterruptThread1 extends Thread {
    private double d = 0.0;
    public void run() {
        // 死循环执行打印"I am running!" 和做消耗时间的浮点计算
        while (true) {
            System.out.println("I am running!");

            for (int i = 0; i < 900000; i++) {
                d = d + (Math.PI + Math.E) / d;
            }
            // 给线程调度器可以切换到其它进程的信号
            Thread.yield();
        }
    }
    public static void main(String[] args) throws Exception {
        // 将任务交给一个线程执行
        InterruptThread1 t = new InterruptThread1();
        t.start();
        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
    }
}
