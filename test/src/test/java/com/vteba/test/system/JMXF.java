package com.vteba.test.system;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;

import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.DiskUsage;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemMap;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetInfo;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetRoute;
import org.hyperic.sigar.NetStat;
import org.hyperic.sigar.ProcStat;
import org.hyperic.sigar.ProcState;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.Tcp;
import org.hyperic.sigar.ThreadCpu;
import org.hyperic.sigar.Uptime;
import org.hyperic.sigar.Who;

@SuppressWarnings("restriction")
public class JMXF {

	public static void main(String[] args) {
		ClassLoadingMXBean classLoadingMXBean = ManagementFactory
				.getClassLoadingMXBean();
		classLoadingMXBean.getLoadedClassCount();

		CompilationMXBean compilationMXBean = ManagementFactory
				.getCompilationMXBean();
		System.out.println("JIT编译器名：" + compilationMXBean.getName());
		System.out.println("JIT总的编译时间："
				+ compilationMXBean.getTotalCompilationTime());

		// List<MemoryManagerMXBean> memoryManagerMXBeanList =
		// ManagementFactory.getMemoryManagerMXBeans();
		// for (MemoryManagerMXBean memoryManagerMXBean :
		// memoryManagerMXBeanList) {
		// System.out.println(memoryManagerMXBean.getName());
		// System.out.println(Arrays.toString(memoryManagerMXBean.getMemoryPoolNames()));
		// }

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
		System.out.println("堆内存：" + memoryMXBean.getHeapMemoryUsage());
		System.out.println("非堆内存：" + memoryMXBean.getNonHeapMemoryUsage());

		// List<MemoryPoolMXBean> memoryPoolMXBeanList =
		// ManagementFactory.getMemoryPoolMXBeans();
		// for (MemoryPoolMXBean bean : memoryPoolMXBeanList) {
		// System.out.println(bean.getName());
		// }

		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
				.getOperatingSystemMXBean();
		System.out.println("操作系统架构：" + operatingSystemMXBean.getArch());
		System.out.println("CPU核心数："
				+ operatingSystemMXBean.getAvailableProcessors());
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
		System.out.println("可使用内存："
				+ (Runtime.getRuntime().totalMemory() / 1024) + " kb");

		System.out.println("最大可使用内存："
				+ (Runtime.getRuntime().maxMemory() / 1024) + "kb");

		Sigar sigar = new Sigar();
		Cpu cpu = null;
		try {
			CpuInfo[] cpuInfos = sigar.getCpuInfoList();// 所有的cpu硬件信息
			cpu = sigar.getCpu();// 所有cpu核心，使用统计信息
			Cpu[] cpus = sigar.getCpuList();// 每一个cpu核心使用情况统计信息
			CpuPerc cpuPerc = sigar.getCpuPerc();// 所有cpu核心，使用百分比信息
			CpuPerc[] cpuPercs = sigar.getCpuPercList();// 每一个cpu使用百分比信息
			Mem mem = sigar.getMem();// 内存使用，统计信息
			Swap swap = sigar.getSwap();// 交换空间信息
			String fqdn = sigar.getFQDN();
			FileSystem[] fileSystems = sigar.getFileSystemList();
			for (FileSystem fs : fileSystems) {
				DiskUsage diskUsage = sigar.getDiskUsage(fs.getDevName());
				System.out.println(diskUsage);
			}
			FileSystemMap fileSystemMap = sigar.getFileSystemMap();
			// double[] loadAverages = sigar.getLoadAverage();// windows下没有
			File nativeLibary = sigar.getNativeLibrary();
			NetInfo netInfo = sigar.getNetInfo();
			NetInterfaceConfig netInterfaceConfig = sigar.getNetInterfaceConfig();
			String[] netInterfaceList = sigar.getNetInterfaceList();
			NetRoute[] netRoutes = sigar.getNetRouteList();
			NetStat netStat = sigar.getNetStat();
			long[] procList = sigar.getProcList();
			ProcStat procStat = sigar.getProcStat();// 进程统计信息
			ThreadCpu threadCpu = sigar.getThreadCpu();
			Tcp tcp = sigar.getTcp();
			Uptime uptime = sigar.getUptime();
			Who[] whoList = sigar.getWhoList();
			
			
			System.out.println();
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

		// other
		// Sigar sigar = new Sigar();

		try {
			long[] pids = sigar.getProcList();
			double total = 0;
			Map<String, Long> procName5PidMap = new HashMap<String, Long>();
			for (long pid : pids) {

				ProcState prs = sigar.getProcState(pid);
				
//				ProcCpu pCpu = new ProcCpu();
//				
//				pCpu.gather(sigar, pid);
//				// System.out.print(prs.getName());
//				// System.out.println(" pid: " + pid + " name:" +
//				// prs.getName());
//
//				total += pCpu.getTotal();
//				procName5PidMap.put(prs.getName(), pid);
			}
			// System.out.println("total : " + total);

			cpu = sigar.getCpu();
			System.out.println("idle: " + cpu.getIdle());// 获取整个系统cpu空闲时间
			System.out.println("irq: " + cpu.getIrq());
			System.out.println("nice: " + cpu.getNice());
			System.out.println("soft irq: " + cpu.getSoftIrq());
			System.out.println("stolen: " + cpu.getStolen());
			System.out.println("sys: " + cpu.getSys());
			System.out.println("total: " + cpu.getTotal());
			System.out.println("user: " + cpu.getUser());
			System.out.println();

			CpuPerc perc = sigar.getCpuPerc();
			System.out.println("整体cpu的占用情况:");
			System.out.println("system idle: " + perc.getIdle());// 获取当前cpu的空闲率
			System.out.println("conbined: " + perc.getCombined());// 获取当前cpu的占用率

			CpuPerc[] cpuPercs = sigar.getCpuPercList();
			System.out.println("每个cpu的资源占用情况:");
			for (CpuPerc cpuPerc : cpuPercs) {
				System.out.println("system idle: " + cpuPerc.getIdle());// 获取当前cpu的空闲率
				System.out.println("conbined: " + cpuPerc.getCombined());// 获取当前cpu的占用率
				System.out.println();
			}

			NetInfo netInfo = sigar.getNetInfo();
			System.out.println("网络信息:");
			System.out.println("gateway:" + netInfo.getDefaultGateway());
			System.out.println("domain name:" + netInfo.getDomainName());
			System.out.println("primary dns:" + netInfo.getPrimaryDns());
			while (true) {
				System.out.println("pid: " + sigar.getPid());// 获取当前java进程的pid
				Map map = sigar.getProcEnv(sigar.getPid());// 进程环境情况
				System.out.println("wait...");
				Thread.currentThread().sleep(10000000);
			}
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
