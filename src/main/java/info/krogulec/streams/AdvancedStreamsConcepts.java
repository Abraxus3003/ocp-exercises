package info.krogulec.streams;

import info.krogulec.Utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamsConcepts {

    private static final String [] STARKS = {"John", "Robb", "Arya", "Bran", "Sansa"};

    public static void main(String[] args) {

        Utils.breakingParts("groupingElements");

        groupingElements();

        Utils.breakingParts("partitioningElements");

        partitioningElements();

        Utils.breakingParts("joiningElements");

        joiningElements();
    }

    private static void joiningElements() {
        String collect = Stream.of(STARKS)
                .collect(Collectors.joining(","));

        System.out.println(collect);
    }

    private static void partitioningElements() {

        Map<Boolean, List<String>> females = Stream.of(STARKS)
                .collect(Collectors.partitioningBy(s -> s.endsWith("a")));

        System.out.println(females);

    }

    private static void groupingElements() {
        Map<Integer, List<String>> collect = Stream.of(STARKS)
                .collect(Collectors.groupingBy(a -> a.length()));

        System.out.println(collect);
    }
}
