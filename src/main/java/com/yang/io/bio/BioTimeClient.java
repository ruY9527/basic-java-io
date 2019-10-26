package com.yang.io.bio;

import java.io.*;
import java.net.Socket;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 17:49
 * @Version 1.0
 * @qq: 1411091515
 */
public class BioTimeClient {

    public static void main(String[] args) {

        int port = 8080;
        if(args != null && args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("Query Time Order");
            System.out.println("Send order 2 server succeed.");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(out != null){
                out.close();
                out = null;
            }

            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }

    }

}
