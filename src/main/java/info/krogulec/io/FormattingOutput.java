package info.krogulec.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FormattingOutput {

    public static void main(String[] args) throws FileNotFoundException {

        try (PrintWriter pw = new PrintWriter("C:\\Users\\piotr.krogulec\\Desktop\\OCP\\fileToWriteBuffered.txt")) {
            pw.print("msg");
            pw.printf("msg %s", "blada");
            pw.format("msg %s", "blada");
        }


    }
}
