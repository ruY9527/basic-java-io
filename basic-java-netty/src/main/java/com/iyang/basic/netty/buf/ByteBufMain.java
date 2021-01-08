package com.iyang.basic.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author Yang
 * 当前服务 : basic-java-netty
 * @date 2021/1/8 / 15:35
 */
public class ByteBufMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ByteBufMain.class);

    public static void main(String[] args) {

        Charset charset = Charset.forName("UTF-8");
        ByteBuf byteBuf = Unpooled.copiedBuffer("This is GavinYang", charset);

        ByteBuf slice = byteBuf.slice(0, 7);
        LOGGER.info("After byteBuf.slice(0, 7) , the value is ---> {} " , slice.toString(charset));

        // 数据共享 ?
        byteBuf.setByte(0,'Q');
        LOGGER.info("After byteBuf.slice(0, 7) , the value is ---> {} " , slice.toString(charset));
        assert byteBuf.getByte(0) == slice.getByte(0);

        ByteBuf copyByteBuf = byteBuf.copy(0, 7);
        LOGGER.info(" The copyByteBuf value is ---> {}" , copyByteBuf.toString(charset));

        /*ByteBufUtil*/
    }

}
