package info.krogulec.datesandtimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingDates {

    public static void main(String[] args) {
        LocalDate ld = LocalDate.of(2013, 12, 1);
        LocalTime lt = LocalTime.of(12, 43);

        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        System.out.println("DateTimeFormatter.ISO_DATE" + ldt.format(DateTimeFormatter.ISO_DATE));
        System.out.println("DateTimeFormatter.ofPattern(\"yyyy-dd-MM\")" + ldt.format(DateTimeFormatter.ofPattern("yyyy-dd-MM")));
        System.out.println("DateTimeFormatter.ofPattern(\"yy-MM-dd\", Locale.CHINA)" + ldt.format(DateTimeFormatter.ofPattern("yy-MM-dd", Locale.CHINA)));

        try{
            System.out.println(ldt.format(DateTimeFormatter.ofPattern("sd-ccc-sda-kkkk")));
        } catch (Exception e){
            System.out.println("Proba wyciagniecia locale z blednego patternu: " + "ldt.format(DateTimeFormatter.ofPattern(\"sd-ccc-sda-kkkk\"");
        }


        //Uzywanie ofLocalized
        System.out.println("DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)" + ldt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println("DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)" + ldt.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));

        try {
            String format = ld.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        } catch (Exception e){
            System.out.println("Nie mozna formatowac LocalDate przy uzyciu ofLocalizedTime " + e.getMessage() + e.getClass());
        }

        try {
            String format = lt.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        } catch (Exception e){
            System.out.println("Nie mozna formatowac LocalTime przy uzyciu ofLocalizedDate " + e.getMessage() + e.getClass());
        }
    }
}
