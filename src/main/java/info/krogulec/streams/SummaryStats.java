package info.krogulec.streams;

import java.util.LongSummaryStatistics;
import java.util.stream.LongStream;

public class SummaryStats {

    public static void main(String[] args) {

        LongSummaryStatistics longSummaryStatistics = LongStream.of(1, 2, 3, 4, 5).summaryStatistics();
        double average = longSummaryStatistics.getAverage();
        System.out.println(average);

        long asLong = LongStream.of(1, 2, 3, 4, 5).max().getAsLong();
        System.out.println(asLong);
    }
}
