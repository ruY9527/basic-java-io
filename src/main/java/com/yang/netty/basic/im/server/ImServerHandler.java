package com.yang.netty.basic.im.server;

import com.yang.netty.basic.protocol.Packet;
import com.yang.netty.basic.protocol.PacketCodeC;
import com.yang.netty.basic.protocol.request.LoginRequestPacket;
import com.yang.netty.basic.protocol.request.MessageRequestPacket;
import com.yang.netty.basic.protocol.response.LoginResponsePacket;
import com.yang.netty.basic.protocol.response.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

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

@Slf4j
public class ImServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf byteBuf =  (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);

        if(packet instanceof LoginRequestPacket){

            System.out.println(new Date() + " : 收到客户端请求");
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());

            if(valid(loginRequestPacket)){
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + "登录成功");
            } else {
                loginResponsePacket.setReason("账号密码失败");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + "  :登录失败");
            }

            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc(),loginResponsePacket);
            ctx.channel().writeAndFlush(responseByteBuf);
        } else if(packet instanceof MessageRequestPacket){
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);

            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            System.out.println(new Date() + " :收到客户端的消息" + messageRequestPacket.getMessage());
            messageResponsePacket.setMessage("客户端回复 : [" + messageRequestPacket.getMessage() + "]");
            ByteBuf encode = PacketCodeC.INSTANCE.encode(ctx.alloc(), messageResponsePacket);
            ctx.channel().writeAndFlush(encode);
        }
    }

    private boolean valid(LoginRequestPacket loginRequestPacket){
        return true;
    }
}
