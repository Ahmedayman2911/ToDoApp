package com.qacart.todo.testCases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Tasks feature")
public class TodoTest extends BaseTest {

@Story("Add new task")
    @Test (description = "Should be able to add a new task correctly")
    public void shouldBeAbleToAddNewTask() {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = newTodoPage
                .load()
                .addNewTodo("Study Selenium")
                .getText();

        Assert.assertEquals(actualResult, "Study Selenium");


    }

@Story("Delete task")
    @Test (description = "Should be able to delete a task correctly")
    public void shouldBeAbleToDeleteTask() {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TasksApi tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getToken());
        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        boolean isNoTodosMessageDisplayed = todoPage
                .load()
                .deleteItem()
                .noTasksMessage();

        Assert.assertTrue(isNoTodosMessageDisplayed);

    }
}
