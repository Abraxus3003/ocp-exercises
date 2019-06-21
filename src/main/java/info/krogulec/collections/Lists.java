package info.krogulec.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Listy są ordered i pozwalają na duplikaty - właściwości ogólne
 */
public class Lists {

    // zapewnia szybsze odczyty niż dodawnie i usuwanie elementów
    List<String> arrayList = new ArrayList<>();

    // można mieć dostęp do początku i końca w stałym czasie. Szukanie indeksu zajmuje O(n)
    List<String> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1,2,3,4,5,6);
        lst.replaceAll(a -> a*2);

        System.out.println(lst);


    }





}


