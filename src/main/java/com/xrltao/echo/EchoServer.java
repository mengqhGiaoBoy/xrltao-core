package com.xrltao.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * @author mengqh
 * @version 1.0
 * @date 2019/12/30 21:22
 * @Description
 */
public class EchoServer {
    private int port = 8080;

    public void run() throws InterruptedException {
        //线程组  需要关闭
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            //启动类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //设置线程组
            serverBootstrap.group(boosGroup, workGroup);
            //设置管道类型
            serverBootstrap.channel(NioServerSocketChannel.class);
            //设置handler
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //管道将 handler串联起来
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new EchoHandler());
                }
            });
            System.out.println("echo 启动中 ing .....");
            //设置端口
            ChannelFuture bind = serverBootstrap.bind(this.port);
            //等待服务端监听端口关闭
            bind.channel().closeFuture().sync();
        } finally {
            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }


    }
    public static void main(String[] args) throws InterruptedException {
        new EchoServer().run();
    }
}
