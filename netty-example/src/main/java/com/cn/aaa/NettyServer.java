package com.cn.aaa;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import javax.annotation.PostConstruct;

/**
 * @author by xiao
 * @Classname NettyServer
 * @Description
 * @Date 2020/1/9 9:51
 */
public class NettyServer {

    @PostConstruct
    public void initNetty() {
        new Thread() {
            public void run() {
                NettyServer.this.run();

            }
        }.start();
    }

    private void run() {
        System.out.println("===========================Netty端口启动========");
        // 主线程组，用于接收客户端的链接，但不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 从线程组，主线程组会把任务转给从线程组进行处理
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // 服务启动类，任务分配自动处理
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            // 设置NIO的双向通道
            b.channel(NioServerSocketChannel.class);
            // ChildChannelHandler 对出入的数据进行的业务操作,其继承ChannelInitializer
            b.childHandler(new ChildChannelHandler());
            System.out.println("服务端开启等待客户端连接 ... ...");
            //绑定端口，并设置为同步方式，是一个异步的chanel
            Channel ch = b.bind(9889).sync().channel();
            //获取某个客户端所对应的chanel，关闭并设置同步方式
            ch.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
