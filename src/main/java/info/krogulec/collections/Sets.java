package info.krogulec.collections;

import info.krogulec.Utils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Nie mają kolejności
 */
public class Sets {

    /**
     * Dostęp do elementów zajmuje stały czas, ale traci się kolejność
     */
    static Set<String> hashSet = new HashSet<>();

    /**
     * Uporządkowany set - woła metodę compareTo()
     */
    static Set<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        add(hashSet);

        strangeMethods();
    }

    private static void strangeMethods() {
        Utils.breakingParts("Metody dziedziczone z NavigableSet");

        TreeSet<Integer> set = IntStream.range(1, 21).boxed().collect(Collectors.toCollection(TreeSet::new));

        System.out.println(set);

        System.out.println("lower(10): " + set.lower(10));
        System.out.println("floor(10): " + set.floor(10));
        System.out.println("ceiling(10): " + set.ceiling(10));
        System.out.println("higher(10): " + set.higher(10));

        System.out.println("lower(0): " + set.lower(0));
        System.out.println("floor(0): " + set.floor(0));
        System.out.println("ceiling(21): " + set.ceiling(21));
        System.out.println("higher(21): " + set.higher(21));
    }

    public static void add(Set<String> set){
        Utils.breakingParts("Dodawanie do seta");
        System.out.println(hashSet.add("F"));
        System.out.println(hashSet.add("G"));
        System.out.println(hashSet.add("C"));
        System.out.println(hashSet.add("G"));

        System.out.println(set);

        hashSet.clear();

    }


}
