package info.krogulec.parallelstreams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Różnica w wykorzystaniu klas atomic i standardowej inkrementacji
 */
public class Incrementing {

    long ticketSold;
    final AtomicInteger ticketTaken;

    public Incrementing() {
        ticketSold = 0;
        this.ticketTaken = new AtomicInteger(0);
    }

    public void performJob(){
        IntStream.iterate(1, a -> a+1)
                .parallel()
                .limit(10)
                .forEach(i -> ticketTaken.getAndIncrement());
        IntStream.iterate(1, a -> a+1)
                .limit(10)
                .parallel()
                .forEach(i -> ++ticketSold);

        System.out.println(ticketTaken + " " + ticketSold);
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 100; i++){
            new Incrementing().performJob();
        }
    }
}
