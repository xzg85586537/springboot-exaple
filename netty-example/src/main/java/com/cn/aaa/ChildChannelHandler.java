package com.cn.aaa;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author by xiao
 * @Classname ChildChannelHandler
 * @Description 初始化器，chanel注册后会执行里面相应的初始化方法(也就是将handler逐个进行添加)
 * @Date 2020/1/9 9:56
 */
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        // HttpServerCodec：将请求和应答消息解码为HTTP消息
        e.pipeline().addLast("http-codec", new HttpServerCodec());
        // HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息
        e.pipeline().addLast("aggregator", new HttpObjectAggregator(165536));
        // ChunkedWriteHandler：向客户端发送HTML5文件
        e.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        e.pipeline().addLast("handler", new WebSocketServerHandler());
    }
}
