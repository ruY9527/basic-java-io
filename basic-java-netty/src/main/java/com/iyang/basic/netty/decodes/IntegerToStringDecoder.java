package com.iyang.basic.netty.decodes;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 16:00
 */
public class IntegerToStringDecoder extends MessageToMessageDecoder<Integer> {

    @Override
    protected void decode(ChannelHandlerContext ctx, Integer msg, List<Object> out) throws Exception {

        out.add(String.valueOf(msg));

    }

}
