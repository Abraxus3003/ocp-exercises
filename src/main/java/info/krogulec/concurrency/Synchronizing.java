package info.krogulec.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Synchronizing {
    public static void main(String[] args) throws InterruptedException {
        Swimmer swimmer = new Swimmer();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i< 100; i++){
            Thread.sleep(10);
            executorService.execute(swimmer::swimm);
            Thread.sleep(40);
        }

        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println(swimmer.laps);
    }
}

class Swimmer{
    int laps = 0;

    public synchronized void swimm(){
        laps++;
    }
}
