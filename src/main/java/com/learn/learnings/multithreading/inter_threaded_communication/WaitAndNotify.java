package com.learn.learnings.multithreading.inter_threaded_communication;

public class WaitAndNotify {

    //If you have single intrinsic lock then you should use wait and notify
    //wait release lock and thread2 can acquire lock and release back once task executed

    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("In Producer method!!!");
            wait();
            System.out.println("Again in Producer");
        }
    }

    public void consume(){
        synchronized (this){
            System.out.println("In Consumer !!!");
            notify();
        }
    }

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitAndNotify.consume();
            }
        });

        t1.start();
        t2.start();

    }
}
