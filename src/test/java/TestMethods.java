import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestMethods {

    private static final String BASE_URL = "http://10.82.196.214:8085";
    private static final String API_KEY = "bookstore-2026-secret";

    // -------- GET --------

    public String getBookById(String id) {
        return given()
                .pathParam("id", id)
                .when()
                .get(BASE_URL + "/books/{id}")
                .then()
                .statusCode(200)
                .extract().asString();
    }

    public String getStock(String id) {
        return given()
                .pathParam("id", id)
                .when()
                .get(BASE_URL + "/books/{id}/stock")
                .then()
                .statusCode(200)
                .extract().asString();
    }

    public String getAllBooks(Map<String, Object> params) {
        return given()
                .queryParams(params)
                .when()
                .get(BASE_URL + "/books")
                .then()
                .statusCode(200)
                .extract().asString();
    }

    // -------- POST --------

    public String createBook(JSONObject body) {
        return given()
                .header("X-API-Key", API_KEY)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when()
                .post(BASE_URL + "/books")
                .then()
                .statusCode(201)
                .extract().asString();
    }

    public String addReview(String id, JSONObject body) {
        return given()
                .header("X-API-Key", API_KEY)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(body.toString())
                .when()
                .post(BASE_URL + "/books/{id}/reviews")
                .then()
                .statusCode(201)
                .extract().asString();
    }

    // -------- PATCH --------

    public String patchBook(String id, JSONObject body) {
        return given()
                .header("X-API-Key", API_KEY)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(body.toString())
                .when()
                .patch(BASE_URL + "/books/{id}")
                .then()
                .statusCode(200)
                .extract().asString();
    }

    // -------- DELETE --------

    public void deleteBook(String id) {
        given()
                .header("X-API-Key", API_KEY)
                .pathParam("id", id)
                .when()
                .delete(BASE_URL + "/books/{id}")
                .then()
                .statusCode(204);
    }
}