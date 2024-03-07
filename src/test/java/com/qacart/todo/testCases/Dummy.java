//package com.qacart.todo.testCases;
//
//
//import com.qacart.todo.api.RegisterApi;
//import com.qacart.todo.utils.ConfigUtils;
//import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.Cookie;
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//
//import java.util.List;
//
//public class Dummy {
//    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
//
//        driver.get(ConfigUtils.getInstance().getBaseUrl());
//        driver.manage().window().maximize();
//        RegisterApi registerApi = new RegisterApi();
//        registerApi.register();
//
//        List<io.restassured.http.Cookie> restAssuredCookies = registerApi.getCookies();
//        for (io.restassured.http.Cookie cookie : restAssuredCookies)
//         {
//            Cookie seleniumCookie = new Cookie(cookie.getName(),cookie.getValue());
//            driver.manage().addCookie(seleniumCookie);
//        }
//
//        driver.get(ConfigUtils.getInstance().getBaseUrl());
//        Thread.sleep(60000);
//        driver.quit();
//    }
//}
