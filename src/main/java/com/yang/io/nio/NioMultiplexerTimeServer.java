package com.yang.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 18:18
 * @Version 1.0
 * @qq: 1411091515
 */
public class NioMultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    // 创建多路复用Selector,ServerSocketChannel
    public NioMultiplexerTimeServer(int port){
        try{
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port " + port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {

        while (!stop){

            try{
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();
                    try{
                        handlerInput(key);
                    } catch (Exception e){
                        e.printStackTrace();
                        if(key != null){
                            key.channel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }

                }
            } catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public void handlerInput(SelectionKey key) throws Exception{

        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
            }

            if(key.isReadable()){

                // SocketChannel 设置为非异步阻塞
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(byteBuffer);
                if(readBytes > 0){
                    byteBuffer.flip();
                    byte [] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "Query Time Order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():
                            "Bad Order";
                    doWrite(sc,currentTime);
                } else if(readBytes < 0){
                    key.channel();
                    sc.close();
                } else {
                    // 读取到 0 字节

                }
            }
        }

    }


    public void doWrite(SocketChannel channel,String response) throws IOException {
        if(response != null && response.trim().length() > 0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

}
