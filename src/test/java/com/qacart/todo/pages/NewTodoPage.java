package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy (xpath = "//input[@data-testid='new-todo']")
//    private WebElement taskInput;
    private By taskIdBy = By.xpath("//input[@data-testid='new-todo']");
    //    @FindBy (xpath = "//button[@data-testid='submit-newTask']")
//    private WebElement submitButton;
    private By newTaskBy = By.xpath("//button[@data-testid='submit-newTask']");
    @Step("Add new task")

    public TodoPage addNewTodo(String item) {
        driver.findElement(taskIdBy).sendKeys(item);
        driver.findElement(newTaskBy).click();
        return new TodoPage(driver);

    }
    @Step("Load the login page")
public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoints.API_NEW_TODO_ENDPOINT);
        return this;
}
    public void SubmitButton() {
        driver.findElement(newTaskBy).click();
    }

}
