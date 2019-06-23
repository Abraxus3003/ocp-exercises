package info.krogulec.streams;

import java.util.function.Function;

public class ComposingFunctions {

    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;
        Function<Integer, String> intToStr = Object::toString;

        System.out.println(strToInt.compose(intToStr).apply(5));


    }
}
