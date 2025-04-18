package com.example.demo.controller;

import com.example.demo.service.VacationService;
import com.example.demo.validation.VacationInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDate;

@RestController
public class VacationCalculatorController {

    private final VacationService vacationService;

    @Autowired
    public VacationCalculatorController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam Double averageSalary,
                            @RequestParam Integer vacationDays,
                            @RequestParam(required = false) String startDate,
                            @RequestParam(required = false) String endDate) {

        Double validAverageSalary = VacationInputValidator.validateAverageSalary(averageSalary);
        Integer validVacationDays = VacationInputValidator.validateVacationDays(vacationDays);
        LocalDate validStartDate = null;
        LocalDate validEndDate = null;

        if(startDate != null && endDate != null) {
            validStartDate = VacationInputValidator.validateDate(startDate);
            validEndDate = VacationInputValidator.validateDate(endDate);
        }



        double vacationPay = vacationService.calculateVacationPay(validAverageSalary,
                                                                    validVacationDays,
                                                                    validStartDate ,validEndDate );

        //Format a number with thousands separators and 2 decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

        return decimalFormat.format(vacationPay);
    }
}

