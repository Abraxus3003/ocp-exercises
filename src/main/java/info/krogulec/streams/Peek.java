package info.krogulec.streams;

import java.util.stream.Stream;

public class Peek {

    public static void main(String[] args) {
        Stream.of(3,2,3,4,5,6,1).peek(System.out::println).allMatch(a -> a > 2);
        Stream.of("msg", "blada", "a").peek(System.out::println).anyMatch(a -> a.length() < 2);
    }
}
