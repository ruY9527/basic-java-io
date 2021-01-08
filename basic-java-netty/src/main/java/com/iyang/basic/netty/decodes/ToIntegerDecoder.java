package com.iyang.basic.netty.decodes;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 15:57
 */
public class ToIntegerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() >= 4){
            out.add(in.readInt());
        }

    }

}
