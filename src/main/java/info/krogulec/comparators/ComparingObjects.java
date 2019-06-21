package info.krogulec.comparators;

import java.util.*;

public class ComparingObjects {

    public static void main(String[] args) {

        //TreeSet automatycznie wywołuje metodę compareTo()
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("Abraham"));
        personSet.add(new Person("Bob"));
        personSet.add(new Person("Clive"));
        personSet.add(new Person("aaron"));

        System.out.println(personSet);

        //zwykła lista
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Abraham"));
        persons.add(new Person("Bob"));
        persons.add(new Person("Clive"));
        persons.add(new Person("aaron"));

        //sortowanie z tykorzytaniem comparatora
        persons.sort(new PersonComparator());

        System.out.println(persons);
    }

}


class Person implements Comparable<Person>{

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
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

class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
