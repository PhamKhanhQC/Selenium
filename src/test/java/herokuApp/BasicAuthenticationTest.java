package herokuApp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Browser;

import static utils.Browser.driver;

public class BasicAuthenticationTest {

    @Test
    void verifyLoginSuccessfulWithValidCredentials() {
        // Test code for verifying login with valid credentials
        Browser.openBrowser("chrome");
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String welcomeMessage = driver.findElement(By.tagName("p")).getText();
        assert welcomeMessage.contains("Congratulations! You must have the proper credentials.");
        driver.quit();
    }


}
