package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;

import java.time.Duration;

public class NestedFrameTest {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    void tc06() {
        Browser.openBrowser("chrome");
        Browser.chromeOption();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.xpath("//body")).getText().contains("LEFT"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.xpath("//body")).getText().contains("MIDDLE"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("//body")).getText().contains("RIGHT"));
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.xpath("//body")).getText().contains("BOTTOM"));
        driver.quit();
    }
}
