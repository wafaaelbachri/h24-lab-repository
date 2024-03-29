package ca.ulaval.glo2003;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.filters.Filter;
import dev.morphia.query.filters.Filters;

import java.util.Optional;

/**
 * @class MorphiaTest
 * @brief This class is used for testing Morphia, a Java library for mapping Java objects to MongoDB.
 */
public class MorphiaTest {

    /**
     * @brief The main method to run the Morphia test.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Define the MongoDB connection URL
        var mongoUrl = "mongodb://root:example@localhost:27017";

        // Create a Morphia Datastore using the MongoDB client and specify the database name
        final Datastore datastore = Morphia.createDatastore(MongoClients.create(mongoUrl), "restalo");

        // Create a new customer object
        var customer = new CustomerMongo("Fatima");


        // Save the customer object to the datastore
        datastore.save(customer);
        var query = datastore.find(CustomerMongo.class).filter(
                Filters.eq("_id", "abc")
        );
        var foundcustomers = Optional.ofNullable(query.iterator().tryNext());
        System.out.println(foundcustomers);
    }
}
