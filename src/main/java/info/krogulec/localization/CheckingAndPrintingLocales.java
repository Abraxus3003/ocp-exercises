package info.krogulec.localization;

import info.krogulec.Utils;

import java.util.Arrays;
import java.util.Locale;

public class CheckingAndPrintingLocales {

    public static void main(String[] args) {
        printCurrentLocale();
        printAvailableLocales();
        constructingLocalesWithConstructors();
        constructingLocalesWithStatics();
        constructingLocalesWithBuilder();

        gettingLocale();
    }

    private static void gettingLocale() {
        Utils.breakingParts("Wyświetlanie parametró ustawionego locale");

        Locale usLocal = new Locale.Builder().setLanguage("en")
                .setRegion("US")
                .build();

        String fr = usLocal.getDisplayLanguage(new Locale("es"));
        System.out.println(fr);

        System.out.println(usLocal.getDisplayCountry(new Locale("fr")));

    }

    private static void constructingLocalesWithBuilder() {
        Utils.breakingParts("Tworzenie locale z użyciem buildera - ignorowane jest case");
        Locale locale = new Locale.Builder()
                .setLanguage("EN")
                .setRegion("us")
                .build();

        System.out.println("Tworzenie z wykorzystaniem buildera: " + locale);
    }

    private static void constructingLocalesWithStatics() {
        Utils.breakingParts("Tworzenie locale z użyciem stałych");
        Locale german = Locale.GERMAN;
        System.out.println("Locale.GERMAN: " + german);

        Utils.breakingParts("Tworzenie locale z użyciem stałych");
        Locale germany = Locale.GERMANY;
        System.out.println("Locale.GERMANY: " + germany);
    }

    private static void constructingLocalesWithConstructors() {
        Utils.breakingParts("Tworzenie poprawnego locale, tylko z językiem");
        Locale correctLocaleWithOnlyLanguage = new Locale("en");
        System.out.println("new Locale(\"en\"): " + correctLocaleWithOnlyLanguage);

        Utils.breakingParts("Locale z językiem dużymi literami - ignorowanie dużych liter");
        Locale languageUpper = new Locale("EN");
        System.out.println("new Locale(\"EN\"): " + languageUpper);

        Utils.breakingParts("Locale tylko z krajem");
        Locale onlyCountry = new Locale("", "US");
        System.out.println("new Locale(\"\", \"US\"): " + onlyCountry);

        Utils.breakingParts("Locale tylko z krajem - małe literny - ignorowanie małych liter");
        Locale onlyCountryLower = new Locale("", "us");
        System.out.println("new Locale(\"\", \"us\"): " + onlyCountryLower);
    }

    private static void printAvailableLocales() {
        Utils.breakingParts("Dostępne locale");
        System.out.println("Available locales: " + Arrays.toString(Locale.getAvailableLocales()));
    }

    private static void printCurrentLocale() {
        Utils.breakingParts("Domyślne locale");
        System.out.println("Locale.getDefault(): " + Locale.getDefault());
    }
}
