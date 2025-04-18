package com.example.demo;

import com.example.demo.service.VacationService;

import com.example.demo.util.DateUtils;
import com.example.demo.validation.VacationInputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationServiceTest {

    private VacationService vacationService;

    private final int WORK_DAYS_IN_YEAR = 248;

    private final int MONTHS_IN_A_YEAR = 12;

    @BeforeEach
    public void setUp() {
        vacationService = new VacationService();
    }

    @Test
    public void testCalculateVacationPayWithVacationsDays() {
        double averageSalary = 40000;
        int vacationDays = 10;

        double dailySalary = (averageSalary * MONTHS_IN_A_YEAR) / WORK_DAYS_IN_YEAR;
        double expected = dailySalary * vacationDays;
        double actual = vacationService.calculateVacationPay(averageSalary,
                vacationDays,
                null,
                null);

        assertEquals(expected, actual, 0.01);
    }
    @Test
    public void testCalculateVacationPayWithDates() {
        double averageSalary = 40000;

        double dailySalary = (averageSalary * MONTHS_IN_A_YEAR) / WORK_DAYS_IN_YEAR;
        int actualVacationsDays = DateUtils.getNumberOfWorkingDaysByDates(LocalDate.parse("2025-01-01"),
                LocalDate.parse("2025-01-14"));
        double expected = dailySalary * actualVacationsDays;
        double actual = vacationService.calculateVacationPay(averageSalary,0,
                VacationInputValidator.validateDate("2025-01-01"),
                VacationInputValidator.validateDate("2025-01-14"));
        assertEquals(expected,actual,0.01);

    }
}
