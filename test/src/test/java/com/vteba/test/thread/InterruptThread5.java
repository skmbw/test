package com.vteba.test.thread;

/**
 * 通过共享变量中断线程，停止线程的执行.
 * @version V1.0 ,2011-4-15
 * @author xiahui
 */
public class InterruptThread5 extends Thread {
    private double d = 0.0;
    volatile boolean stop = false;
    
    public void run() {
        // 检查程序是否发生中断
        while (!stop) {
            System.out.println("I am running!");

            for (int i = 0; i < 900000; i++) {
                d = d + (Math.PI + Math.E) / d;
            }
        }
        //做一些清理工作
        System.out.println( "Thread is exiting under request..." );
    }

    public static void main(String[] args) throws Exception {
        // 将任务交给一个线程执行
        InterruptThread5 t = new InterruptThread5();
        t.start();

        // 运行一断时间中断线程
        Thread.sleep(100);
        System.out.println( "Asking thread to stop..." );
        t.stop = true;

        Thread.sleep(1000 );
        System.out.println( "Stopping application..." );
    }
}
