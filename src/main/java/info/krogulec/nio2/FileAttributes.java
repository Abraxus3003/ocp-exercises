package info.krogulec.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;


public class FileAttributes {

    private static final Path PATH = Paths.get("C:\\Users\\piotr.krogulec\\Desktop\\OCP\\nio2.txt");

    public static void main(String[] args) {
        getBasicFileAttributes();
        getAttributesMap();
        getBasicFileAttributesView();
        getBasicFileAttributesViewWithInvalildPath();
    }

    private static void getBasicFileAttributesViewWithInvalildPath() {
        System.out.println("WYCIĄGNIĘCIE WIDOKU DLA NIE ISTNIEJĄCEGO PLIKU (NIE MUSIMY OBSłUGIWAC WYJATKU IO:");
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(Paths.get("D:\\msg\\nie\\istnieje\\brak.txt"), BasicFileAttributeView.class);
        try {
            FileTime ft = FileTime.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
            fileAttributeView.setTimes(ft, ft, ft);
        } catch (IOException e) {
            System.out.println("Wyjątek przy widoku przechwytujemy przy próbie wyciągnięcia atrybutów lub próbie ustawienia czasów dostępu");
        }
    }

    //Widok pozwala na edycję, ale tylko czasów utworzenia, modyfikacji i ostatniego dostępu
    private static void getBasicFileAttributesView() {
        System.out.println("WYCIĄGNIĘCIE WIDOKU (NIE MUSIMY OBSłUGIWAC WYJATKU IO:");
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(PATH, BasicFileAttributeView.class);

        try {
            System.out.println("Creation time przed zmianą: " + fileAttributeView.readAttributes().creationTime());
            System.out.println("Last access time przed zmianą: " + fileAttributeView.readAttributes().lastAccessTime());
            System.out.println("Lat modified time przed zmianą: " + fileAttributeView.readAttributes().lastModifiedTime());

            FileTime ft = FileTime.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

            fileAttributeView.setTimes(ft, ft, ft);

            System.out.println("Creation time po zmianie: " + fileAttributeView.readAttributes().creationTime());
            System.out.println("Last access time po zmianie: " + fileAttributeView.readAttributes().lastAccessTime());
            System.out.println("Lat modified time po zmianie: " + fileAttributeView.readAttributes().lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Jeśli null jest argumentem przekazanym, nic się nie zmienia
        try {
            System.out.println("Creation time przed zmianą na null: " + fileAttributeView.readAttributes().creationTime());
            System.out.println("Last access time przed zmianą na null: " + fileAttributeView.readAttributes().lastAccessTime());
            System.out.println("Lat modified time przed zmianą na null: " + fileAttributeView.readAttributes().lastModifiedTime());

            fileAttributeView.setTimes(null, null, null);

            System.out.println("Creation time po zmianie na null: " + fileAttributeView.readAttributes().creationTime());
            System.out.println("Last access time po zmianie na null: " + fileAttributeView.readAttributes().lastAccessTime());
            System.out.println("Lat modified time po zmianie na null: " + fileAttributeView.readAttributes().lastModifiedTime());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    //Można tylko podejrzeć atrybuty
    private static void getAttributesMap() {
        System.out.println("WYCIĄGNIĘCIE MAPY ATRYBUTÓW:");
        try {
            Map<String, Object> attrMap = Files.readAttributes(PATH, "*");

            for (Map.Entry<String, Object> attr : attrMap.entrySet()){
                System.out.println(attr.getKey() + " " + attr.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Można tylko podejrzeć atrybuty
    private static void getBasicFileAttributes() {
        System.out.println("WYCIĄGNIĘCIE BASIC_FILE_ATTRIBUTES:");
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(PATH, BasicFileAttributes.class);

            System.out.println("Is directory: " + basicFileAttributes.isDirectory());
            System.out.println("Creation time: " + basicFileAttributes.creationTime());
            System.out.println("Size: " + basicFileAttributes.size());
            System.out.println("Is dsymbolic link: " + basicFileAttributes.isSymbolicLink());
            System.out.println("File key: " + basicFileAttributes.fileKey());
            System.out.println("Is other: " + basicFileAttributes.isOther());
            System.out.println("Is regular file: " + basicFileAttributes.isRegularFile());
            System.out.println("Last access time: " + basicFileAttributes.lastAccessTime());
            System.out.println("Last modified time: " + basicFileAttributes.lastModifiedTime());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
