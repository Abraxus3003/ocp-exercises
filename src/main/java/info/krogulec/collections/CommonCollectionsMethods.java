package info.krogulec.collections;

import info.krogulec.Utils;

import java.util.*;
import java.util.stream.Stream;

class Person{
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (!(obj instanceof Person)){
            return false;
        }

        Person p = (Person) obj;

        return p.name.equals(name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

public class CommonCollectionsMethods {
    public static void main(String[] args) {
        add();
        remove();
        contains();

        bla(Arrays.asList("first", "second"));
    }

    private static void contains() {
        Utils.breakingParts("Wykorzystanie metody contains");
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jarek"));
        people.add(new Person("Mateusz"));
        people.add(new Person("Mariuisz"));

        System.out.println(people);

        System.out.println("People contains Donald: " + people.contains(new Person("Donald")));
        System.out.println("People contains Jarek: " + people.contains(new Person("Jarek")));
    }

    private static void remove() {
        Utils.breakingParts("Usuwanie elementów w kolekcji");
        List<String> stringList = new ArrayList<>();
        stringList.add("b");
        stringList.add("a");
        stringList.add("c");
        stringList.add("d");
        System.out.println("Elementy w liście: " + stringList);

        stringList.remove("a");

        System.out.println("Usunięcie obiketu (wykorzytsywane jest equals) a: " + stringList);

        stringList.remove(1);

        System.out.println("Usunięcie obiektu na podstawie indeksu 1: " + stringList);
    }

    private static void add() {
        Utils.breakingParts("Dodawanie elementów do kolekcji");
        Set<String> set = new TreeSet<>();
        set.add("msg");
        System.out.println(set);
        set.add("ala");
        System.out.println(set);
        set.add("cep");
        System.out.println(set);
    }

    public static void bla(Collection<?> collection){
        Stream.of(collection)
                .flatMap(x -> x.stream())
                .forEach(System.out::println);
    }
}
