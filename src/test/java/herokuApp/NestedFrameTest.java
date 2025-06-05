package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrameTest {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    void tc06() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
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
