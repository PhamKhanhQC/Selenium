package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    @Test
    void tc02() throws InterruptedException {

//        Open browser
//
//        Navigate to https://the-internet.herokuapp.com/checkboxes
//
//        Check on checkbox1
//
//        Verify checkbox1 is checked
//
//        Check on checkbox2
//
//        Verify checkbox2 is checked

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Checkboxes"));
        Thread.sleep(3000);
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        checkbox1.click();
        Thread.sleep(3000);
        checkbox2.click();
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected(), "Checkbox1 is unchecked");
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox2 is unchecked");
        driver.quit();
    }

    @Test
    void verifyCheckAllButtonWorkingTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Checkboxes"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[1]")).click();

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[1]/input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[2]/input"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[3]/input"));

        Assert.assertTrue(checkbox1.isSelected(), "Checkbox1 is unchecked");
        Assert.assertTrue(checkbox2.isSelected(), "Checkbox2 is unchecked");
        Assert.assertTrue(checkbox3.isSelected(), "Checkbox3 is unchecked");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    void verifyUnCheckAllButtonWorkingTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Checkboxes"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[2]")).click();

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[1]/input"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[2]/input"));
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[3]/input"));

        Assert.assertFalse(checkbox1.isSelected(), "Checkbox1 is checked");
        Assert.assertFalse(checkbox2.isSelected(), "Checkbox2 is checked");
        Assert.assertFalse(checkbox3.isSelected(), "Checkbox3 is checked");
        Thread.sleep(2000);
        driver.quit();
    }
}
