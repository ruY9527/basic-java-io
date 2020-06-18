package com.iyang.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:19
 * @Version 1.0
 * @qq: 1411091515
 */
public class StartNettyServer {


    private void startServer(String hostName,int port){

        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        bootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
                 .childHandler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(SocketChannel socketChannel) throws Exception {

                         ChannelPipeline pipeline = socketChannel.pipeline();
                         pipeline.addLast(new StringDecoder());
                         pipeline.addLast(new StringEncoder());
                         pipeline.addLast(new HelloServerHandler());

                     }
                 });
    }

}
