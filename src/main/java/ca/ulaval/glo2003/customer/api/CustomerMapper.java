package ca.ulaval.glo2003.customer.api;

import ca.ulaval.glo2003.customer.logic.Customer;

public class CustomerMapper {
    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.id(),
                customer.name(),
                customer.age(),
                customer.emails()
                        .entrySet()
                        .stream()
                        .map(email -> new CustomerEmailDto(email.getKey().name().toLowerCase(), email.getValue().toString()))
                        .toList()
        );
    }
}
