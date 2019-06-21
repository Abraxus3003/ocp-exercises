package info.krogulec.datesandtimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DaylightSavings {

    public static void main(String[] args) {
        summerTime();

        winterTime();

    }

    private static void winterTime() {
        LocalDate daylightSavingPl = LocalDate.of(2018, 10, 28);

        LocalTime changeTime = LocalTime.of(2, 00);
        ZonedDateTime time = ZonedDateTime.of(daylightSavingPl, changeTime, ZoneId.systemDefault());

        System.out.println(time);

        ZonedDateTime zonedDateTimeAddedHour = time.plusHours(1);

        //po dodaniu godziny mamy dalej 2:00
        System.out.println(zonedDateTimeAddedHour);
    }

    private static void summerTime() {
        LocalDate daylightSavingPl = LocalDate.of(2019, 3, 31);

        // 2:00 jest automatycznie zamieniana na 3:00
        LocalTime changeTime = LocalTime.of(2, 00);
        ZonedDateTime time = ZonedDateTime.of(daylightSavingPl, changeTime, ZoneId.systemDefault());

        //po wpisaniu godziny 2:00 may 3:00
        System.out.println(time);

        ZonedDateTime zonedDateTimeAddedHour = time.plusHours(1);

        //po dodaniu godziny mamy 4:00
        System.out.println(zonedDateTimeAddedHour);
    }
}
