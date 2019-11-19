package com.yang.netty.basic.im.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ImNettyServer {

    private static final int PORT = 8989;

    public static void main(String[] args) {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024).childOption(ChannelOption.SO_KEEPALIVE,true)
                .childOption(ChannelOption.TCP_NODELAY,true).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast(new ImServerHandler());
            }
        });

        bind(serverBootstrap,PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap,final int port){
        serverBootstrap.bind(port).addListener(future -> {
            System.out.println(new Date() + "端口port[" + port + (future.isSuccess()?"]绑定成功":"]绑定失败"));
        });
    }

}
