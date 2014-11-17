package com.vteba.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioSocketTest {
	public void test() throws IOException {
		// 1、打开ServerSocketChannel，用于监听客户端的连接，它是所有客户端连接的父通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		SocketAddress local = new InetSocketAddress("127.0.0.1", 8080);
		// 2、绑定监听端口，设置客户端连接方式为非阻塞模式
		serverSocketChannel.bind(local);
		serverSocketChannel.configureBlocking(false);
		// 3、创建Reactor线程，打开多路复用器并启动服务端监听线程，通常情况下，可以采用线程池的方式创建Reactor线程
		Selector selector = Selector.open();
		// 4、将ServerSocketChannel注册到Reactor线程的多路复用器Selector上，监听ACCEPT状态位
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (true) {// 5、多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
			selector.select();// 开始监听事件，这里会阻塞，直到有时间发生
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			for (SelectionKey key : selectedKeys) {
				switch (key.readyOps()) {// 处理就绪的事件
				case SelectionKey.OP_ACCEPT:// 6、多路复用器监听到有新的客户端接入，处理新的接入请求，与客户端建立物理链路
					ServerSocketChannel server = (ServerSocketChannel)key.channel();
		            SocketChannel sc = server.accept();
		            sc.configureBlocking(false);
		            //7 、将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作位，用来读取客户端发送的网络消息
		            sc.register(selector, SelectionKey.OP_READ);//注册读事件，开始监听读事件
				case SelectionKey.OP_READ:
					SocketChannel socketChannel = (SocketChannel) key.channel();
					socketChannel.configureBlocking(false);// 8、设置socket参数等
					socketChannel.socket().setReuseAddress(true);
					ByteBuffer bytes = ByteBuffer.allocate(2048);
					socketChannel.read(bytes);// 9、读取数据
				case SelectionKey.OP_WRITE:
					
				case SelectionKey.OP_CONNECT:
					
				default:
					break;
				}
				
			}
		}

	}
}
