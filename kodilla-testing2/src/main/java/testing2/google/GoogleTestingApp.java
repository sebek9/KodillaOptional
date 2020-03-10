package testing2.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testing2.config.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public class GoogleTestingApp {


    public static final By SEARCHFIELD  = By.cssSelector("div.a4bIc > input");

    public static void main(String[] args){

        WebDriver driver= WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        WebElement searchField=driver.findElement(SEARCHFIELD);
        searchField.click();
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
