package info.krogulec.localization;

import info.krogulec.Utils;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundles {
    public static void main(String[] args) {
        Locale english = new Locale("en", "US");
        Locale polish = new Locale("pl", "PL");

        Utils.breakingParts("Wyświetlenie konkretnych właściwości z plików properties - Zoo_en.propeties");
        printProperties(english);

        Utils.breakingParts("Wyświetlenie konkretnych właściwości z plików properties - Zoo_pl.propeties");
        printProperties(polish);

        convertToProperties(polish);
    }

    private static void convertToProperties(Locale locale) {
        Utils.breakingParts("Zmiana resource boundle na properties - properties pozwala na dodanie domyślnej wartości jeśli key nie zostało znalezione");
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        Properties properties = new Properties();

        rb.keySet().forEach(key -> properties.put(key, rb.getString(key)));

        System.out.println(properties);

        System.out.println("Brak key - wyświetlenie domyśnej właściwości: " + properties.getProperty("msg", "Domyślna wartość"));

    }

    private static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println("rb.getString(\"hello\")" + rb.getString("hello") + " Locale: " + locale);
        System.out.println("rb.getString(\"hello\")" + rb.getString("open") + " Locale: " + locale);
    }
}
