import org.json.JSONObject;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Scen1 {

    TestMethods api = new TestMethods();
    String id;

    @BeforeAll
    void setup() {
        JSONObject body = new JSONObject()
                .put("isbn", "978-" + System.currentTimeMillis())
                .put("title", "TestBook")
                .put("author", "QA")
                .put("price", 500);

        String resp = api.createBook(body);
        id = new JSONObject(resp).get("id").toString();
    }

    @Test
    void fullFlow() {

        api.getBookById(id);

        JSONObject patch = new JSONObject().put("price", 999);
        api.patchBook(id, patch);

        api.getStock(id);
    }

    @AfterAll
    void cleanup() {
        api.deleteBook(id);
    }
}