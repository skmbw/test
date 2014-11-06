package com.vteba.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 启动Netty Server守护进程
 * @author yinlei
 * @date 2014-6-22
 */
public class Server {

	private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
	
	private ServerChannelInitializer serverChannelInitializer;
	
	public void start() {
		LOGGER.info("Netty Server守护进程启动。");
		EventLoopGroup bossEventLoopGroup = new NioEventLoopGroup();// 监听线程组，分派任务的主管
		EventLoopGroup workerEventLoopGroup = new NioEventLoopGroup();// 工作线程组，具体干活的员工
		
		try {
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossEventLoopGroup, workerEventLoopGroup)
				.channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.INFO))
				.childHandler(serverChannelInitializer);
			
			// 绑定监听的端口
			ChannelFuture future = serverBootstrap.bind(8080).sync();
			// 等待直到链接被关闭
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			LOGGER.error("Netty Server守护进程启动异常。", e);
		} finally {
			// 关闭线程池，释放资源
			bossEventLoopGroup.shutdownGracefully();
			workerEventLoopGroup.shutdownGracefully();
		}
	}

}
