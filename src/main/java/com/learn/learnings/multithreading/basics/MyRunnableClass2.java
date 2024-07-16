package com.learn.learnings.multithreading.basics;

public class MyRunnableClass2 implements Runnable{
    @Override
    public void run() {
        for (int i = 5; i < 10; i++) {
            System.out.println(i);
        }
    }
}
