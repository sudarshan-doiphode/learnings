package com.learn.learnings.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    static void processData(List<Integer> list) {
        list.stream().filter(i -> i % 5 == 0).forEach(System.out::println);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }


        int chunk = list.size()/5;
        

        // Shutdown the executor gracefully
        executor.shutdown();
    }
}
