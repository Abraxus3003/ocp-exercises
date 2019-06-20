package info.krogulec.parallelstreams;

import java.util.ArrayList;
import java.util.List;

public class PerformanceImproovemnt {

    public int processRecord(int input){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
        }

        return input;
    }

    public static void main(String[] args) {
        PerformanceImproovemnt calc = new PerformanceImproovemnt();

        List<Integer> data = new ArrayList<>();

        for (int i = 0 ; i < 400 ; i++){
            data.add(i);
        }

        long start = System.currentTimeMillis();
        calc.processAllData(data);
        double time = (System.currentTimeMillis() - start)/1000.0;

        System.out.println("Task completed in millis: " + time);
    }

    private void processAllData(List<Integer> data) {
        //porównajmy wydajność w zależności od wykorzystania stream i parallel stream
        data.stream().map(a -> processRecord(a)).count();
    }
}
