import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Scen3 {

    TestMethods api = new TestMethods();

    @Test
    void filters() {

        Map<String, Object> genre = new HashMap<>();
        genre.put("genre", "Classic");
        api.getAllBooks(genre);

        Map<String, Object> page = new HashMap<>();
        page.put("page", 0);
        page.put("size", 5);
        api.getAllBooks(page);

        Map<String, Object> price = new HashMap<>();
        price.put("minPrice", 100);
        price.put("maxPrice", 600);
        api.getAllBooks(price);
    }
}