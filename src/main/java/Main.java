import spark.Spark;

import static spark.Spark.port;

public class Main {

    public static void main(final String[] args) {
        port(8080);
        final CustomersController customersController = new CustomersController();
        Spark.get("/customers/:id", (req, res) -> customersController.getScan(req, res));
        Spark.awaitInitialization();
    }
}
