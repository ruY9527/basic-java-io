package com.yang.netty.basic.im.client;

import com.yang.netty.basic.protocol.Packet;
import com.yang.netty.basic.protocol.PacketCodeC;
import com.yang.netty.basic.protocol.request.LoginRequestPacket;
import com.yang.netty.basic.protocol.response.LoginResponsePacket;
import com.yang.netty.basic.protocol.response.MessageResponsePacket;
import com.yang.netty.basic.utils.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ImClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(new Date() + "客户端开始登陆");

        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("Gavin");
        loginRequestPacket.setPassword("lwf");

        // 编码
        ByteBuf byteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);

        // 写数据
        ctx.channel().writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if(packet instanceof LoginResponsePacket){

            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if(loginResponsePacket.isSuccess()){
                System.out.println(new Date() + "客户端登录成功");
                LoginUtil.markLogin(ctx.channel());
            } else {
                System.out.println(new Date() + "客户端登陆失败,原因" + loginResponsePacket.getReason());
            }

        } else if(packet instanceof MessageResponsePacket){
            MessageResponsePacket messageResponsePacket = (MessageResponsePacket) packet;
            System.out.println(new Date() + " : 收到服务端的消息: " + messageResponsePacket.getMessage());
        }

    }
}
