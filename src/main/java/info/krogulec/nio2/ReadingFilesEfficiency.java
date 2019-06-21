package info.krogulec.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadingFilesEfficiency {

    private static final String FILE_PATH = "C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\mazowieckie.txt";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(FILE_PATH);

        listWay(path);

        //streamWay(path);
    }

    private static void streamWay(Path path) throws IOException {
        Stream<String> lines = Files.lines(path, Charset.forName("Windows-1250"));

        lines.findFirst()
                .ifPresent(System.out::println);
    }

    private static void listWay(Path path) throws IOException {
        List<String> readAllLines = Files.readAllLines(path, Charset.forName("Windows-1250"));
        String s = readAllLines.get(0);
        System.out.println(s);
    }
}
