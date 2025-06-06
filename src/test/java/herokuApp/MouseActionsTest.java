package herokuApp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static utils.Browser.driver;

public class MouseActionsTest {
    @Test
    void hoverTest() {
        Browser.openBrowser("chrome");
        Browser.chromeOption();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions action = new Actions(driver);
        WebElement avatar = driver.findElements(By.className("figure")).get(2);

        action.moveToElement(avatar).perform();
        Assert.assertTrue(avatar.findElement(By.xpath(".//h5")).isDisplayed());
        driver.quit();

    }

    @Test
    void dragAndDropTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        action.dragAndDrop(source, target).perform();

        Assert.assertEquals(source.getText(), "B");
        Assert.assertEquals(target.getText(), "A");

        driver.quit();
    }


    @Test
    void horizontalSliderTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions action = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        action.clickAndHold(slider).moveByOffset(slider.getSize().getWidth(), 0).release().perform();

        String value = driver.findElement(By.id("range")).getText();
        Assert.assertEquals(value, "5");

        driver.quit();
    }

    @Test
    void infiniteScrollTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions action = new Actions(driver);
        for (int i = 0; i < 10; i++) {
            action.scrollByAmount(0, 100).perform();
            Thread.sleep(1000);
        }
        driver.quit();
    }

    @Test
    void contextMenuTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions action = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();

        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert text: " + alertText);
        driver.switchTo().alert().accept();

        driver.quit();
    }

    @Test
    void keyPressTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("You entered: ESCAPE"));

        driver.quit();
    }

    @Test
    void verifyDynamicLoading() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).getText();
        Assert.assertTrue(finishText.contains("Hello World!"));
    }

    @Test
    void captureScreenShot() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        WebDriver driver = new ChromeDriver();
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
