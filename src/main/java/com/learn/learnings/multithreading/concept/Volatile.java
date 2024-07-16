package com.learn.learnings.multithreading.concept;

public class Volatile {
    public volatile static boolean flag = false;

    public static void setFlag(boolean flag) {
            Volatile.flag = flag;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                setFlag(true);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                setFlag(false);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                setFlag(true);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(isFlag());
    }
}
