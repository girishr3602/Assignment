import com.assignment.qa.base.TestBase;
import com.assignment.qa.pages.HomePage;
import com.assignment.qa.pages.WeatherPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NDTVUITest extends TestBase {
    HomePage homePage;
    WeatherPage weatherPage;

    public NDTVUITest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
    }

    @Test
    public void getWeatherDetails(){
        String cityName = "allahabad";
        weatherPage = homePage.selectNavigation("WEATHER");
        weatherPage.searchAndSelectCity(cityName);
        Assert.assertTrue(weatherPage.validateCityVisiblityInMap(cityName));
        weatherPage.saveCityDetails(cityName);
    }

    @AfterMethod
    public void tearDown(){
        //driver.close();
        driver.quit();
    }

}
