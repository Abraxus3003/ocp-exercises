package info.krogulec.collections;

import java.io.File;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConcurrentCollections {

    public static void main(String[] args) {



        IntStream.of(1,3,2,1,2,3).distinct().forEach(System.out::println);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);


        Integer integer = map.computeIfPresent(2, (k, v) -> null);

        System.out.println(integer  );

        System.out.println(map);

        StringBuilder sb = new StringBuilder();

        UnaryOperator<Integer> unaryOperator = UnaryOperator.identity();

        Integer apply = unaryOperator.apply(123);



    }


    static void doSth(BiConsumer<Integer, Integer> bi){}

}

enum Currency{
    DOLLAR, EURO
}
