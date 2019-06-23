package info.krogulec.streams;

import info.krogulec.Utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    private static final String [] starks = {"John", "Robb", "Arya", "Bran", "Sansa"};

    public static void main(String[] args) {

        Utils.breakingParts("collectingData");

        collectingData();

        Utils.breakingParts("reducing");

        reducing();

        Utils.breakingParts("iteratingWithForeach");

        iteratingWithForeach();

        Utils.breakingParts("predicateMatching");

        predicateMatching();

        Utils.breakingParts("findingAnyOrFirst");

        findingAnyOrFirst();

        Utils.breakingParts("countingElements");

        countingElements();

        Utils.breakingParts("findingMinimumAndMax");

        findingMinimumAndMax();
    }

    private static void collectingData() {

        List<String> collectingToList = Stream.of(starks)
                .collect(Collectors.toList());

        //TODO Strumień nieskończony

    }

    private static void reducing() {
        //TODO Strumień nieskończony
    }

    private static void iteratingWithForeach() {
        Stream.of(starks)
                .forEach(stark -> System.out.println(stark));

        //TODO Strumień nieskończony

    }

    private static void predicateMatching() {
        //strumień skończony
        boolean startsWithJ = Stream.of(starks)
                .anyMatch(stark -> stark.startsWith("J"));

        //TODO Strumień nieskończony
    }

    private static void findingAnyOrFirst() {

        Optional<String> first = Stream.of(starks)
                .findFirst();

        //TODO Strumień nieskończony
    }

    private static void countingElements() {

        long countStarks = Stream.of(starks)
                .count();

        //TODO Strumień nieskończony

    }

    private static void findingMinimumAndMax() {

        //w strumieniu obiektów musimy podać przy max min comparator
        Optional<String> min = Stream.of(starks)
                .min((s1, s2) -> s1.compareTo(s2));

        System.out.println(min.orElse("nie mogę znaleźć minimum"));

        //TODO Strumień nieskończony

    }
}
