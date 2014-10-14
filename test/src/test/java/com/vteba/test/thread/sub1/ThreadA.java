package com.vteba.test.thread.sub1;

/**
 * 可以正常退出
 */
public class ThreadA extends Thread {
    private boolean isInterrupted=false;
   int count=0;
   
   public void interrupt(){
       isInterrupted = true;
       super.interrupt();
      }
   
   public void run(){
       System.out.println(getName()+"将要运行...");
       while(!isInterrupted){
           System.out.println(getName()+"运行中"+count++);
           try{
               Thread.sleep(400);
           }catch(InterruptedException e){
               System.out.println(getName()+"从阻塞中退出...");
               System.out.println("this.isInterrupted()="+this.isInterrupted());

           }
       }
       System.out.println(getName()+"已经终止!");
   }
}
