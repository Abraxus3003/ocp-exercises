package info.krogulec.datesandtimes;

import java.io.IOException;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.*;
import java.util.concurrent.Executors;

public class Periods {

    public static void main(String[] args) {


        System.out.println("Period.ofYears(12): " + Period.ofYears(12));

        System.out.println("Period.of(12,22,33): " + Period.of(12,22,33));

        System.out.println("Period.ofWeeks(12): " + Period.ofWeeks(12) + " - jest zamieniane na dni!!!");

        try {
            System.out.println(Period.from(Duration.ofHours(123)));
        } catch (Exception e){
            System.out.println("Nie można łączyć Period i Duration");
        }

        System.out.println("Period.ZERO.minus(Period.of(10,1,12)): " + Period.ZERO.minus(Period.of(10,1,12)));

        System.out.println("Period.parse(\"P12Y\"): " + Period.parse("P12Y"));

        try {
            System.out.println("Period.parse(11): " + Period.parse("11"));
        } catch (Exception e){
            System.out.println("Period.parse(11): Brak możliwości parsowania");
        }

        System.out.println("Period.ofYears(12).get(ChronoUnit.DAYS): " + Period.ofYears(12).get(ChronoUnit.DAYS) + " !!!Poszczególne części nie są przeliczane na inne!!!");

        try {
            System.out.println("Period.ofYears(12).get(ChronoUnit.MILLIS): " + Period.ofYears(12).get(ChronoUnit.MILLIS));
        } catch (UnsupportedTemporalTypeException e){
            System.out.println("EXCEPTION!!! = Period.ofYears(12).get(ChronoUnit.MILLIS): ");
        }


    }
}
