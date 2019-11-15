package com.yang.netty.basic.bytebuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.SocketChannel;

import java.util.concurrent.TimeUnit;
import java.util.Date;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-15
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class GavinClient {

    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9898;

    public static void main(String[] args) {
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup).channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new GavinClientHandler());
                    }
                });
        connect(bootstrap,HOST,PORT,MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap,String host,int port,int retry){
        bootstrap.connect(host,port).addListener(future -> {
            if(future.isSuccess()){
                System.out.println("连接成功!");
            } else if(retry == 0){
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                int order = (MAX_RETRY - retry) + 1;
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(()->connect(bootstrap, host, port, retry-1),delay, TimeUnit.SECONDS);
            }
        });

    }

}
