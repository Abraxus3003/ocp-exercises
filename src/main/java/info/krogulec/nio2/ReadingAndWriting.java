package info.krogulec.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadingAndWriting {

    public static final String FILE_PATH = "C:\\Users\\piotr.krogulec\\Desktop\\OCP\\NIO\\TEST_READING_WRITING\\plik.txt";

    public static void main(String[] args) {
        readingFile();
        readingFileWithCharset();
        writeToFile();
        readAllLines();
        readLines();
    }

    /**
     * Odczytanie dużych plików do strumienia - bezpieczniejsze dla dużych plików
     */
    private static void readLines() {
        try {
            Stream<String> lines = Files.lines(Paths.get(FILE_PATH));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Odczytanie dużych plików może się skończyć OutOfMemoryException
     */
    private static void readAllLines() {
        try {
            List<String> strings = Files.readAllLines(Paths.get(FILE_PATH));
            strings.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {
        BufferedWriter writer = null;

        try {
            writer = Files.newBufferedWriter(Paths.get(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (writer != null){
            try {
                writer.write("new writer line added");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeWriter(writer);
            }
        }
    }

    private static void closeWriter(BufferedWriter writer) {
        if (writer != null){
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readingFileWithCharset() {
        BufferedReader fileReader = null;

        try {
            fileReader = Files.newBufferedReader(Paths.get(FILE_PATH), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileReader != null){
            fileReader.lines().forEach(System.out::println);
        }
    }

    private static void readingFile() {
        BufferedReader fileReader = null;

        try {
            fileReader = Files.newBufferedReader(Paths.get(FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileReader != null){
            fileReader.lines().forEach(System.out::println);
        }


    }
}
