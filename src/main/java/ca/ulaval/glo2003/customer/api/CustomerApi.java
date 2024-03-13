package ca.ulaval.glo2003.customer.api;

import ca.ulaval.glo2003.customer.logic.CustomerFactory;
import ca.ulaval.glo2003.customer.logic.CustomerPersistence;
import ca.ulaval.glo2003.customer.logic.Email;
import ca.ulaval.glo2003.customer.logic.EmailType;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Path("/customers")
public class CustomerApi {

    private final CustomerFactory customerFactory;
    private final CustomerPersistence customerPersistence;
    private final CustomerMapper customerMapper;

    public CustomerApi(CustomerFactory customerFactory, CustomerPersistence customerPersistence, CustomerMapper customerMapper) {
        this.customerFactory = customerFactory;
        this.customerPersistence = customerPersistence;
        this.customerMapper = customerMapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listCustomers() {
        var customers = customerPersistence.listAll().stream().map(customerMapper::toResponse).toList();
        return Response.ok(customers).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(CustomerRequest request) {
        // Défi : pouvez-vous nettoyer ça?
        var emails = request.emails.stream().collect(Collectors.toMap(dto -> EmailType.parse(dto.type()), dto -> new Email(dto.value()), (existing, replacement) -> existing));
        var customer = customerFactory.create(
                request.name,
                LocalDate.parse(request.birthDate, DateTimeFormatter.ISO_LOCAL_DATE),
                emails
        );

        customerPersistence.save(customer);

        return Response.created(URI.create(String.format("/customers/%s", customer.id()))).build();
    }
}
