package com.yang.io.nio;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 18:17
 * @Version 1.0
 * @qq: 1411091515
 */
public class NioTimeServer {


    public static void main(String[] args) {

        int port = 8080;

        if(args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }

        NioMultiplexerTimeServer nioMultiplexerTimeServer = new NioMultiplexerTimeServer(port);
        new Thread(nioMultiplexerTimeServer,"NioMultiplexerTimeServer --001").start();
    }


}
