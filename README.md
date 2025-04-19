# Vacation Calculator

**Vacation Calculator** is a microservice built with **Spring Boot** and **Java 11** that provides a single API for calculating vacation days based on a 5/2 work schedule. The service takes into account the billing period for 2024 and adjusts the vacation day calculations based on the specified dates.

## API

### Endpoint

**GET /calculate**

### Query Parameters

- **averageSalary** (Double): Average salary for the month.
- **numberOfDays** (Integer): Number of vacation days.
- **startDate** (Optional, LocalDate): Vacation start date in `yyyy-MM-dd` format.
- **endDate** (Optional, LocalDate): Vacation end date in `yyyy-MM-dd` format.

### Calculation Logic

The calculation logic changes when two dates are specified. In this case, weekends and holidays are not paid.

## Requirements

- **Java 11**
- **Gradle**

## Installation

1. Clone the repository:

   ```bash
   git clone <repository-URL>
   cd <project-directory>

2. Build the project with Gradle:

gradle clean install

3. Run the application:

gradle spring-boot:run

### Testing
JUnit 5 is used for testing business logic. Example tests are in the VacationServiceTest class.



