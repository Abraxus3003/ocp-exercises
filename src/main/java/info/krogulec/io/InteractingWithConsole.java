package info.krogulec.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractingWithConsole {

    public static void main(String[] args) throws IOException {
        oldWay();

        newWay();
    }

    //nowa metoda odczytania wejścia
    private static void newWay() {

        Console console = System.console();

        if (console != null){
            String s = console.readLine();
            console.writer().println("Wpisana linia: " + s);
        }
    }

    //wcześniejsza metoda bez użycia obiketu Console
    private static void oldWay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println("Przeczytana linia: " + s);
    }
}
