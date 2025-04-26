package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScriptAlertTest {
    WebDriver driver;
    WebDriverWait wait;
    @Test
    void t07(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        driver.quit();
    }
}
