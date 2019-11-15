package com.yang.netty.basic.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
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
public class GavinClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        System.out.println(new Date() + "客户端读取到数据" + buffer.toString(Charset.forName("utf-8")));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" 客户端写入数据 : " + new Date());
        ByteBuf byteBuf = getByteBuf(ctx);
        ctx.channel().writeAndFlush(byteBuf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        byte [] bytes = "Hello ; Gavin".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }

}
