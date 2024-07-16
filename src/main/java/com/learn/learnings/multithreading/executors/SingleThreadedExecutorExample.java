package com.learn.learnings.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.print("Hello");
            }
            System.out.println();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Long-running task completed");
        });

        // Main thread can continue doing other work
        System.out.println("Main thread is free to do other work");
        executor.shutdown();

    }
}
