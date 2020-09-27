package com.vteba.netty.server;

import com.vteba.utils.charstr.Char;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
	
	private ServerHandler serverHandler;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();// 管道线，相当于过滤器
		
		//******ChannelOutboundHandler（返回数据给调用端）向外发送数据，逆序执行******/
		// 2、加上头长度
		pipeline.addLast("lengthPrepender", new LengthFieldPrepender(4));
		// 1、将字符转成字节
		pipeline.addLast("encoder", new StringEncoder(Char.UTF8));
		
		// 0、logger既是Inbound，又是Outbound，发送或者接收数据，第一个Handler都是日志Handler，所以放在中间
		pipeline.addLast("logger", new LoggingHandler(LogLevel.INFO));
		
		//**********ChannelInboundHandler（接受数据），进来数据，顺序执行*************/
		
		// 1、获取去掉头长度的数据
		pipeline.addLast("lengthFieldFrameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
		// 2、解码数据，转成字符串
		pipeline.addLast("decoder", new StringDecoder(Char.UTF8));
		// 3、真正的业务处理器，一般放在最后（因为需要前面解码器的数据等），是ChannelInboundHandler
		pipeline.addLast("serverHandler", serverHandler);
	}

}
