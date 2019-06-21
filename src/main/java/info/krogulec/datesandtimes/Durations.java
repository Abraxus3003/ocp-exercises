package info.krogulec.datesandtimes;

import java.time.Duration;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

public class Durations {

    public static void main(String[] args) {


        System.out.println("Duration.ofHours(12): " + Duration.ofHours(12));

        System.out.println("Duration.of(13, ChronoUnit.MINUTES): " + Duration.of(13, ChronoUnit.MINUTES));

        System.out.println("Duration.ofDays(12): " + Duration.ofDays(12) + " - ofDays() jest zamieniane na godziny!!!");

        try {
            System.out.println(Duration.from(Period.ofDays(123)));
        } catch (Exception e){
            System.out.println("Nie można łączyć Period i Duration");
        }

        System.out.println("Duration.ZERO.minus(Duration.of(200, ChronoUnit.MILLIS)): " + Duration.ZERO.minus(Duration.of(200, ChronoUnit.MILLIS)));

        System.out.println("Duration.parse(\"P1D\"): " + Duration.parse("P1D") + " Można parsować period do Duration, wle tylko w przypadku dni!");

        try {
            System.out.println("Duration.parse(11): " + Duration.parse("11"));
        } catch (Exception e){
            System.out.println("Duration.parse(11): Brak możliwości parsowania");
        }

        //Specyficzne zachowanie - w przypadku ChronoUnit.MINUTES mamy wyjątek
        System.out.println("Duration.ofMinutes(12).get(ChronoUnit.SECONDS): " + Duration.ofMinutes(12).get(ChronoUnit.SECONDS));

        try {
            System.out.println("Duration.ofMinutes(12).get(ChronoUnit.MONTHS): " + Duration.ofMinutes(12).get(ChronoUnit.MONTHS));
        } catch (UnsupportedTemporalTypeException e){
            System.out.println("EXCEPTION!!! = Duration.ofMinutes(12).get(ChronoUnit.DAYS): ");
        }


    }
}
