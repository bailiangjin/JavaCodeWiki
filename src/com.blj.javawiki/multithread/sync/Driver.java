package com.blj.javawiki.multithread.sync;

import java.util.concurrent.CountDownLatch;

public  class Driver { // ...

    public static final int count=10;

    public static void main(String[] args)throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(count);

        for (int i = 0; i < count; ++i) {
            // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        doSomethingElse();            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doSomethingElse();
        doneSignal.await();           // wait for all to finish
    }

    private  static void doSomethingElse() {
        System.out.println("do something else");
    }
}

