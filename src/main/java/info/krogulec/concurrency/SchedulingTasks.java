package info.krogulec.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulingTasks {

    public static void main(String[] args) {
        scheduleAtFixedRate();
    }

    private static void scheduleAtFixedRate() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("I'm runnable scheduled at fixed rate: " + LocalDateTime.now()),0L, 100L, TimeUnit.MILLISECONDS);

        scheduledExecutorService.schedule(() -> System.out.println("I'm scheduled runnable"), 1000L, TimeUnit.MILLISECONDS);

        scheduledExecutorService.schedule(() -> "I'm sheduled callable", 100L, TimeUnit.MILLISECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("I'm runnable scheduled with fixed delay"), 2000L, 500L, TimeUnit.MILLISECONDS);
    }
}
