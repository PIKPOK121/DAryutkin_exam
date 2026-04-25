import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class Scen1 {

    TestMethods api = new TestMethods();
    static String id;
    static String isbn;

    @Test
    @Order(1)
    void createBook() {
        isbn = "978-" + System.currentTimeMillis();

        JSONObject body = new JSONObject()
                .put("isbn", isbn)
                .put("title", "Book1")
                .put("author", "QA")
                .put("price", 500);

        String resp = api.createBook(body);
        id = new JSONObject(resp).get("id").toString();
    }

    @Test
    @Order(2)
    void getBook() {
        api.getBookById(id);
    }

    @Test
    @Order(3)
    void patchBook() {
        JSONObject patch = new JSONObject()
                .put("price", 999);

        api.patchBook(id, patch);
    }

    @Test
    @Order(4)
    void checkStock() {
        api.getStock(id);
    }

    @Test
    @Order(5)
    void deleteBook() {
        api.deleteBook(id);
    }
}