import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class Scen2 {

    TestMethods api = new TestMethods();
    static String id;

    @Test
    @Order(1)
    void createBook() {
        JSONObject body = new JSONObject()
                .put("isbn", "978-" + System.currentTimeMillis())
                .put("title", "ReviewBook")
                .put("author", "QA")
                .put("price", 300);

        String resp = api.createBook(body);
        id = new JSONObject(resp).get("id").toString();
    }

    @Test
    @Order(2)
    void checkStock() {
        api.getStock(id);
    }

    @Test
    @Order(3)
    void addReview() {
        JSONObject review = new JSONObject()
                .put("rating", 5);

        api.addReview(id, review);
    }

    @Test
    @Order(4)
    void deleteBook() {
        api.deleteBook(id);
    }
}