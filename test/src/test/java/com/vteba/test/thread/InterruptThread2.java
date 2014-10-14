package com.vteba.test.thread;

/**
 * 通过线程sleep时调用Interrupt引发异常，停止线程的运行.
 * @version V1.0 ,2011-4-15
 * @author xiahui
 */
public class InterruptThread2 extends Thread {
    private double d = 0.0;

    public void run() {
    try { 
        // 死循环执行打印"I am running!" 和做消耗时间的浮点计算
        while (true) {
            System.out.println("I am running!");

            for (int i = 0; i < 900000; i++) {
                d = d + (Math.PI + Math.E) / d;
            }
            //休眠一断时间,中断时会抛出InterruptedException 
            Thread.sleep(50);
        }
     }catch (InterruptedException e) { 
         System.out.println("InterruptThread1.run() interrupted!");
    }
    System.out.println("线程sleep时被中断");
    }

    public static void main(String[] args) throws Exception {
        // 将任务交给一个线程执行
        InterruptThread2 t = new InterruptThread2();
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
    }
}
