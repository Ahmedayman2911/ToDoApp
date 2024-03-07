package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }


    private By welcomeMessageBy = By.xpath("//h2[@data-testid=\"welcome\"]");

    private By addButtonBy = By.xpath("//button[@aria-label=\"delete\"]");

    private By todoItemBy = By.xpath("//h2[@data-testid='todo-text']");

    private By deleteItemBy = By.cssSelector("[data-testid=\"delete\"]");

    private By noTasksMessageBy = By.xpath("//h4[@data-testid=\"no-todos\"]");

    private By taskTextBy = By.xpath("//h2[@data-testid=\"todo-text\"]");
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoints.TODO_PAGE_ENDPOINT);
        return this;

    }
    @Step
    public boolean isWelcomeMessageIsDisplayed() {
        return driver.findElement(welcomeMessageBy).isDisplayed();
    }

    public NewTodoPage ClickAddButton() {
        driver.findElement(addButtonBy).click();
        return new NewTodoPage(driver);
    }

    public String getText() {
        return driver.findElement(todoItemBy).getText();
    }
    @Step
    public TodoPage deleteItem() {
        driver.findElement(deleteItemBy).click();
        return this;
    }
    @Step
    public String getTaskText() {
        return driver.findElement(taskTextBy).getText();
    }
    @Step
    public boolean noTasksMessage() {
        return driver.findElement(noTasksMessageBy).isDisplayed();
    }

}
