package com.assignment.qa.base;

import com.assignment.qa.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = null;
    public static Properties properties;
    public static WebDriverWait wait;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/config/config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String OS_NAME = System.getProperty("os.name").toLowerCase();
        //System.out.println(OS_NAME);
        if (OS_NAME.contains("windows")) {
            String browser = properties.getProperty("browser");
            if ("chrome".equals(browser)) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if ("opera".equals(browser)) {
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/operadriver.exe");
                driver = new OperaDriver();
            }
        } else if (OS_NAME.contains("mac")) {
            String browser = properties.getProperty("browser");
            if ("chrome".equals(browser)) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/geckodriver");
                driver = new FirefoxDriver();
            } else if ("opera".equals(browser)) {
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/src/main/java/com/assignment/qa/drivers/operadriver");
                driver = new OperaDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("loginurl"));
    }
}
