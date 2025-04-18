package com.example.demo.validation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class VacationInputValidator {
    public static Double validateAverageSalary(Double averageSalary) {
        if (averageSalary == null || averageSalary <= 0) {
            throw new IllegalArgumentException("Average salary must be greater than zero.");
        } else {
            return averageSalary;
        }
    }

    public static Integer validateVacationDays(Integer vacationDays) {
        if(vacationDays == null || vacationDays <= 0) {
            throw new IllegalArgumentException("Vacation days must be grater than zero");
       } else {
            return vacationDays;
        }

    }

    public static LocalDate validateDate(String date) {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
               throw new IllegalArgumentException("Invalid date format for start or end date. Please use 'yyyy-MM-dd'.");
        }
    }
}


