package herokuApp;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utils.Browser.driver;

public class DynamicLoadingTest {
    @Test
    void waitForResult(){
        Browser.openBrowser("chrome");
        Browser.chromeOption();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String result = wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.cssSelector("#finish h4"))
                )
                .getText();
        Assert.assertEquals(result,"Hello World!");
    }

    @Test
    void captureScreenShot(){
        Browser.openBrowser("chrome");
        Browser.chromeOption();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
