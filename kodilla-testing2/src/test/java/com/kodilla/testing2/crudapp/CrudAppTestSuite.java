package com.kodilla.testing2.crudapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing2.config.WebDriverConfig;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://sebek9.github.io/";
    private WebDriver driver;
    private Random generator;

    private WebDriverWait wait;

    @Before
    public void initTests(){
         driver= WebDriverConfig.getDriver(WebDriverConfig.CHROME);
            driver.get(BASE_URL);
            generator=new Random();
    }

    @After
    public void cleanUpAfterTest(){
        driver.close();
    }


    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK = "//form[contains(@action,\"createTask\")]";
        final String XPATH_TASK_NAME = XPATH_TASK + "/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = XPATH_TASK + "/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = XPATH_TASK + "/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while(!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable_row\"]")).stream()
                .filter(anyForm->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable_field-value\"]"))
                            .getText().equals(taskName))
                .forEach(theForm->{
                    WebElement selectElement=theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreatedCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreatedCard.click();
                });
        Thread.sleep(2000);

    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("user");
        driverTrello.findElement(By.id("password")).sendKeys("password");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]"))
                        .size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);


        final WebDriverWait webDriverWait = new WebDriverWait(driverTrello, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span")));


        result = driverTrello.findElements(By.xpath("//span[@class=\"list-card-title js-card-name\"]")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException{
        String taskName=createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }
}



