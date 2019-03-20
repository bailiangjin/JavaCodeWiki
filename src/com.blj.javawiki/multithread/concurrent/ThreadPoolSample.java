package com.blj.javawiki.multithread.concurrent;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * 线程池示例
 *
 * @author bailiangjin
 * @date 2019/3/18
 */
public class ThreadPoolSample {


    public static void main(String[] args) {
//        ExecutorService executorService= Executors.newCachedThreadPool();

        int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        int KEEP_ALIVE_TIME = 1;
        TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<Runnable>();
        ExecutorService executorService = new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES * 2,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                taskQueue,
                new NamedThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                    }
                });

        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("测试线程池：" + Thread.currentThread().toString());
                }
            }).isDone();
        }

    }
}
