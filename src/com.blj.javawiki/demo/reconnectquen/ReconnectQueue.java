package com.blj.javawiki.demo.reconnectquen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReconnectQueue implements Runnable{
    private boolean isRun = true;
    private  BlockingQueue<ReconnectItem> blockingQueue = new LinkedBlockingQueue<>();

    public  void addItem(ReconnectItem item){
        blockingQueue.add(item);
    }

    public  boolean isEmpty(){
        return blockingQueue.isEmpty();
    }

    public void stop(){
        isRun=false;
    }
    @Override
    public void run() {
        isRun = true;
        while (isRun) {
            try {
                if (!isRun) {
                    continue;
                }
               ReconnectItem reconnectItem = blockingQueue.take();
                if(null!=reconnectItem){
                    System.out.println("orgRequestTime="+reconnectItem.getOrgRequestTime()+" Time out="+reconnectItem.getTimeout());
                    // TODO: 2017/8/2 判断是否连接 进行重连
                    //sleep 2 秒
                    Thread.sleep(reconnectItem.getTimeout());
                }else {
                    System.out.println("queue is empty");
                }
                if (!isRun) {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("stop");
        isRun = false;
    }



    public static void main(String[] args) {

       final ReconnectQueue  reconnectQueue =new ReconnectQueue();

        Thread thread1= new Thread(new Runnable() {
            @Override
            public void run() {
                int number=1;
                while (number<5){
                    System.out.println("add item Thread1：number："+number++);
                    reconnectQueue.addItem(new ReconnectItem(System.currentTimeMillis(),1000));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        });

        Thread thread2= new Thread(new Runnable() {
            @Override
            public void run() {

                int number=1;
                while (number<5){
                    if(3==number){
                        reconnectQueue.stop();
                    }
                    System.out.println("add item Thread2：number："+number++);
                    reconnectQueue.addItem(new ReconnectItem(System.currentTimeMillis(),1000));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(8*1000);
                    reconnectQueue.addItem(new ReconnectItem(System.currentTimeMillis(),1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        Thread thread3= new Thread(reconnectQueue);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
