import org.json.JSONObject;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Scen2 {

    TestMethods api = new TestMethods();
    String id;

    @BeforeAll
    void setup() {
        JSONObject body = new JSONObject()
                .put("isbn", "978-" + System.currentTimeMillis())
                .put("title", "ReviewBook")
                .put("author", "QA")
                .put("price", 300);

        String resp = api.createBook(body);
        id = new JSONObject(resp).get("id").toString();
    }

    @Test
    void reviewFlow() {

        api.getStock(id);

        JSONObject review = new JSONObject()
                .put("rating", 5);

        api.addReview(id, review);
    }

    @AfterAll
    void cleanup() {
        api.deleteBook(id);
    }
}