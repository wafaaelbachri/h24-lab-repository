package ca.ulaval.glo2003;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

@Entity("customer")
public class CustomerMongo {
    @Id
   public  String id;
    public CustomerMongo(){}
    public CustomerMongo(String id) {
        this.id = id;
    }
}
