package ca.ulaval.glo2003.customer.logic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public record Customer(
        String id,
        String name,
        LocalDate birthDate,
        Map<EmailType, Email> emails
) {
    public int age() {
        return (int)ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
