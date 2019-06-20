package info.krogulec.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinRecursiveAction {

    public static void main(String[] args) {
        Double [] weights = new Double[10];

        ForkJoinTask<?> forkJoinTask = new WeightAnimalsAction(weights, 0, weights.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(forkJoinTask);

    }

    public static class WeightAnimalsAction extends RecursiveAction {

        private int start;
        private int end;
        private Double [] weights;

        //Zazwyczaj przekazuje się parametry w konstruktorze bo compute nic nie przyjmuje
        public WeightAnimalsAction(Double [] weights, int start, int end){
            this.weights = weights;
            this.start = start;
            this.end = end;
        }


        @Override
        protected void compute() {
            //przypadek bazowy
            if (end - start <= 3){
                for(int i = start ; i< end ; i++){
                    weights[i] = ((double) new Random().nextInt(100));
                    System.out.println("Animal weight: " + i + " Weight: " + weights[i]);
                }
            } else {
                //rozdzielamy na pół i wywołujemy akcje dla każdej z połówek
                int middle = start + ((end - start)/2);
                System.out.println("start: " + start + " middle: " + middle + " end: " + end);
                invokeAll(new WeightAnimalsAction(weights, start, middle), new WeightAnimalsAction(weights, middle, end));
            }
        }
    }
}
