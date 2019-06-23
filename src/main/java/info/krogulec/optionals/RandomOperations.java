package info.krogulec.optionals;

import java.util.ListResourceBundle;
import java.util.Optional;

public class RandomOperations {

    public static void main(String[] args) {
        Optional<String> s = returnOptional();

        if (s.isPresent()){
            System.out.println(s.get());
        }

        //to samo co powyżej tylko funkcjonalnie
        s.ifPresent(in -> System.out.println(in));

        Optional<String> nullOptional = returnOptionalWithNull();

        System.out.println(nullOptional.orElse("fallback"));

        System.out.println(nullOptional.orElseGet(() -> fallbackLazyFunction()));

        nullOptional.orElseThrow(() -> new RuntimeException("Value not present"));

    }

    private static String fallbackLazyFunction() {
        return "fallback lazy func";
    }

    private static Optional<String> returnOptionalWithNull() {
        return Optional.ofNullable(null);
    }

    private static Optional<String> returnOptional() {
        return Optional.of("coś mam");
    }


}
