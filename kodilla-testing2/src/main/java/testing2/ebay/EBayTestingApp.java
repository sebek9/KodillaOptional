package testing2.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testing2.config.WebDriverConfig;

public class EBayTestingApp {

    public static final By EBAYSEARCHFIELD = By.cssSelector("#gh-ac");
    public static final By SEARCHBUTTON=By.cssSelector("#gh-btn");

    public static void main(String[] args){

        WebDriver driver= WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.ebay.com");


        WebElement searchField=driver.findElement(EBAYSEARCHFIELD);
        searchField.click();
        searchField.sendKeys("Laptop");
        driver.findElement(SEARCHBUTTON).click();

    }
}
