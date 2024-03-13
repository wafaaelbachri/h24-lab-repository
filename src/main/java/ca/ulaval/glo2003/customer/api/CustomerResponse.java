package ca.ulaval.glo2003.customer.api;

import java.util.List;

public record CustomerResponse(
        String id,
        String name,
        int age,
        List<CustomerEmailDto> emails
) {}
