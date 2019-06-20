package info.krogulec.concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

import static info.krogulec.Utils.breakingParts;

public class ConcurrentCollections {

    public static void main(String[] args) {
        concurrentExecutionWhenModifyIterator();
        notConcurrentModificationWithConcurrentCollection();
        addingElementsToSynchronizedList();
        operationsOnQueue();
        operationsOnDeque();
    }

    private static void operationsOnDeque() {
        breakingParts("Operations on Deque");

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);

        deque.forEach(System.out::println);

        breakingParts("Offer first - dodanie na początku kolejki");
        boolean b = deque.offerFirst(5);
        deque.forEach(System.out::println);

        breakingParts("Offer last - dodanie na końcu kolejki");
        boolean b1 = deque.offerLast(5);
        deque.forEach(System.out::println);

        breakingParts("Add first - dodanie na początku kolejki");
        deque.addFirst(6);
        deque.forEach(System.out::println);

        breakingParts("Add last - dodanie na końcu kolejki");
        deque.addLast(6);
        deque.forEach(System.out::println);

        breakingParts("Peek");
        System.out.println("Standard peek: " + deque.peek());
        System.out.println("peekFirst: " + deque.peekFirst());
        System.out.println("peekLast: " + deque.peekLast());
        deque.forEach(a -> System.out.print(a + " "));

        breakingParts("Pop - zabiera pierwszy element z kolejki");
        System.out.println("Standard pop: " + deque.pop());
        deque.forEach(a -> System.out.print(a + " "));

        breakingParts("Poll");
        System.out.println("Standard poll: " + deque.poll());
        System.out.println("pollFirst: " + deque.pollFirst());
        System.out.println("pollLast: " + deque.pollLast());
        deque.forEach(a -> System.out.print(a + " "));

        breakingParts("Push - dodaje element do kolejki - zwraca void");
        deque.push(10);
        deque.forEach(a -> System.out.print(a + " "));



    }

    private static void operationsOnQueue() {
        breakingParts("operationsOnQueue");

        //constructing
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        //adding
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.forEach(System.out::println);

        //printing first to take
        Integer peek = queue.peek();
        System.out.println(peek);
        queue.forEach(System.out::println);

        Integer peek2 = queue.peek();
        System.out.println(peek2);
        queue.forEach(System.out::println);

        //taking
        Integer poll = queue.poll();
        System.out.println(poll);
        queue.forEach(System.out::println);

        //add dodaje na koniec kolejki, podobnie jak offer, przy czym pochodzi z Collection
        boolean isAdded = queue.add(1);
        queue.forEach(System.out::println);

        //element wybiera pierwszy element w kolejce
        Integer element = queue.element();
        System.out.println(element);

        //usuwanie - zabiera ierwszy element w kolejce
        breakingParts("remove from queue");
        Integer remove = queue.remove();
        queue.forEach(System.out::println);

        breakingParts("usuwanie istniejącego elementu");
        boolean remove1 = queue.remove(1);
        queue.forEach(System.out::println);

        breakingParts("usuwanie nie istniejącego elementu - brak wyjątku");
        boolean remove2 = queue.remove(2);
        queue.forEach(System.out::println);

    }

    private static void notConcurrentModificationWithConcurrentCollection() {
        List<Integer> integers = new CopyOnWriteArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        addingToCollection(integers);
    }

    private static void addingToCollection(List<Integer> integers) {
        try {
            for (int i : integers){
                System.out.println(i);
                integers.add(3);
            }
        }catch (Exception e){
            System.out.println("Nie można modyfikować kolekcji niezabezpieczonej wątkowo podczas iterowania. Wychodzi: "+  e.getClass().getName());
        }
    }

    private static void concurrentExecutionWhenModifyIterator() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        addingToCollection(integers);
    }


    private static void addingElementsToSynchronizedList() {
        List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        addingToCollection(integers);
    }
}
