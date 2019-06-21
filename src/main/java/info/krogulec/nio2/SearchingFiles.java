package info.krogulec.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class SearchingFiles {

    public static void main(String[] args) {
        try {
            Stream<Path> walk = Files.walk(Paths.get("d://la/lala/lala"), FileVisitOption.FOLLOW_LINKS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
