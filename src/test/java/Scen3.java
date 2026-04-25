import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(OrderAnnotation.class)
public class Scen3 {

    TestMethods api = new TestMethods();

    @Test
    @Order(1)
    void filterGenre() {
        Map<String, Object> p = new HashMap<>();
        p.put("genre", "Classic");

        api.getAllBooks(p);
    }

    @Test
    @Order(2)
    void pagination() {
        Map<String, Object> p = new HashMap<>();
        p.put("page", 0);
        p.put("size", 5);

        api.getAllBooks(p);
    }

    @Test
    @Order(3)
    void filterPrice() {
        Map<String, Object> p = new HashMap<>();
        p.put("minPrice", 100);
        p.put("maxPrice", 600);

        api.getAllBooks(p);
    }
}