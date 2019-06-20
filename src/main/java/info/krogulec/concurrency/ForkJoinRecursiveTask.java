package info.krogulec.concurrency;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTask {

    public static void main(String[] args) {

        double [] weights = new double[20];

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Double> weightAnimalsTask = new ForkJoinRecursiveTask().new WeightAnimals(0, weights.length, weights);
        double sum = pool.invoke(weightAnimalsTask);

        System.out.println(sum);
    }

    public class WeightAnimals extends RecursiveTask<Double>{

        private final int start;
        private final int end;
        private final double [] weights;

        private static final int BASE_CASE_MAX = 3;

        public WeightAnimals(int start, int end, double[] weights) {
            this.start = start;
            this.end = end;
            this.weights = weights;
        }

        @Override
        public Double compute() {

            double sum = 0;


            if (end - start < BASE_CASE_MAX){
                for (int i = start; i < end; i++){
                    weights[i] = new Random().nextInt(200);
                    sum += weights[i];
                }

                return sum;
            } else {
                int middle = start + (end -start)/2;
                RecursiveTask<Double> otherTask = new WeightAnimals(start, middle, weights);
                otherTask.fork();

                return new WeightAnimals(middle, end, weights).compute() + otherTask.join();
            }
        }
    }
}
