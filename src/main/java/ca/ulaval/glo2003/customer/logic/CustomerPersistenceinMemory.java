package ca.ulaval.glo2003.customer.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerPersistenceinMemory implements CustomerPersistence{
    private final Map<String, Customer> customers = new HashMap<>();

    public List<Customer> listAll() {
        return customers.values().stream().toList();
    }

    public void save(Customer customer) {
        customers.put(customer.id(), customer);
    }
}
