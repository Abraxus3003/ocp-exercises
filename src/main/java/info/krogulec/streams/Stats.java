package info.krogulec.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class Stats {

    private static final Integer [] INTS = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        IntSummaryStatistics intSummaryStatistics = Stream.of(INTS)
                .mapToInt(i -> i)
                .summaryStatistics();

        System.out.println(intSummaryStatistics);


    }
}
