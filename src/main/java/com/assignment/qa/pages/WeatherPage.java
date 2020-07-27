package com.assignment.qa.pages;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WeatherPage extends TestBase {
    private static WebDriverWait wait;
    public WeatherPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "logo")
    WebElement ndtvWeatherLogo;

    @FindBy(xpath = "//*[@class='searchBox']")
    WebElement citySearch;

    @FindBy(xpath = "//*[@class='messages']")
    WebElement filteredLocation;

    @FindBy(xpath = "//*[@class='message']/label")
    List<WebElement> searchedLocation;

    @FindBy(xpath = "//*[@class='message']/label/input")
    List<WebElement> checkbox;

    @FindBy(xpath = "//*[@class='cityText']")
    List<WebElement> visibleCityList;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/div/span[2]")
    WebElement popupName;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/span[1]/b")
    WebElement popupCondition;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/span[2]/b")
    WebElement popupWind;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/span[3]/b")
    WebElement popupHumidity;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/span[4]/b")
    WebElement popupTempInDegrees;

    @FindBy(xpath = "//*[@class='leaflet-popup-content']/div/span[5]/b")
    WebElement popupTempInFahrenheit;

    public void searchAndSelectCity(String citySearchName){
        wait = new WebDriverWait(driver, Utils.EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(citySearch));
        citySearch.clear();
        citySearch.sendKeys(citySearchName);

        for (int i = 0; i < searchedLocation.size(); i++) {
            if(searchedLocation.get(i).getText().toLowerCase().contains(citySearchName)){
                if(checkbox.get(i).isSelected()){
                    break;
                } else {
                    searchedLocation.get(i).click();
                    //System.out.println("Check box selected: " + checkbox.get(i).isSelected());
                }
                break;
            }
        }

    }

    public boolean validateCityVisiblityInMap(String cityName){
        boolean bValue = false;
        for (int i = 0; i < visibleCityList.size(); i++) {
            if(visibleCityList.get(i).getText().equalsIgnoreCase(cityName)){
                return true;
            }
        }
        return false;
    }

    public void saveCityDetails(String cityName){
        for (int i = 0; i < visibleCityList.size(); i++) {
            if(visibleCityList.get(i).getText().equalsIgnoreCase(cityName)){
                visibleCityList.get(i).click();
            }
        }

        String name =  popupName.getText();
        String condition = popupCondition.getText().split(": ")[1];
        String windDetails = popupWind.getText().split(": ")[1];
        String humidity = popupHumidity.getText().split(": ")[1];
        String tempInDegrees = popupTempInDegrees.getText().split(": ")[1];
        String tempInFrahrenheit = popupTempInFahrenheit.getText().split(": ")[1];

        LocationDetails locationDetails = new LocationDetails(name, condition, windDetails, humidity, tempInDegrees, tempInFrahrenheit);

        System.out.println("*********Before Name Set*********");
        System.out.println("name = " + name);
        System.out.println("condition = " + condition);
        System.out.println("windDetails = " + windDetails);
        System.out.println("humidity = " + humidity);
        System.out.println("tempInDegrees = " + tempInDegrees);
        System.out.println("tempInFrahrenheit = " + tempInFrahrenheit);


        System.out.println("*********After Name Set*********");
        System.out.println("name = " + locationDetails.getName());
        System.out.println("condition = " + locationDetails.getCondition());
        System.out.println("windDetails = " + locationDetails.getWindDetails());
        System.out.println("humidity = " + locationDetails.getHumidity());
        System.out.println("tempInDegrees = " + locationDetails.getTemperatureInDegrees());
        System.out.println("tempInFrahrenheit = " + locationDetails.getTemperatureInFahrenheit());
    }
}
