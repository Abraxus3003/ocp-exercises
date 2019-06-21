package info.krogulec.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTransformations {

    public static void main(String[] args) {
        relativisationTwoRelatives();
        relativisationTwoAbsolutes();
        relativisationRelativeWithAbsolute();
        relativisationAbsoluteWithRelative();
        resolving();
    }

    private static void resolving() {
        Path resolveResult = Paths.get("/myPath/one").resolve("../msg/somePath.ki");
        System.out.println("Resolve result 2x rel: " + resolveResult);

        //zawsze jak drugim parametrem jest ansolutna ścieżka jest ona pozostawiona
        Path resolveResult2 = Paths.get("/myPath/one").resolve("F:/../msg/somePath.ki");
        System.out.println("Resolve result rel to abs: " + resolveResult2);

        //gdy pierwsza jest ścieżka absolutna, wykonywane jest zwykłe dodanie
        Path resolveResult3 = Paths.get("C:/myPath/one").resolve("msg/somePath.ki");
        System.out.println("Resolve result abs to rel: " + resolveResult3);

        //zawsze jak drugim parametrem jest ansolutna ścieżka jest ona pozostawiona
        Path resolveResult4 = Paths.get("C:/myPath/one").resolve("D:/msg/somePath.ki");
        System.out.println("Resolve result 2 x abs: " + resolveResult4);

    }

    private static void relativisationTwoRelatives() {
        String pathStr1 = "../my/path1";
        String pathStr22 = "haha/my/path2";

        Path path1 = Paths.get(pathStr1);
        Path path2 = Paths.get(pathStr22).relativize(path1);

        System.out.println("Relativise " + pathStr1 + " with " + pathStr22 + " is: " + path2);
    }

    private static void relativisationTwoAbsolutes() {

        String pathStr1 = "C:\\msg\\blada\\path";
        String pathStr22 = "C:\\ole\\kole\\..\\tutu";

        Path path1 = Paths.get(pathStr1);
        Path path2 = Paths.get(pathStr22).relativize(path1);

        System.out.println("Relativise " + pathStr1 + " with " + pathStr22 + " is: " + path2);

        String pathStr3 = "C:\\my\\path1";
        String pathStr4 = "D:\\second\\path";

        Path path3 = Paths.get(pathStr3);

        try {
            Path path4 = Paths.get(pathStr4).relativize(path3);
        } catch (IllegalArgumentException e){
            System.out.println("Nie można relatywizować dwóch oddzielnych rootów");
        }
    }

    private static void relativisationRelativeWithAbsolute() {
        String pathStr1 = "\\my\\path1";
        String pathStr22 = "C:\\haha\\my\\path2";

        Path path1 = Paths.get(pathStr1);


        try{
            Path path2 = Paths.get(pathStr22).relativize(path1);
        } catch (IllegalArgumentException e){
            System.out.println("Nie można relatywizować ścieżki relatywnej do absolutnej");
        }
    }

    private static void relativisationAbsoluteWithRelative() {
        String pathStr22 = "lala\\mala";
        String pathStr11 = "C:\\haha\\my\\path2";

        Path path1 = Paths.get(pathStr22);

        try {
            Path path2 = Paths.get(pathStr11).relativize(path1);
        } catch (IllegalArgumentException e){
            System.out.println("Nie można relatywizować ścieżki absolutnej do relatywnej");
        }
    }


}
