package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicAuthenticationTest {

    @Test
    void verifyLoginSuccessfulWithValidCredentials() {
        // Test code for verifying login with valid credentials
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String welcomeMessage = driver.findElement(By.tagName("p")).getText();
        assert welcomeMessage.contains("Congratulations! You must have the proper credentials.");
        driver.quit();
    }


}
