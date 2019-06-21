package info.krogulec.nio2;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.stream.Stream;

public class CreatingPath {

    public static void main(String[] args) throws URISyntaxException {

        //dostęp do systemu plików
        FileSystem defaultFs = FileSystems.getDefault();

        Path todoPath = Paths.get("C:\\Users\\piotr.krogulec\\Desktop\\todo.txt");

        Path parent2 = todoPath.getParent();

        //Ta ścieżka jest relatywna
        Path fileName = todoPath.getFileName();

        //W tym przypadku nie ma parenta - jest null
        Path parent1 = fileName.getParent();

        //Można wyciągnąć poszczególne części ścieżki - root jest wykluczony !
        for (int i = 0; i < todoPath.getNameCount(); i++){
            System.out.println(todoPath.getName(i));
        }

        //Z obiektu path można zrobić File
        File todoFile = todoPath.toFile();

        Path notExistingFileFromUri = Paths.get(new URI("file:///C:/Users/piotr.krogulec/Desktop/msg.txt"));

        //Będzie rzucony wyjątek jeśli spróbujemy stworzyć realPath z Path, które nie istnieje
        try {
            Path path3 = notExistingFileFromUri.toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //tworzenie ścieżki - istniejąca ścieżka do folderu
        Path path = Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice");
        Path path2 = path.subpath(1, 3);
        Path name1 = path.getName(1);
        Path name2 = path2.getName(1);


        boolean absolute = path.isAbsolute();
        Path parent = path.getParent();

        try {
            Path shouldBeOk = path.toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tworzenie ścieżki - nie istniejąca ścieżka
        Path pathNotValid = Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice", "Papa");

        try {
            Path shouldNotBe = pathNotValid.toRealPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathToRealFile = Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\pr.txt");

        //czytanie pliku - stara metoda
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToRealFile.toFile()));
            String s = br.readLine();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //czytanie pliku nowa metoda
        try {
            Stream<String> lines = Files.lines(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\pr.txt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //czytanie pliku nowa metoda - try with resources
        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\pr.txt"))){
            lines.forEach(System.out::println);
        } catch (IOException e){

        }

        //wyciągnięcie właściciela pliku
        try {
            UserPrincipal owner = Files.getOwner(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\pr.txt"));
            String name = owner.getName();
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //stworzenie katalogu
        try {
            //Path directory = Files.createDirectory(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New2"));
            //System.out.println(directory);
            //Path copy = Files.copy(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\pr.txt"), Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New\\pr.txt"));
            //System.out.println(copy);
            //Files.copy(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New\\pr.txt"), Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New2\\pr.txt"));
            boolean b = Files.deleteIfExists(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New2"));
            System.out.println(b);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //sprawdzanie właściwości pliku/ katalogu
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New"), BasicFileAttributes.class);
            boolean directory = basicFileAttributes.isDirectory();

            System.out.println(basicFileAttributes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //referencja do atrybutów pliku/ katalogu - możliwość zmiany atrybutów
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New\\msg.tzt"), BasicFileAttributeView.class);


        //szukanie plików/ katalogów o pewnych właściwościach
        try {
            Files.walk(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice"))
                    .filter(f -> Files.isDirectory(f))
                    .forEach(System.out::println);

            System.out.println("a");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.find(Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice"), 5, (p,a) -> a.size()>10000).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path path1 = Paths.get("C:\\Users\\piotr.krogulec\\.\\.\\Programowanie\\Java\\Practice\\","\\..\\pr.txt");
        Path normalize = path1.normalize();

        Path relativize = normalize.relativize(Paths.get("C:\\Users\\piotr.krogulec\\.\\.\\Programowanie\\Java\\Practice\\ocr\\pom.xml"));


        Path symLink = Paths.get("C:\\Users\\piotr.krogulec\\Programowanie\\Java\\Practice\\New\\pr.txt");
        Path msg = symLink.resolve("msg");
        try {
            Files.createDirectory(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(normalize);


    }
}
