package info.krogulec.datesandtimes;

import java.time.*;

public class Instants {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(2013,1,11, 14, 28), ZoneId.of("US/Eastern"));

        //toInstant przerabia datę na uniwersalny punkt w czasie
        Instant instant = zonedDateTime.toInstant();

        System.out.println(instant);

        LocalDateTime localDateTime = LocalDateTime.now();

        //przy localdateTome przeba podać zone offset
        Instant instant1 = localDateTime.toInstant(ZoneOffset.UTC);

        System.out.println(instant1);

    }
}
