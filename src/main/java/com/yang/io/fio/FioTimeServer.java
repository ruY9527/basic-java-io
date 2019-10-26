package com.yang.io.fio;

import com.yang.io.bio.BioTimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 17:42
 * @Version 1.0
 * @qq: 1411091515
 */
public class FioTimeServer {


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
            FioTimeServerHandlerExecutePool singleExecutor = new FioTimeServerHandlerExecutePool(50,10000);
            while (true){
                socket = server.accept();
                // new Thread(new FioTimeServerHandler(socket)).start();
                singleExecutor.execute(new FioTimeServerHandler(socket));
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
