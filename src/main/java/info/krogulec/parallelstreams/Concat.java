package info.krogulec.parallelstreams;

import java.util.Arrays;
import java.util.List;

public class Concat {


    public String concat1(List<String> values){
        return values
                .parallelStream()
                .reduce("a", (x,y) -> x+y, String::concat);
    }

    public String concat2(List<String> values){
        return values
                .parallelStream()
                .reduce((x,y) -> y + x).get();
    }

    public static void main(String[] args) {
        Concat concat = new Concat();

        System.out.println(concat.concat1(Arrays.asList("Cat", "Hat")) + " " + concat.concat2(Arrays.asList("msg", "some")));
    }
}
