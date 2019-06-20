package info.krogulec.concurrency;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicePractice {

    public static void main(String[] args) throws InterruptedException {
        standardExecutorCall();
        tryingToSubmitAfterShutdown();
        tryToShutdownNow();
        submittingTaskToExecutor();

    }

    //wykorzystanie metody submit
    private static void submittingTaskToExecutor() {

        ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(15);
            Future<?> msg = executorService.submit(() -> System.out.println("submitting printing to console"));

            Future<Integer> r = executorService.submit(() -> {
                int res = 0;
                for (int i = 0; i < 100; i++) {
                    res += i;
                    System.out.println("Summing numbers thread: " + Thread.currentThread());
                }


                return res;
            });

            while (!r.isDone()){
                System.out.println("task is not completed");
                continue;
            }

            System.out.println("Suma liczba od 1 do 100 to: " + r.get(1000, TimeUnit.SECONDS) + ". Raportował wątek: " + Thread.currentThread());

            System.out.println("lala");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null){
                executorService.shutdown();
            }
        }
    }

    //Nie można próbować dodać zadania do egzekutora po wywołaniu jego zamknięcia
    private static void tryToShutdownNow() throws InterruptedException {
        ExecutorService executorService = null;

        executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> System.out.println("Wykonanie zadania"));
        executorService.execute(ExecutorServicePractice::longerRunningTask);

        executorService.execute(() -> System.out.println("Wykonanie zadania numer 3"));

        //shutdownNow zamyka od razu bieżące zadania i zwraca listę tych, które nie zostały jeszcze ueuchomione
        List<Runnable> runnables = executorService.shutdownNow();

        Thread.sleep(1000);

        System.out.println("Nie wykonano zadań: " + runnables.size());

        for (Runnable r : runnables) {
            System.out.println(r);
        }
    }

    private static void longerRunningTask() {
        try {
            Thread.sleep(1000);
            System.out.println("Wątek: " + Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Nie można próbować dodać zadania do egzekutora po wywołaniu jego zamknięcia
    private static void tryingToSubmitAfterShutdown() {
        ExecutorService executorService = null;

        executorService = Executors.newFixedThreadPool(5);

        executorService.execute(() -> System.out.println("Wykonanie zadania"));
        executorService.execute(ExecutorServicePractice::longerRunningTask);

        executorService.shutdown();

        try {
            executorService.execute(() -> System.out.println("Zadanie po próbie zamknięcia"));
        } catch (Exception e){
            System.out.println("Próba dodania zadania do egzekutora po wywołaniu zamknięcia");
            e.printStackTrace();
        }
    }

    private static void standardExecutorCall() {
        ExecutorService executorService = null;

        try {
            executorService = Executors.newFixedThreadPool(3);

            System.out.println("standardExecutorCall begin");
            executorService.execute(ExecutorServicePractice::longerRunningTask);

            executorService.execute(() -> System.out.println("Wątek: " + Thread.currentThread()));
            executorService.execute(() -> System.out.println("Inny wątek: " + Thread.currentThread()));

            System.out.println("standardExecutorCall end");


            //Trzeba pamiętać, żeby na końcu zamykać serwis
        } finally {
            if(executorService != null){
                executorService.shutdown();
            }
        }
    }


}
