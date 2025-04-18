package com.example.demo.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DateUtils {


    public static int getNumberOfWorkingDaysByDates(LocalDate startDate, LocalDate endDate) {

        Set<LocalDate> holidays = getHolidays(startDate, endDate);


        return (int) Stream
                .iterate(startDate, date -> !date.isAfter(endDate), date -> date.plusDays(1))
                .filter(date -> isWorkingDay(date, holidays))
                .count();
    }


    private static boolean isWorkingDay(LocalDate date, Set<LocalDate> holidays) {
        return !(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || holidays.contains(date));
    }

    private static Set<LocalDate> getHolidays(LocalDate startDate,LocalDate endDate) {

        Set<LocalDate> holidays = new HashSet<>();

        int[][] holidayDates = {
                {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8},
                {2, 23}, {3, 8}, {5, 1}, {5, 9}, {6, 12}, {11, 4}
        };

        for (int[] holiday : holidayDates) {
            LocalDate holidayDate = LocalDate.of(startDate.getYear(), holiday[0], holiday[1]);

            if (!holidayDate.isBefore(startDate) && !holidayDate.isAfter(endDate)) {
                holidays.add(holidayDate);
            }
        }

        return holidays;
    }


}
