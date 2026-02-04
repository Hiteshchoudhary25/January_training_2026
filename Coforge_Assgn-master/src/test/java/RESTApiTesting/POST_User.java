package RESTApiTesting;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class POST_User {

    @Test
    public void post() {

        baseURI = "https://api.restful-api.dev";

        String payload = "{\n" +
                "  \"name\": \"Ansh MacBook Pro 16\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2019,\n" +
                "    \"price\": 1849.99,\n" +
                "    \"CPU model\": \"Intel Core i9\",\n" +
                "    \"Hard disk size\": \"1 TB\"\n" +
                "  }\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post("/objects")
        .then()
            .statusCode(anyOf(is(200), is(201)))
            .body("id", notNullValue())
            .body("name", equalTo("Apple MacBook Pro 16"))
            .log().all();
    }
}
