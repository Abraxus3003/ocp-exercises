package info.krogulec.localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbers {

    public static void main(String[] args) throws ParseException {
        generalNumberFormatter();
        numberInstance();
        currencyInstance();
        percentInstance();
    }

    private static void percentInstance() {
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        NumberFormat percentInstanceWithLocale = NumberFormat.getPercentInstance(Locale.KOREA);

        System.out.println("Percent instance - Polskie domyslne locale: " + percentInstance.format(0.1));
        System.out.println("Percent instance - Locale koreanskie: "+ percentInstanceWithLocale.format(0.1));
    }

    private static void currencyInstance() throws ParseException {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat currencyInstanceWithLocale = NumberFormat.getCurrencyInstance(Locale.KOREA);

        System.out.println("Currency instance - Polskie domyslne locale: " + currencyInstance.format(15));
        System.out.println("Currency instance - Locale koreanskie: "+ currencyInstanceWithLocale.format(15));
    }

    private static void numberInstance() throws ParseException {
        NumberFormat defaultGeneralNumberFormatter = NumberFormat.getNumberInstance();
        NumberFormat defaultNumberFormatterWithLocale = NumberFormat.getNumberInstance(Locale.KOREA);

        System.out.println("Number instance - Polskie domyslne locale: " + defaultGeneralNumberFormatter.parse("1234,44"));
        System.out.println("Number instance - Locale koreanskie: "+ defaultNumberFormatterWithLocale.parse("1234,44"));
    }

    private static void generalNumberFormatter() throws ParseException {

        NumberFormat defaultGeneralNumberFormatter = NumberFormat.getInstance();
        NumberFormat defaultNumberFormatterWithLocale = NumberFormat.getInstance(Locale.KOREA);

        System.out.println("General - Polskie domyslne locale: " + defaultGeneralNumberFormatter.parse("1234,44"));
        System.out.println("General - Locale koreanskie: "+ defaultNumberFormatterWithLocale.parse("1234,44"));

        System.out.println("General - java ignoruje koncowke jesli nie moze z nia nic zrobic - Polskie domyslne locale: " + defaultGeneralNumberFormatter.parse("1234xxx"));

        try{
            System.out.println("General - java ignoruje koncowke jesli nie moze z nia nic zrobic - Polskie domyslne locale: " + defaultGeneralNumberFormatter.parse("xxx1234"));
        } catch (ParseException e){
            System.out.println("Parsowany ciag znakow nie moze sie zaczynac od znaku, ktorego nie mozna zamienic na numer");
        }

    }
}
