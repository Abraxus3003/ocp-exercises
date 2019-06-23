package info.krogulec.streams;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class UsingDoubleStreams {

    public static void main(String[] args) {
        System.out.println("mapToDouble() zwraca DoubleStream" + Stream.of(1,2,3,4).mapToDouble(a -> (double) a));

        DoubleFunction<String> df = d -> "msg" + d;

        DoubleStream.of(1.1, 1.2, 2.1).mapToObj(df).forEach(System.out::print);

        System.out.println();

        BinaryOperator<Double> doubleBinaryOperator = BinaryOperator.maxBy(Double::compare);
        System.out.println("BinaryOperator.maxBy: " + doubleBinaryOperator.apply(1.1, 1.2));

        BinaryOperator<Double> doubleBinaryOperator2 = BinaryOperator.minBy(Double::compare);
        System.out.println("BinaryOperator.minBy: " + doubleBinaryOperator2.apply(1.1, 1.2));

    }
}
