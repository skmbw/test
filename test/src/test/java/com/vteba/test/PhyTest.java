package com.vteba.test;

import java.util.concurrent.Semaphore;

class Signs{
	final static int THINKING=0; //哲学家的状态THINGING
	final static int EATING=1; //哲学家的状态EATING
	static int[] status=new int[5]; //哲学家的状态，默认都是THINGING
	static Semaphore[] s=null; //信号量：记录哲学家是否可以进餐，不能进餐则堵塞
	static Semaphore mutex=new Semaphore(1); //临界区互斥访问信号量(二进制信号量)，相当于互斥锁
	
	//初始化每个哲学家的进餐信号量，默认值都不能进餐
	static{
		s=new Semaphore[5];
		for(int i=0;i<s.length;i++)
			s[i]=new Semaphore(0);
	};
}

class Philosopher implements Runnable{
	private int pid; //当前哲学家的序号
	private int lid; //坐在左手边的哲学家序号
	private int rid; //坐在右手边的哲学家序号
	
	Philosopher(int id){
		this.pid=id;
		this.lid=(id+4)%5;
		this.rid=(id+1)%5;
	}
	
	private void test(int pid){
		//如果当前哲学家左右手边的人都没有吃饭，则当前哲学家可以进餐
		if(Signs.status[pid]==Signs.THINKING&&Signs.status[lid]!=Signs.EATING&&Signs.status[rid]!=Signs.EATING){
			Signs.status[pid]=Signs.EATING; //此时当前哲学家线程可以进餐，但其他哲学家线程很可能无法进餐
			Signs.s[pid].release(); //释放一个许可
		}
	}
	
	public void run(){
		try {
			//尝试拿起叉子准备进餐
			Signs.mutex.acquire();
			test(pid);
			Signs.mutex.release();
				
			//判断当前哲学家的进餐信号量，如果不能许可进餐，则当前线程阻塞
			Signs.s[pid].acquire();
			System.out.println("#"+pid+" 号哲学家正在进餐...");
				
			//放下叉子，并唤醒旁边两个被阻塞进餐的哲学家，让他们尝试进餐
			Signs.mutex.acquire();
			Signs.status[pid]=Signs.THINKING;
			test(lid); //让左手边的哲学家尝试拿起叉子，如果可以，则释放这个哲学家的信号量许可
			test(rid); //同上
			Signs.mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


public class PhyTest{

	public static void main(String[] args) {
		new Thread(new Philosopher(0)).start();
		new Thread(new Philosopher(1)).start();
		new Thread(new Philosopher(2)).start();
		new Thread(new Philosopher(3)).start();
		new Thread(new Philosopher(4)).start();
	}
}
