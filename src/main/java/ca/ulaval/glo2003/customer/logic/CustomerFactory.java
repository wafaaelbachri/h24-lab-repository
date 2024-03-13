package ca.ulaval.glo2003.customer.logic;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class CustomerFactory {
    public Customer create(String name, LocalDate birthDate, Map<EmailType, Email> emails) {
        return new Customer(UUID.randomUUID().toString(), name, birthDate, emails);
    }
}
