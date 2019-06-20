package info.krogulec.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Klasa pokazuje jak używać bramek
 */
public class ShowCyclicBarrier {
    private void removeLion(){
        System.out.println("Removing lion...");
    }

    private void addLion(){
        System.out.println("Adding lion...");
    }

    private void cleanPen(){
        System.out.println("Cleaning...");
    }

    public void performComplexTask(CyclicBarrier c1, CyclicBarrier c2){

        try {
            removeLion();
            c1.await();
            cleanPen();
            c2.await();
            addLion();
        } catch (InterruptedException e) {
            //do sth
        } catch (BrokenBarrierException e) {
            //do sth
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = null;

        try{
            executorService = Executors.newFixedThreadPool(4);
            ShowCyclicBarrier manager = new ShowCyclicBarrier();
            CyclicBarrier c1 = new CyclicBarrier(4); //limit musi być mniejszy lub równy liczbie wątków - w przeciwnym wypadku bariera nie zostanie osiągnieta i program się nie skończy
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("Pen cleaned without victims"));
            for (int i = 0 ; i<4; i++){
                executorService.submit(() -> {
                    manager.performComplexTask(c1, c2);
                });
            }
        } finally {
            if(executorService != null){
                executorService.shutdown();
            }
        }
    }
}

/**
 * Bez zastosowania dodatkowej synchronizacji wyniki sa nieprzewidywalne
 */
class NoCyclicBarrier{

    private void removeLion(){
        System.out.println("Removing lion...");
    }

    private void addLion(){
        System.out.println("Adding lion...");
    }

    private void cleanPen(){
        System.out.println("Cleaning...");
    }

    public void performComplexTask(){
        removeLion();
        cleanPen();
        addLion();
    }

    public static void main(String[] args) {
        ExecutorService executorService = null;

        try{
            executorService = Executors.newFixedThreadPool(4);
            NoCyclicBarrier manager = new NoCyclicBarrier();
            for (int i = 0 ; i<4; i++){
                executorService.submit(()-> manager.performComplexTask());
            }
        } finally {
            if(executorService != null){
                executorService.shutdown();
            }
        }
    }
}
