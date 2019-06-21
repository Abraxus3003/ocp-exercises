package info.krogulec.datesandtimes;

import java.time.*;

public class CreatingDatesAndTimes {

    public static void main(String[] args) {
        prepareDatesWithLocalDate();
        prepareDatesWithLocalDateTime();



    }

    private static void prepareDatesWithZoned(){}

    //Przygotowanie dat LocalDateTime
    private static void prepareDatesWithLocalDateTime(){
        System.out.println("Tworzenie LocalDateTime:");

        //tworzenie dzisiejszej daty
        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println(ldtNow);

        //Tworzenie z LocalDate i LocalTime
        LocalDateTime ldtFromLdAndLt = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT);
        System.out.println(ldtFromLdAndLt);

        //Tworzenie z godziną i minutą
        LocalDateTime ldtWithHM = LocalDateTime.of(2012, 12, 1, 10, 10);
        System.out.println(ldtWithHM);

        //Tworzenie z godziną i minutą i sekundą
        LocalDateTime ldtWithHMS = LocalDateTime.of(2012, 12, 1, 10, 10,10);
        System.out.println(ldtWithHMS);

        //Tworzenie z godziną i minutą, sekundą i nanosekundą
        LocalDateTime ldtWithHMSN = LocalDateTime.of(2012, 12, 1, 10, 10,10,10);
        System.out.println(ldtWithHMSN);

        //Tworzenie z godziną i minutą (miesiąc jako enum)
        LocalDateTime ldtWithHMEnumMonth = LocalDateTime.of(2012, Month.JANUARY, 1, 10, 10);
        System.out.println(ldtWithHM);

        //Tworzenie z godziną i minutą i sekundą (miesiąc jako enum)
        LocalDateTime ldtWithHMSEnumMonth = LocalDateTime.of(2012, Month.JANUARY, 1, 10, 10,10);
        System.out.println(ldtWithHMS);

        //Tworzenie z godziną i minutą, sekundą i nanosekundą (miesiąc jako enum)
        LocalDateTime ldtWithHMSNEnumMonth = LocalDateTime.of(2012, Month.JANUARY, 1, 10, 10,10,10);
        System.out.println(ldtWithHMSN);

        //Tworzenie z kolejnej sekundy i nanosekund epoch
        LocalDateTime ldtOfEpoch = LocalDateTime.ofEpochSecond(123000, 333000, ZoneOffset.UTC);
        System.out.println(ldtOfEpoch);

        //Tworzenie z kolejnej sekundy i nanosekund epoch - z przesunięciem
        LocalDateTime ldtOfEpochWithZoneOffse = LocalDateTime.ofEpochSecond(123000, 333000, ZoneOffset.MAX);
        System.out.println(ldtOfEpochWithZoneOffse);

        //Parsowanie stringa
        LocalDateTime ldtParse = LocalDateTime.parse("2016-01-04T08:10");
        System.out.println(ldtParse);

        //Poniższe rzuci parse exception - nie można parsować do LocalDateTime samej daty
        //LocalDateTime ldtParseEx = LocalDateTime.parse("2016-01-04");

    }

    //Przygotowywanie dat LocalDate
    private static void prepareDatesWithLocalDate() {
        System.out.println("Tworzenie LocalDate");

        //tworzenie z liczbowym miesiącem
        LocalDate ldNumMonth = LocalDate.of(2012, 2, 12);
        System.out.println(ldNumMonth);

        //tworzenie daty z miesiącem z enum
        LocalDate ldContsMont = LocalDate.of(2012, Month.FEBRUARY, 12);
        System.out.println(ldNumMonth);

        //tworzenie dzisiejszej daty
        LocalDate ldNow = LocalDate.now();
        System.out.println(ldNow);

        //z epochDay
        LocalDate ldFromEpoch = LocalDate.ofEpochDay(0);
        System.out.println(ldFromEpoch);

        //tworzenie z dnia w roku
        LocalDate ldFromDayOfYear = LocalDate.ofYearDay(2012, 200);
        System.out.println(ldFromDayOfYear);

        //Parsowanie łańcucha znaków
        LocalDate ldParseFromString = LocalDate.parse("2012-01-03");
        System.out.println(ldParseFromString);
    }
}
