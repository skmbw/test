package com.vteba.test.system;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;

import javax.management.MBeanServer;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

@SuppressWarnings("restriction")
public class JMXF {

	public static void main(String[] args) {
		ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
		classLoadingMXBean.getLoadedClassCount();
		
		CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
		System.out.println("JIT编译器名：" + compilationMXBean.getName());
		System.out.println("JIT总的编译时间：" + compilationMXBean.getTotalCompilationTime());
		
//		List<MemoryManagerMXBean> memoryManagerMXBeanList = ManagementFactory.getMemoryManagerMXBeans();
//		for (MemoryManagerMXBean memoryManagerMXBean : memoryManagerMXBeanList) {
//			System.out.println(memoryManagerMXBean.getName());
//			System.out.println(Arrays.toString(memoryManagerMXBean.getMemoryPoolNames()));
//		}
		
		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		System.out.println("堆内存：" + memoryMXBean.getHeapMemoryUsage());
		System.out.println("非堆内存：" + memoryMXBean.getNonHeapMemoryUsage());
		
//		List<MemoryPoolMXBean> memoryPoolMXBeanList = ManagementFactory.getMemoryPoolMXBeans();
//		for (MemoryPoolMXBean bean : memoryPoolMXBeanList) {
//			System.out.println(bean.getName());
//		}
		
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		System.out.println("操作系统架构：" + operatingSystemMXBean.getArch());
		System.out.println("CPU核心数：" + operatingSystemMXBean.getAvailableProcessors());
		System.out.println("操作系统名：" + operatingSystemMXBean.getName());
		System.out.println("操作系统版本：" + operatingSystemMXBean.getVersion());
		
		com.sun.management.OperatingSystemMXBean osMxBean = (com.sun.management.OperatingSystemMXBean) operatingSystemMXBean;
		osMxBean.getCommittedVirtualMemorySize();
		System.out.println("剩余物理内存：" + osMxBean.getFreePhysicalMemorySize());
		osMxBean.getFreeSwapSpaceSize();
		System.out.println("总的物理内存：" + osMxBean.getTotalPhysicalMemorySize());
		System.out.println("总的swap交换空间：" + osMxBean.getTotalSwapSpaceSize());
		
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		mBeanServer.getMBeanCount();
		
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		System.out.println("Java虚拟机规范供应商：" + runtimeMXBean.getSpecVendor());
		
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		System.out.println("线程数：" + threadMXBean.getThreadCount());
		
		long freeMemory = Runtime.getRuntime().freeMemory() / 1024;
		System.out.println("剩余内存：" + freeMemory + " kb");
		System.out.println("可使用内存：" + (Runtime.getRuntime().totalMemory() / 1024) + " kb");
		
		System.out.println("最大可使用内存：" + (Runtime.getRuntime().maxMemory() / 1024) + "kb");
		
		Sigar sigar = new Sigar();
		Cpu cpu = null;
		try {
			cpu = sigar.getCpu();
		} catch (SigarException e) {
			e.printStackTrace();
		}
		
		System.out.println("cpu idle:" + cpu.getIdle());
		
		
		LoadInfo loadInfo = new LoadInfoImpl();
		System.out.println("cpu使用率：" + loadInfo.getCpuInfo());
		System.out.println("网络信息：" + loadInfo.getNetworkInfo());
		System.out.println("内存信息：" + loadInfo.getRamInfo());
		System.out.println("运行信息：" + loadInfo.getRunLoadInfo());
		System.out.println("系统信息：" + loadInfo.getSystemInfo());
		System.out.println("java虚拟机内存：" + loadInfo.getVmRamInfo());
	}

}
