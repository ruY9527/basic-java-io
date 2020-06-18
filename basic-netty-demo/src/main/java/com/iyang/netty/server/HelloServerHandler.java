package com.iyang.netty.server;

import com.iyang.netty.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:24
 * @Version 1.0
 * @qq: 1411091515
 */
public class HelloServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // super.channelRead(ctx, msg);
        if(msg != null){
            String hello = new HelloServiceImpl().hello(msg.toString());
            ctx.writeAndFlush(hello);
        }

    }

}
