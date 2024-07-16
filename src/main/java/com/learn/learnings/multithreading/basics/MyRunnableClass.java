package com.learn.learnings.multithreading.basics;

public class MyRunnableClass implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}
