package ca.ulaval.glo2003.customer.api;

import java.util.List;

public class CustomerRequest {
    public String name;
    public String birthDate;
    public List<CustomerEmailDto> emails;
}
