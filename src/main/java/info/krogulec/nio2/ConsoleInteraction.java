package info.krogulec.nio2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsoleInteraction {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            System.out.println("Podaj - Operacje na jednej ścieżce - 1, Operacje na dwóch ścieżkach 2");

            String s = reader.readLine();

            if (s.equals("1")){
                operationsOnOnePath();
            } else if (s.equals("2")){
                operationsOnTwoPaths();
            } else {
                System.out.println("Fatal error - koniec programu - wpisano zabójczy string!!!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void operationsOnOnePath() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out))){

            while (true){
                bw.println("Podaj ścieżkę: ");
                bw.flush();

                String path1Str = br.readLine();

                bw.println("Wynik: ");
                bw.flush();

                Path path1 = Paths.get(path1Str);

                //TUTAJ PODAJEMY OPERACJE DO PWYKOANIA
                System.out.println(path1.normalize());

                bw.println("Dalej (t/n)?");
                bw.flush();

                String next = br.readLine();

                if (next.equalsIgnoreCase("n")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void operationsOnTwoPaths() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter bw = new PrintWriter(new OutputStreamWriter(System.out))){

            while (true){
                bw.println("Podaj pierszą ścieżkę: ");
                bw.flush();

                String path1Str = br.readLine();

                bw.println("Podaj drugą ścieżkę: ");
                bw.flush();

                String path2Str = br.readLine();

                bw.println("Wynik: ");
                bw.flush();

                Path path1 = Paths.get(path1Str);
                Path path2 = Paths.get(path2Str);

                //TUTAJ PODAJEMY OPERACJE DO PWYKOANIA
                System.out.println(path1.relativize(path2));

                bw.println("Dalej (t/n)?");
                bw.flush();

                String next = br.readLine();

                if (next.equalsIgnoreCase("n")){
                    break;
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
