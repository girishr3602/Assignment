import com.assignment.qa.pages.LocationDetails;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class NdtvApiTest {

    public static Response validateAPI(){
        Response response = given()
                .baseUri("https://api.openweathermap.org")
                .queryParam("q","Bengaluru")
                .queryParam("units","metric")
                .queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea")
                .log().all()
        .when()
                .get("/data/2.5/weather")
        .andReturn();
        return response;
    }

    public static LocationDetails saveWeatherDetailsByAPI(Response response) {
        JsonPath jsonPath = new JsonPath(response.asString());
        String name = jsonPath.getString("name");
        String condition = jsonPath.getString("weather[0].main");
        String windDetails = jsonPath.getString("wind.speed");
        String humidity = jsonPath.getString("main.humidity");
        String tempInDegrees = jsonPath.getString("main.temp");
        LocationDetails locationDetails = new LocationDetails(name, condition, windDetails, humidity, tempInDegrees);
        return locationDetails;
    }

}