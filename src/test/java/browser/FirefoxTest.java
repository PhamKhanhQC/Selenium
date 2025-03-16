package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest {

    @Test
    void openWithDefaultMode() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openBrowserWithHeadlessMode(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless=new");

        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }
}
