package info.krogulec.maps;

import java.util.*;

public class RandomOperations {

    public static void main(String[] args) {
        subMapOnlyInNavigableMap();

        sortTreeMap();
    }

    private static void subMapOnlyInNavigableMap() {
        NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(9,1);
        treeMap.put(7,3);
        treeMap.put(8,2);
        treeMap.put(6,4);

        System.out.println(treeMap.subMap(6,true, 7, true));
    }

    private static void sortTreeMap() {

        Map<KeyWithoutComparable, Integer> treeMap = new TreeMap<>();

        try{
            treeMap.put(new KeyWithoutComparable(),1);
        } catch (ClassCastException e){
            System.out.println("Nie można w treeMap jako klucza używać czegoś bez implementacji Comparable");
        }

        Map<KeyWithComparable, Integer> map = new TreeMap<>();

        map.put(new RandomOperations().new KeyWithComparable(), 1);
        map.put(new RandomOperations().new KeyWithComparable(), 2);
        map.put(new RandomOperations().new KeyWithComparable(), 3);
        map.put(new RandomOperations().new KeyWithComparable(), 4);

        System.out.println(map);

    }

    static class KeyWithoutComparable {}

    private class KeyWithComparable implements Comparable<KeyWithComparable> {
        @Override
        public int compareTo(KeyWithComparable o) {
            return new Random().nextInt();
        }


    }
}
