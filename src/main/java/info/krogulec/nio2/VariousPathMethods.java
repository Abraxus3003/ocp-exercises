package info.krogulec.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class VariousPathMethods {

    public static void main(String[] args) {
        Path path = Paths.get("first\\second\\third");

        System.out.println("path.toAbsolutePath()" + path.toAbsolutePath());
        System.out.println("path.getNameCount()" + path.getNameCount());
        System.out.println("path.getName(1)" + path.getName(1));
        System.out.println("path.getFileName()" + path.getFileName());
        System.out.println("path.getRoot()" + path.getRoot());
    }
}
