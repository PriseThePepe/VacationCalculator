package com.example.demo.service;

import com.example.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class VacationService {

    // Number of working days with 5/2 schedule in 2025
    private final int WORK_DAYS_IN_YEAR = 248;

    private final int MONTHS_IN_A_YEAR = 12;

    public double calculateVacationPay(double validAverageSalary,
                                       Integer validVacationDays,
                                       LocalDate validStartDate, LocalDate validEndDate) {

        double averageSalaryForYear = validAverageSalary * MONTHS_IN_A_YEAR;

        double dailySalary = averageSalaryForYear / WORK_DAYS_IN_YEAR;

        double vacationPay = dailySalary * validVacationDays;

        if(validStartDate !=null && validEndDate != null) {
            int actualVacationDays = DateUtils.getNumberOfWorkingDaysByDates(validStartDate, validEndDate);
            vacationPay = dailySalary * actualVacationDays;
        }
        return vacationPay;
    }
}
