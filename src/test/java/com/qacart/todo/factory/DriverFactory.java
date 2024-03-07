package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver initializedDriver() {
        String browser = System.getProperty("browser","FIREFOX");

        WebDriver driver;
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                  driver = new  SafariDriver();
               break;
            case "EDGE": WebDriverManager.edgedriver().setup();
              driver = new EdgeDriver();
            break;
            default:
                throw new RuntimeException("The browser is not supported");
        }

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

}
