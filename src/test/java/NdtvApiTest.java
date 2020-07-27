import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NdtvApiTest {

    @Test
    public void validateAPI(){
        Response response = given()
                .baseUri("https://api.openweathermap.org")
                .queryParam("q","Bengaluru")
                .queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea")
                .log().all()
        .when()
                .get("/data/2.5/weather")
        .andReturn();

        System.out.println(response.asString());
        System.out.println(response.getStatusCode());

        JsonPath jsonPath = new JsonPath(response.asString());
        //jsonPath.get("coord");
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getString("coord.lon"));

    }

}