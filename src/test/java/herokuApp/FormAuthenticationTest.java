package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.heroku.FormAuthenticationPage;
import utils.Browser;

import static utils.Browser.*;

public class FormAuthenticationTest {
    FormAuthenticationPage formAuthenticationPage;

    @BeforeMethod
    void setup() {
        Browser.openBrowser("chrome");
        formAuthenticationPage = new FormAuthenticationPage();
    }

    @Test
    void tc01(String browser) {
        formAuthenticationPage.open().login("tomsmith", "SuperSecretPassword!");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash-messages"))));
        Assert.assertTrue(formAuthenticationPage.getWelcomeMessage().contains("You logged into a secure area!"));
        Assert.assertEquals(getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @AfterMethod
    void tearDown() {
        quit();
    }
}