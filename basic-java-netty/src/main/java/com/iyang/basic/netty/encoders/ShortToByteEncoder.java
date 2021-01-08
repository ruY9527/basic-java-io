package com.iyang.basic.netty.encoders;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 16:04
 */

public class ShortToByteEncoder extends MessageToByteEncoder<Short> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Short msg, ByteBuf out) throws Exception {

        out.writeShort(msg);

    }

}
