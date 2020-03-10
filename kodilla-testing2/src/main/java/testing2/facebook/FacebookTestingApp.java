package testing2.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import testing2.config.WebDriverConfig;

import static org.junit.Assert.assertEquals;

public class FacebookTestingApp {

    private static final By DAY_XPATH=By.xpath("//*[@id=\"day\"]");
    private static final By MONTH_XPATH=By.xpath("//*[@id=\"month\"]");
    private static final By YEAR_XPATH=By.xpath("//*[@id=\"year\"]");

    public static void main(String[] args){

        WebDriver driver= WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        Select drpDay=new Select(driver.findElement(DAY_XPATH));
        drpDay.selectByValue("28");

        Select drpMonth=new Select(driver.findElement(MONTH_XPATH));
        drpMonth.selectByValue("4");

        Select drpYear=new Select(driver.findElement(YEAR_XPATH));
        drpYear.selectByValue("1988");

        assertEquals("28",driver.findElement(DAY_XPATH).getAttribute("value"));
        assertEquals("4",driver.findElement(MONTH_XPATH).getAttribute("value"));
        assertEquals("1988",driver.findElement(YEAR_XPATH).getAttribute("value"));

        driver.close();
        driver.quit();

    }
}
