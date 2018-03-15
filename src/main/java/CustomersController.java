import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Address;
import models.Customer;
import models.CustomerEngagement;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;

public class CustomersController {
    private static final Logger LOGGER
            = Logger.getLogger(CustomersController.class.getName());

    private final ObjectMapper mapper;
    private final Map<String, Customer> customers;

    public CustomersController() {
        this.mapper = new ObjectMapper();
        this.customers = new HashMap<>();
        init();
    }

    public String getScan(
            final Request request,
            final Response response) {
        final String id = request.params(":id");
        final Customer customer = customers.get(id);
        if (customer == null) {
            LOGGER.log(Level.WARNING, "Customer not found: " + id);
            halt(404, "Not found");
        }
        return dataToJson(customer);
    }

    private void init() {
        final String customerId = "12345678901";
        final Address address = new Address(
                "Dronning Eufemias gate 30",
                "c/o CEO office",
                "string",
                "0191",
                "Oslo",
                "NO"
        );
        final CustomerEngagement customerEngagement = new CustomerEngagement(
                "12345",
                "DEPOSIT",
                "12345678901",
                "SAGA MasterCard",
                true
        );
        final String[] countryCitizenships = {"NO"};
        final String[] countryTax = {"NO"};
        final Customer customer = new Customer(
                customerId,
                "PERSON",
                "Rune",
                "Bjerke",
                "DNB",
                address,
                "example@example.com",
                "+4791504800",
                "NO",
                countryCitizenships,
                countryTax,
                customerEngagement
        );
        this.customers.put(customerId, customer);
    }

    private String dataToJson(final Object data) {
        try {
            final StringWriter sw = new StringWriter();
            mapper.writerWithDefaultPrettyPrinter().writeValue(sw, data);
            return sw.toString();
        } catch (final IOException e){
            LOGGER.log(
                    Level.WARNING,
                    "Could not convert data to JSON String.",
                    e);
            halt(500);
            return null;
        }
    }
}
