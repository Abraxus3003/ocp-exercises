package info.krogulec.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class WorkingWithDeque {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Pierwszy", "Drugi", "Trzeci");

        Deque<String> deque = new ArrayDeque<>(strings);

        System.out.println(deque);

        deque.add("Czwarty");

        System.out.println(deque);

        deque.push("Piąty");

        System.out.println(deque);

        deque.offer("Szósty");

        System.out.println(deque);

        deque.offerFirst("Siódmy");

        System.out.println(deque);


        System.out.println(deque.peekLast());

        System.out.println(deque);

        deque.poll();
    }
}
