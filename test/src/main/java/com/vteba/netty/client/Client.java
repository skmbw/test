package com.vteba.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	
	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		LOGGER.info("Netty Server守护进程启动。");
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();// 监听线程组，分派任务的主管
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(eventLoopGroup)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ChannelPipeline pipeline = ch.pipeline();
						// 这些handler，进来的时候（接收服务端返回的数据）是顺序执行handler，从上到下
						// 出去的时候（发送数据给server端），是逆序执行handler，从下到上
						pipeline.addLast("logger", new LoggingHandler(LogLevel.INFO));
						pipeline.addLast("lengthFrameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 0));
						pipeline.addLast("clientHandler", new ClientHandler());
					}
				});
			
			// 连接server
			ChannelFuture future = bootstrap.connect("127.0.0.1", 8080).sync();
			// 等待直到链接被关闭
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			LOGGER.error("Netty Client调用启动异常。", e);
		} finally {
			// 关闭线程池，释放资源
			eventLoopGroup.shutdownGracefully();
		}
	}
}
