package info.krogulec.parallelstreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static info.krogulec.Utils.breakingParts;

public class OperationsOnParallelStreams {
    public static void main(String[] args) {
        ordering();
        avoidingSideEffects();
        reduction();
        sorting();
    }

    private static void sorting() {
        breakingParts("Sortowanie paraller stramów jest nieprzewidywalne");

        Stream.of("msg", "bag", "pag", "rag").parallel().sorted().forEach(System.out::println);

        System.out.println("Dla porównania sequential stream sortuje bez problemu");

        Stream.of("msg", "bag", "pag", "rag").sequential().sorted().forEach(System.out::println);
    }

    private static void reduction() {
        breakingParts("Redukcja - ważne jest przestrzeganie zasad przy konstruowaniu");

        int reduce = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel()
                .reduce(0, (x, y) -> x + y);
        System.out.println("Suma od 1 do 9: " + reduce);

        breakingParts("");

        //TODO redukcja dla mnożenia

        int reducMinus = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel()
                .reduce(0, (x, y) -> x - y); //accumulator nie jest asjocjacyjny
        System.out.println("Odejmowanie od 1 do 9 - wynik nieprzewidywalny i błędny: " + reducMinus);

        String reduce1 = Stream.of("A", "B", "C", "D")
                .parallel()
                .reduce("", String::concat, (s1, s2) -> s1 + s2);
        System.out.println("Dodanie liter od A do D: " + reduce1);

        String reduce2 = Stream.of("A", "B", "C", "D")
                .parallel()
                .reduce("Z", String::concat, (s1, s2) -> s1 + s2);
        System.out.println("Dodanie liter od A do D ze złym identity Z: " + reduce2);
    }

    private static void avoidingSideEffects() {
        breakingParts("Unikamy wpływu na to jest poza strumieniem - efekty uboczne - dodatkowo brak synchronizacji kolekcji może powodować dodatkowe nieprzewidziane wyniki");

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i< 10; i++){
            IntStream.of(1,2,3,4,5,6,7,8,9).parallel()
                    .forEach(list::add);
            list.forEach(a -> System.out.print(a + " "));
            System.out.println("\n");
            list.clear();
        }
    }

    private static void ordering() {
        breakingParts("Kolejność operacji jest nieprzewidywalna");

        IntStream.of(1,2,3,4,5,6,7,8,9).parallel()
                .forEach(a -> System.out.print(a + " "));

        breakingParts("Można dać sortowanie, ale kosztem wydajności");

        IntStream.of(1,2,3,4,5,6,7,8,9).parallel()
                .forEachOrdered(a -> System.out.print(a + " "));

    }


}
