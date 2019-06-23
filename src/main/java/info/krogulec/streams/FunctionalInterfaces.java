package info.krogulec.streams;

import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        dealingWithPredicate();

        dealingWithUnaryOperator();

        dealingWithSupplier();

        dealingWithConsumer();

        dealingWithFunction();

        dealingWithCustomFunctionalInterface();
    }

    private static void dealingWithCustomFunctionalInterface() {
        Thinkable thinkable = () -> "I'm thinking";

        System.out.println(thinkable.think());
    }

    private static void dealingWithFunction() {
        Function<String, Integer> f = s -> Integer.valueOf(s);

        System.out.println(f.apply("5"));
    }

    private static void dealingWithConsumer() {
        Consumer<String> c = in -> System.out.println(in);

        c.accept("Tekst do wydrukowania przez Consumera");
    }

    private static void dealingWithSupplier() {
        Supplier<String> s = () -> "Zwracam wartość";

        System.out.println(s.get());
    }

    private static void dealingWithUnaryOperator() {
        UnaryOperator<Integer> uo = a -> a * 2;
        UnaryOperator<Integer> uo2 = a -> a/2;

        Integer apply = uo.compose(uo2).apply(10);

        System.out.println(apply);
    }

    private static void dealingWithPredicate() {
        Predicate<String> pr = a -> a.length()>2;
        Predicate<String> pr2 = a -> a.length()<10;

        boolean msg = pr.and(pr2).test("d");

        System.out.println(msg);
    }
}

/**
 * Customowy interfejs funkcyjny. Adnotacja @FunctionalInterface nie jest wymagana, ale jest wskazana
 */
//@FunctionalInterface
interface Thinkable{
    String think();
}
