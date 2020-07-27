package com.assignment.qa.pages;

import com.assignment.qa.base.TestBase;
import com.assignment.qa.util.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends TestBase {
    private WebDriverWait wait;
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

    @FindBy(id = "__cricketsubscribe")
    WebElement notification;

    public WeatherPage selectNavigation() {
        extraIcon.click();
        weather.click();
        return new WeatherPage();
    }
}
