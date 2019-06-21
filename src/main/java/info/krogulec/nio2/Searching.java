package info.krogulec.nio2;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Searching {

    private int access;


    public static void main(String[] args) throws IOException {

        Files.walk(Paths.get("C:\\Users\\piotr.krogulec\\Desktop"),2)
                .forEach(System.out::println);


        }
}

class Access {
    private int accessOutside;
}
