package info.krogulec.io;

import java.io.File;
import java.io.IOException;

public class WorkingWithFile {

    public static void main(String[] args) {
        //utworzenie obiketu File nie rzuca wyjątku
        File file = new File("C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\file.txt");

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("brak możliwości utworzenia pliku");
            }
        }

        System.out.println("file.isFile(): " + file.isFile());
        System.out.println("file.isDirectory(): " + file.isDirectory());

        File dir = new File("C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\dir");

        if (!dir.exists()){
            dir.mkdir();
        }

    }
}
