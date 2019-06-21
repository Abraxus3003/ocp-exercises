package info.krogulec.io;

import java.io.*;
import java.util.stream.Stream;

public class ReadingFile {

    private static final String FILE_TO_READ_PATH = "C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\fileToRead.txt";
    private static final String BUFFERED_FILE_TO_WRITE_PATH = "C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\fileToWriteBufferedWriter.txt";

    public static void main(String[] args) throws IOException {
        readingWithInputStream();

        readingWithBufferedReader();

        copyFile();

        copyWithBufferedClasses();

        copyWithBufferedReaderAndWriter();
    }

    private static void copyWithBufferedReaderAndWriter() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_TO_READ_PATH));
             BufferedWriter bw = new BufferedWriter(new FileWriter(BUFFERED_FILE_TO_WRITE_PATH))) {

            String line;

            while ((line = br.readLine()) != null){
                bw.write(line);
                bw.newLine();

            }
        }
    }

    private static void copyWithBufferedClasses() throws IOException {

        try (InputStream bis = new BufferedInputStream(new FileInputStream(FILE_TO_READ_PATH));
             OutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\fileToWriteBuffered.txt"))) {

            byte [] bytes = new byte[1024];
            int length = 0;

            while((length = bis.read(bytes)) > 0){
                bos.write(bytes, 0, length);
            }
        }
    }

    private static void copyFile() throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(FILE_TO_READ_PATH));
             FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\piotr.krogulec\\Programowanie\\Szkolenia-prowadzenie\\Sages\\trainings\\temp\\fileToWrite.txt"))) {
            int readVal = 0;

            while (readVal != -1){
                readVal = fis.read();
                fos.write(readVal);
            }
        }
    }

    private static void readingWithBufferedReader() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_TO_READ_PATH)))) {
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);
        }
    }

    private static void readingWithInputStream() throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(FILE_TO_READ_PATH))) {
            int readValue = 0;
            while (readValue != -1){
                readValue = fis.read();
                System.out.print((char)readValue);
            }
        }
    }
}
