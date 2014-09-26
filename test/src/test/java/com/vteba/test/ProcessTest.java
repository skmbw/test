package com.vteba.test;

public class ProcessTest {
	public static void main(String[] args) throws Exception {
	    final Process p = Runtime.getRuntime().exec("c:/1.bat");
	    long firstTime = System.currentTimeMillis();
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            try {
	                byte[] b = new byte[10240];
	                p.getInputStream().read(b);
	                System.out.println(new String(b));
	                p.waitFor();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }).start();
	    while (true) {
	        if (System.currentTimeMillis() - firstTime > 500) {
	            p.destroy();//命令执行时间超过2秒强制杀死进程
	            break;
	        }
	    }
	    System.out.println(p.exitValue());
	    byte[] b = new byte[10240];
	    p.getInputStream().read(b);
	    System.out.println(new String(b));
	}
}
