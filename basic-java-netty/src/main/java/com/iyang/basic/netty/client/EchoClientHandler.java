package com.iyang.basic.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 14:39
 */

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    /**
     * logger info.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EchoClientHandler.class);

    /**
     * 读取数据
     * @param channelHandlerContext
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("EchoClientHandler: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    /**
     * 当被通知 active 的时候, 就使用 ctx 来发送消息.
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        /*super.channelInactive(ctx);*/

        ByteBuf byteBuf = Unpooled.copiedBuffer("This is GavinYang", CharsetUtil.UTF_8);
        ctx.writeAndFlush(byteBuf);
    }

    /**
     * 建立连接后,该方法是会被调用到的.
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ByteBuf byteBuf = Unpooled.copiedBuffer("This is GavinYang", CharsetUtil.UTF_8);
        String name = byteBuf.getClass().getName();

        LOGGER.info(" The EchoClientHandler#channelActive , the byteBuf className is ---> {}" , name);

        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        /*super.exceptionCaught(ctx, cause);*/
        cause.printStackTrace();
        ctx.close();
    }
}
