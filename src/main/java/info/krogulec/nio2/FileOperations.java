package info.krogulec.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FileOperations {

    private static final String TEST_NIO_PATH = "C:\\Users\\piotr.krogulec\\Desktop\\OCP\\NIO\\TEST";


    public static void main(String[] args) throws IOException {
        createDir();
        createFile();
        moveDir();
        copyDir();
        moveFile();
        copyFile();
        readFile();
        deleteNotExistingFile();
        deleteFile();

    }

    private static void createFile() {
        if (!Files.exists(Paths.get(TEST_NIO_PATH, "nio.txt"))){
            try {
                Files.createFile(Paths.get(TEST_NIO_PATH, "nio.txt"));
                Files.write(Paths.get(TEST_NIO_PATH, "nio.txt"), Arrays.asList("one", "two", "three"));
            } catch (IOException e) {
                System.out.println("Błąd podczas tworzenia pliku");
            }
        }
    }

    private static void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get(TEST_NIO_PATH, "nio.txt"));
        } catch (IOException e) {
            System.out.println("Błąd podczas usuwania pliku");
        }
    }

    private static void deleteNotExistingFile() {
        try {
            Files.delete(Paths.get(TEST_NIO_PATH, "msg"));
        } catch (IOException e) {
            System.out.println("Użycie metody delete kończy się wyjątkiem, jeśli plik/ katalog nie istnieje");
        }
    }

    private static void readFile() {
        try {
            //lines zwraca Stream
            Stream<String> lines = Files.lines(Paths.get(TEST_NIO_PATH, "nio.txt"));
            lines.forEach(a -> System.out.println("Odczyt poprzez lines, która zwraca stream: " + a));

            //readAllLines zwraca listę
            List<String> readAllLines = Files.readAllLines(Paths.get(TEST_NIO_PATH, "..", "TESTII", "nioCopied.txt"));
            readAllLines.forEach(a -> System.out.println("Odczyt poprzez readAllLines, która zwraca listę: " + a));

        } catch (IOException e) {
            System.out.println("Błąd podczas odczytu pliku");
        }
    }

    private static void copyFile() {
        try {
            Files.copy(Paths.get(TEST_NIO_PATH, "nio.txt"), Paths.get(TEST_NIO_PATH, "..", "TESTII", "nioCopied.txt"));
        } catch (IOException e) {
            System.out.println("Błąd podczas kopiowania pliku");
        }
    }

    private static void moveFile() {
        try {
            Files.move(Paths.get(TEST_NIO_PATH,"nio.txt"), Paths.get(TEST_NIO_PATH, "..", "TESTII", "nioMoved.txt"));
        } catch (IOException e) {
            System.out.println("Błąd podczas przenoszenia pliku");
        }
    }

    /**
     * Trzeba zwrócić uwagę, że copy nie kopiuje plików w środku
     */
    private static void copyDir() {
        try {
            Files.copy(Paths.get(TEST_NIO_PATH), Paths.get(TEST_NIO_PATH + "\\..\\TEST" + new Random().nextInt(100)));
        } catch (IOException e){
            System.out.println("Błąd podczas kopiowania katalogu");
        }
    }

    private static void createDir() throws IOException {
        Path path = Paths.get(TEST_NIO_PATH);

        if (!Files.exists(path)){
            Files.createDirectory(path);
        }


    }

    private static void moveDir() {
        try {
            Files.move(Paths.get(TEST_NIO_PATH), Paths.get(TEST_NIO_PATH + "\\..\\TESTII"));
        } catch (IOException e){
            System.out.println("Błąd podczas zmiany nazwy katalogu");
        }
    }
}
