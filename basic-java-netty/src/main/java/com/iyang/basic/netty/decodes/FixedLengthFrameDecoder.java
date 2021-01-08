package com.iyang.basic.netty.decodes;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 16:20
 */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {

    private final int frameLength;

    public FixedLengthFrameDecoder(int frameLength) {
        if(frameLength < 0){
            throw new IllegalArgumentException("frameLength must be a positive integer: " + frameLength);
        }
        this.frameLength = frameLength;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() >= frameLength){
            ByteBuf byteBuf = in.readBytes(frameLength);
            out.add(byteBuf);
        }

    }
}
