package ca.ulaval.glo2003.customer.logic;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class DatastoreProvider {
    public Datastore provide(){
        var mongoUrl = "mongodb://root:example@localhost:27017";

        // Create a Morphia Datastore using the MongoDB client and specify the database name
       return Morphia.createDatastore(MongoClients.create(mongoUrl), "restalo");

    }
}
