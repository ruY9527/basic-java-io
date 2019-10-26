package com.yang.io.fio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mu_Yi
 * @Date: 2019/10/26 18:07
 * @Version 1.0
 * @qq: 1411091515
 */
public class FioTimeServerHandlerExecutePool {

    private ExecutorService executor;

    public FioTimeServerHandlerExecutePool(int maxPoolSize,int queueSize){
        executor =  new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<java.lang.Runnable>(queueSize));

    }

    public void execute(Runnable task){
        executor.execute(task);
    }

}
