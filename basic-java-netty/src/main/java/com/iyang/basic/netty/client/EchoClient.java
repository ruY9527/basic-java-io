package com.iyang.basic.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 14:43
 */
public class EchoClient {

    final String host = "127.0.0.1";
    final int port = 8899;


    public static void main(String[] args) throws InterruptedException {

        new EchoClient().start();

    }

    /**
     * InetSocketAddress 为了连接上服务器的.
     * Bootstrap 创建来初始化客户端.
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap serverBootstrap = new Bootstrap();
            serverBootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                           .remoteAddress(new InetSocketAddress(host,port))
                           .handler(new ChannelInitializer<SocketChannel>() {
                               @Override
                               protected void initChannel(SocketChannel socketChannel) throws Exception {
                                   socketChannel.pipeline().addLast(new EchoClientHandler());
                               }
                           });
            ChannelFuture sync = serverBootstrap.connect().sync();
            sync.channel().closeFuture().sync();

        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

}
