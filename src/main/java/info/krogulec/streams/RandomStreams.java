package info.krogulec.streams;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomStreams {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("1", "2", "3");

        System.out.println(stringStream.peek(System.out::print).count());

        Double collect = Stream.of("1", "2", "3", "4", "5").collect(Collectors.averagingInt(Integer::parseInt));
        System.out.println(collect);

        System.out.println("Distinct usuwa duplikaty ze strumienia");
        System.out.println(Stream.of(1,2,3,4,5,4,3,2,1).distinct().collect(Collectors.toList()));

        System.out.println("Negate odwraca wynik z predykatu");
        Predicate<String> p = a -> a.length() > 2;
        Stream.of("msg", "a", "blada").filter(p.negate()).forEach(System.out::print);

        System.out.println("");
        System.out.println("Peek i limit");

        Stream.of(20,21,3,4,5,6,7,8).filter(a -> a > 2).skip(2).limit(2).forEach(System.out::print);

        System.out.println("Collect: ");

        HashSet<Object> collect1 = Stream.of(1, 2, 3, 4, 5, 6).collect(HashSet::new, (a, b) -> {
            System.out.println("Accumulator a: " + a);
            System.out.println("Accumulator b: " + b);

            a.add(b);

        }, (a, b) -> {
            System.out.println("Combiner a: " + a);
            System.out.println("Combiner b: " + b);
        });
        System.out.println(collect1);


        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6).reduce(1, (a, b) -> {
            System.out.println("Accumulator a: " + a);
            System.out.println("Accumulator b: " + b);

            return a * 2;
        });

        System.out.println(reduce);

        System.out.println("Usuwanie duplikatów metodą distinct:");

        TreeSet<Object> collect2 = Stream.of(1, 2, 3, 4, 45, 6, 7, 4, 3, 2, 1).distinct().collect(TreeSet::new, TreeSet::add, (a, b) -> {
        });

        System.out.println(collect2);


        System.out.println("limit i skip: ");

        Set<Integer> collect3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).limit(4).collect(Collectors.toSet());
        System.out.println(collect3);

        Set<Integer> collect4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(4).collect(Collectors.toSet());
        System.out.println(collect4);

        Set<Integer> limit = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(2).limit(4).collect(Collectors.toSet());
        System.out.println(limit);

        Set<Integer> limit2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).limit(4).skip(2).collect(Collectors.toSet());
        System.out.println(limit2);


    }

}
