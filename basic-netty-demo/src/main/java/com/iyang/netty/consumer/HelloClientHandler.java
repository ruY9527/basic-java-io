package com.iyang.netty.consumer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:30
 * @Version 1.0
 * @qq: 1411091515
 */
public class HelloClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private String result;
    private String para;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // super.channelActive(ctx);
        context = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // super.channelRead(ctx, msg);
        result = msg.toString();
        notify();
    }

    @Override
    public  Object call() throws Exception {
        lock.lock();
        try {
            context.writeAndFlush(para);
            wait();
        } finally {
            lock.unlock();
        }
        return result;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
