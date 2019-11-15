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
public class GavinServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + " 服务端读取到的数据 ---> " + byteBuf.toString(Charset.forName("utf-8")));
        // 回复客户端
        System.out.println(new Date() + " 服务端写入数据");
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx){
        byte [] bytes = "我是Gavin".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }

}
