package com.iyang.netty.consumer;

import com.iyang.netty.pinterface.HelloService;

/**
 * @Author: Mu_Yi
 * @Date: 2020/6/19 0:45
 * @Version 1.0
 * @qq: 1411091515
 */
public class ClientBootstrap {

    private static final String providerName = "HelloService#GavinYang";

    public static void main(String[] args) {

        RpcConsumer consumer = new RpcConsumer();
        HelloService service = (HelloService) consumer.createProxy(HelloService.class,providerName);
        while (true){
            try {
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println(service.hello("are you ok ?"));
        }

    }

}
