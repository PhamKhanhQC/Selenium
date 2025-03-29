package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HyperLinkTest {
   @Test
    void verifyAbleNavigateHyperlink() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/status_codes");
        // click link status code 200
        // <a href="status_codes/200">200</a>
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();
        driver.findElement(By.xpath("//a[.='200']/@href")).click();

        String href = driver.findElement(By.linkText("200")).getDomAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(href));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        String content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 200 status code"));

        // 301 test
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 301 status code."));

        //404 test
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 404 status code."));

        //500 test
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("content"))));
        content = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(content.contains("This page returned a 500 status code."));

    }
}
