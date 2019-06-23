package info.krogulec.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class RandomOperations {

    public static void main(String[] args) {
        Stream<String> s = Stream.of("meow", "growl", "speak", "bark");

        BinaryOperator<String> merge = (a,b) -> {
            System.out.println("a: " + a + "--- b: " + b);
            return a;
        };

        Map<Integer, String> map = s.collect(Collectors.toMap(String::length, k -> k, merge));

        System.out.println(map.size() + " " + map.toString());


        Deque<String> deque = new ArrayDeque<>();
        deque.push("msg");

        List<String> list = new LinkedList<>();
        list.add("msgList");
        list.add("druga");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);

        Stream<Collection<String>> stream = Stream.of(deque, list);

        stream.flatMap(x -> x.stream()).forEach(System.out::print);

        Stream<IntStream> is = Stream.of(IntStream.of(1, 2, 3), IntStream.of(1, 2, 3));

        LongStream longStream = LongStream.of(1, 2, 3, 4, 5);

        LongSummaryStatistics longSummaryStatistics = longStream.summaryStatistics();

        Stream<Integer> integerStream = Stream.of(12, 3, 4, 5, 7);

        IntSummaryStatistics collect = integerStream.collect(Collectors.summarizingInt(a -> a.intValue()));




    }
}
