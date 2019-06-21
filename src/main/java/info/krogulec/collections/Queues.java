package info.krogulec.collections;

import info.krogulec.Utils;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Kiedy potrzebujemy kolejności
 */
public class Queues {

    /**
     * LinkedLIst jest kolejką - nie jest jednak tak wydajna, ale daje większą elastyczność
     */
    static Queue<Integer> linkedLIst = new LinkedList<>();

    /**
     * Czysta kolejka dwustronna
     */
    static Queue<Integer> arrayDeque = new ArrayDeque<>();


    public static void main(String[] args) {
        addingToQueue(linkedLIst);

        removingFromQueue(linkedLIst);
    }

    private static void removingFromQueue(Queue<Integer> linkedLIst) {
        Utils.breakingParts("Zabranie elementu z kolejki");

        System.out.println("Dodajemy 1 i 2");
        linkedLIst.add(1);
        linkedLIst.add(2);

        System.out.println("Usuwamy elemty przez remove");

        Integer remove = linkedLIst.remove();
        System.out.println(remove);
        Integer remove1 = linkedLIst.remove();
        System.out.println(remove1);

        try {
            Integer remove2 = linkedLIst.remove();
        } catch (Exception e){
            System.out.println("remove() rzuca wyjątek jak nie ma elementu do usunięcia");
        }

        System.out.println("Dodajemy 1 i 2");
        linkedLIst.add(1);
        linkedLIst.add(2);

        System.out.println("Usuwamy elemty przez poll");

        Integer poll = linkedLIst.poll();
        System.out.println(poll);
        Integer poll1 = linkedLIst.poll();
        System.out.println(poll1);
        Integer poll2 = linkedLIst.poll();
        System.out.println(poll2);

    }

    private static void addingToQueue(Queue<Integer> linkedLIst) {

        Utils.breakingParts("Dodanie do kolejki");

        //rzuca wyjątek jak się nie uda
        boolean add = linkedLIst.add(1);

        //nie rzuca wyjątku jak się  nie uda
        boolean offer = linkedLIst.offer(2);

        System.out.println(linkedLIst);

        linkedLIst.clear();
    }
}
