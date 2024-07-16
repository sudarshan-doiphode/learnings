package com.learn.learnings.multithreading.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        ScheduledThreadPoolExecutorExample example = new ScheduledThreadPoolExecutorExample();
        example.startLogging();

        // Add shutdown hook to gracefully stop the scheduler
        Runtime.getRuntime().addShutdownHook(new Thread(example::shutdown));
    }

    public void startLogging() {
        scheduler.scheduleAtFixedRate(this::logMessage, 0, 5, TimeUnit.SECONDS);
    }

    private void logMessage() {
        System.out.println("Logging at regular intervals: " + LocalDateTime.now());
    }

    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }
}
