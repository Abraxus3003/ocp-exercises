package info.krogulec.streams;

import info.krogulec.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

    private static final List<Integer> INTS = new ArrayList<>();
    private static final List<Integer> INTS2 = new ArrayList<>();


    static {
        INTS.add(1);
        INTS.add(2);
        INTS.add(4);
        INTS.add(8);
        INTS.add(12);
        INTS.add(1);
        INTS.add(5);
        INTS.add(3);
        INTS.add(9);

        INTS2.add(1000);
        INTS2.add(2000);
        INTS2.add(3000);
    }

    public static void main(String[] args) {

        Utils.breakingParts("filteringData");

        filteringData();

        Utils.breakingParts("removingDuplicated");

        removingDuplicated();

        Utils.breakingParts("limitingResults");

        limitingResults();

        Utils.breakingParts("skipingElements");

        skipingElements();

        Utils.breakingParts("mappingElements");

        mappingElements();

        Utils.breakingParts("flattingElements");

        flattingElements();

        Utils.breakingParts("sortingElements");

        sortingElements();

        Utils.breakingParts("peekingElements");

        peekingElements();
    }

    private static void filteringData() {
        List<Integer> collect = INTS.stream()
                .filter(i -> i < 8)
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void removingDuplicated() {

        List<Integer> collect = INTS.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void limitingResults() {

        List<Integer> collect = INTS.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void skipingElements() {

        List<Integer> collect = INTS.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void mappingElements() {

        List<String> collect = INTS.stream()
                .map(i -> "To jest element: " + i)
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void flattingElements() {

        List<Integer> collect = Stream.of(INTS, INTS2)
                .flatMap(e -> e.stream())
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void sortingElements() {

        List<Integer> collect = INTS.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }

    private static void peekingElements() {

        //zgodnie z dobrą praktyką peek nie powinno mieć skutków ubocznych
        List<Integer> collect = INTS.stream()
                .peek(i -> System.out.println(i))
                .collect(Collectors.toList());

        System.out.println(collect);

        //TODO To samo dla nieskończonego strumienia

    }
}
