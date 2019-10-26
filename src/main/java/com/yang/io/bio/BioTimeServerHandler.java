package com.yang.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 17:42
 * @Version 1.0
 * @qq: 1411091515
 */
public class BioTimeServerHandler implements Runnable {

    private Socket socket;

    public BioTimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String curremtTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if(body == null){ break; }
                System.out.println("The Bio tim server receive order : " + body);
                curremtTime = "Query Time Order".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"Bad order";
                out.println(curremtTime);
            }
        }catch (Exception e){
            e.printStackTrace();
            if(in != null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if(out != null){
                out.close();
                out = null;
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket = null;
            }
        }


    }
}
