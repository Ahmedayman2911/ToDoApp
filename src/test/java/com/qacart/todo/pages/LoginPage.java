package com.qacart.todo.pages;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(css = "#email")
//    private WebElement emailInput;
    private By emailBy = By.cssSelector("#email");
//    @FindBy(css = "#password")
//    private WebElement passwordInput;
    private  By passwordBy= By.cssSelector("#password");
//    @FindBy(xpath = "//*[@id=\"submit\"]/span[1]")
//    private WebElement submitButton;
    private By submitButtonBy=By.xpath("//*[@id=\"submit\"]/span[1]");
@Step("Load the login page")
public LoginPage load(){


    driver.get(ConfigUtils.getInstance().getBaseUrl());
    return this;
}
@Step
    public TodoPage Login(String email,String password){
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(submitButtonBy).click();
        return new  TodoPage(driver);
    }
}
