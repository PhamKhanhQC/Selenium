package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    /* TC01: Form Authentication : Login successful with valid credentials
    Open browser
    Navigate to https://the-internet.herokuapp.com/login
    Fill in username with tomsmith
    Fill in the password with SuperSecretPassword!
    Click on Login button
    And the home page is appear */

    @Test
    void tc01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.name("username")).sendKeys("tomsmith");
//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.tagName("input")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("[type=password]")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("SuperSecretPassword!
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().contains("Welcome to the Secure Area. When you are done click logout below."));
        Thread.sleep(3000);
        driver.quit();
    }


}
