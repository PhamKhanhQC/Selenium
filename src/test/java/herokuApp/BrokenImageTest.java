package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Browser;

import java.util.List;

import static utils.Browser.driver;

public class BrokenImageTest {

    @Test
    void verifyBrokenImage(){
        Browser.openBrowser("chrome");
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.cssSelector(".example img"));
        images.forEach(image -> {
            String imageUrl = image.getDomAttribute("src");
            String naturalWidth = image.getDomProperty("naturalWidth");
            String naturalHeight = image.getDomProperty("naturalHeight");
            System.out.println("--------------");
            System.out.println("Image URL: " + imageUrl);
            System.out.println("Natural Width: " + naturalWidth);
            System.out.println("Natural Height: " + naturalHeight);
        });
        Assert.assertEquals(images.get(0).getDomProperty("naturalWidth"), "0");
        Assert.assertEquals(images.get(1).getDomProperty("naturalWidth"), "0");
        driver.quit();
    }
}

