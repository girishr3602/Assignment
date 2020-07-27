import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.LocationDetails;
import com.assignment.qa.pages.WeatherPage;
import com.assignment.qa.util.TemperatureType;
import com.assignment.qa.util.Utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NDTVAssignmentTest extends TestBase {
    HomePage homePage;
    WeatherPage weatherPage;

    public static final String cityName = "bengaluru";

    public NDTVAssignmentTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
    }

    //@Test
    public LocationDetails getWeatherDetailsByUI() {
        //String cityName = "bengaluru";
        weatherPage = homePage.selectNavigation();
        weatherPage.searchAndSelectCity(cityName);
        Assert.assertTrue(weatherPage.validateCityVisiblityInMap(cityName));
        LocationDetails locationDetails = weatherPage.saveCityDetails(cityName);
        return locationDetails;
    }

    //@Test
    public LocationDetails getWeatherDetailsByAPI() {
        Response response = NdtvApi.validateAPI(cityName);
        LocationDetails locationDetails = NdtvApi.saveWeatherDetailsByAPI(response);
        return  locationDetails;
    }

    @Test
    public void compareTemperature() {
        boolean bValue = Utils.temperatureComparator(getWeatherDetailsByUI(), getWeatherDetailsByAPI(), TemperatureType.DEGREES);
        System.out.println("bValue = " + bValue);
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
        driver.quit();
    }

}
