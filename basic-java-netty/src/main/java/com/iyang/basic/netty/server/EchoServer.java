package com.iyang.basic.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 14:34
 */
public class EchoServer {

    public static void main(String[] args)  throws InterruptedException {

        new EchoServer().start();

    }

    /**
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group).channel(NioServerSocketChannel.class)
                           .localAddress(new InetSocketAddress(8899))
                           .childHandler(new ChannelInitializer() {
                               @Override
                               protected void initChannel(Channel channel) throws Exception {
                                    channel.pipeline().addLast(new EchoServerHandler());
                               }
                           });
            ChannelFuture sync = serverBootstrap.bind().sync();
            System.out.println(EchoServer.class.getName() + " Started and listen on  " + sync.channel().localAddress());
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

}
