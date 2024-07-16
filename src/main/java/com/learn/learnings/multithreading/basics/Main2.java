package com.learn.learnings.multithreading.basics;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableClass());
        Thread thread2 = new Thread(new MyRunnableClass2());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Execution Completed!!");
    }
}
