package com.yang.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 17:42
 * @Version 1.0
 * @qq: 1411091515
 */
public class BioTimeServer {


    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The Time server is start in port : " + port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new BioTimeServerHandler(socket)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(server != null){
                System.out.println(" The Time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server = null;
            }
        }
    }


}
