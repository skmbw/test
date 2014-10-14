package com.vteba.test.thread;

/**
 * 通过interrupted和sleep中断线程，停止线程的执行.
 * 
 * @version V1.0 ,2011-4-15
 * @author xiahui
 */
public class InterruptThread4 extends Thread {
    private double d = 0.0;

    public void run() {
        try {
            // 检查程序是否发生中断
            while (!Thread.interrupted()) {
                System.out.println("I am running!");
                // before sleep
                Thread.sleep(20);
                //after sleep
                System.out.println("Calculating");
                for (int i = 0; i < 900000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
            }

        } catch (InterruptedException e) {
            System.out.println("InterruptThread4.run() Exception!");
        }

        System.out.println("InterruptThread4.run() end!");
    }

    public static void main(String[] args) throws Exception {
        // 将任务交给一个线程执行
        InterruptThread4 t = new InterruptThread4();
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(200);
        System.out.println("****************************");
        System.out.println("Interrupted Thread!");
        System.out.println("****************************");
        t.interrupt();
    }
}