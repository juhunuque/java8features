package java8features.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate : " + localDate);

        LocalDate localDate1 = LocalDate.of(2019, 07, 17);
        System.out.println("localDate1 : " + localDate1);

        LocalDate localDate2 = LocalDate.ofYearDay(2019, 344);
        System.out.println("localDate2 : " + localDate2);

        /**
         * Get values from localDate
         */

        System.out.println("Month : " + localDate.getMonth());
        System.out.println("Month Value : " + localDate.getMonthValue());
        System.out.println("getDayOfWeek : " + localDate.getDayOfWeek());
        System.out.println("getDayOfYear : " + localDate.getDayOfYear());
        System.out.println("get : " + localDate.get(ChronoField.DAY_OF_MONTH));

        /**
         * Modifying localDate
         */

        System.out.println("localDate.plusDays(2): " + localDate.plusDays(2));
        System.out.println("localDate.plusMonths(2): " + localDate.plusMonths(2));
        System.out.println("localDate.minusDays(2): " + localDate.minusDays(2));
        System.out.println("withYear: " + localDate.withYear(2020));
        System.out.println("with ChronoField: " + localDate.with(ChronoField.YEAR, 2021));
        System.out.println("with TemporalAdjusters: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println("minus ChronoUnit: " + localDate.minus(1, ChronoUnit.YEARS));


        /**
         * Additional Support methods
         */

        System.out.println("leapYear: " + localDate.isLeapYear());
        System.out.println("leapYear: " + localDate.ofYearDay(2020, 1).isLeapYear());

        System.out.println("isEqual: " + localDate.isEqual(localDate1));
        System.out.println("isBefore: " + localDate.isBefore(localDate1));
        System.out.println("isAfter: " + localDate.isAfter(localDate1));

        /**
         * Unsupported scenarios
         */
        System.out.println("isSupported: " + localDate.isSupported(ChronoUnit.YEARS));
        System.out.println("isSupported: " + localDate.isSupported(ChronoUnit.MINUTES));
//        System.out.println("minus ChronoUnit: " + localDate.minus(1, ChronoUnit.MINUTES));
    }
}
