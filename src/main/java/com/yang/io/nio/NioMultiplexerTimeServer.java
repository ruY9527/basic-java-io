package com.yang.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

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

    }

    public void handlerInput(SelectionKey key) throws Exception{

        if(key.isValid()){
            if(key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector,SelectionKey.OP_READ);
                if(key.isReadable()){

                }
            }
        }

    }

}
