package com.assignment.qa.pages;

import com.assignment.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    /* Page Factory -- Object Repository */
    @FindBy(xpath = "//*[@class='topnav_cont'][2]")
    List <WebElement> topNavList;

    @FindBy(xpath = "//*[@class='topnav_extra']//*[@class='topnavmore']")
    WebElement extraIcon;

    @FindBy(xpath = "//*[contains(text(),'WEATHER')]")
    WebElement weather;

    @FindBy(xpath = "//*[@class='ndtvlogo']")
    WebElement ndtvLogo;

    public WeatherPage selectNavigation(String navItemName){
        extraIcon.click();
        weather.click();
        return new WeatherPage();
    }
}
