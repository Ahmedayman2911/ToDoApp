package com.qacart.todo.testCases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth feature")
public class LoginTest extends BaseTest {
    @Story("Login with email and password")
    @Description("It will login by filling the email and password then navigate to the next page 'Todo Page' ")
    @Test(description = "Test the login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        boolean isWelcome =
                loginPage
                        .load()
                        .Login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .isWelcomeMessageIsDisplayed();

        Assert.assertTrue(isWelcome);

    }
}
