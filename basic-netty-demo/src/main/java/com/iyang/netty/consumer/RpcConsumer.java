package com.iyang.netty.consumer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:29
 * @Version 1.0
 * @qq: 1411091515
 */
public class RpcConsumer {

    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static HelloClientHandler client;

    public Object createProxy(final Class<?> serviceClass,final String providerName){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class<?>[]{serviceClass},
                (proxy,method,args) -> {
                    if(client == null){
                        // 初始化
                        initClient();
                    }
                    client.setPara(providerName + args[0]);
                    return executor.submit(client).get();
                });
    }


    private static void initClient(){
        client = new HelloClientHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(client);
                    }
                });

        try {
            b.connect("localhost",8088).sync();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
