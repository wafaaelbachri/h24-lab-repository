package ca.ulaval.glo2003;

import ca.ulaval.glo2003.customer.api.CustomerApi;
import ca.ulaval.glo2003.customer.api.CustomerMapper;
import ca.ulaval.glo2003.customer.logic.CustomerFactory;
import ca.ulaval.glo2003.customer.logic.CustomerPersistence;
import ca.ulaval.glo2003.customer.logic.CustomerPersistenceMongo;
import ca.ulaval.glo2003.customer.logic.CustomerPersistenceinMemory;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://0.0.0.0:8080/";

    public static HttpServer startServer() {
        CustomerPersistence customerPersistence = new CustomerPersistenceMongo();
        var customerApi = new CustomerApi(new CustomerFactory(), customerPersistence , new CustomerMapper());

        final ResourceConfig rc = new ResourceConfig()
                .register(customerApi);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        startServer();
        System.out.printf("Jersey app started with endpoints available at %s%n", BASE_URI);
    }
}
