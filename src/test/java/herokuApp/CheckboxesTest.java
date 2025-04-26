package herokuApp;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.heroku.CheckboxesPage;
import utils.Browser;


public class CheckboxesTest {
    @Test
    void tc02() throws InterruptedException {

        Browser.openBrowser("chrome");
        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.openPage();
        checkboxesPage.checkText();
        Thread.sleep(3000);
        checkboxesPage.clickCheckbox1();
        Thread.sleep(3000);
        checkboxesPage.clickCheckbox2();
        if (!checkboxesPage.isCheckbox1Selected()) {
            checkboxesPage.clickCheckbox1();
        }
        Assert.assertTrue(checkboxesPage.isCheckbox1Selected(), "Checkbox1 is unchecked");
        if (!checkboxesPage.isCheckbox2Selected()) {
            checkboxesPage.clickCheckbox2();
        }
        Assert.assertTrue(checkboxesPage.isCheckbox2Selected(), "Checkbox2 is unchecked");
        Browser.quit();
    }

//    @Test
//    void verifyCheckAllButtonWorkingTest() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
//        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Checkboxes"));
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[1]")).click();
//
//        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[1]/input"));
//        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[2]/input"));
//        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[3]/input"));
//
//        Assert.assertTrue(checkbox1.isSelected(), "Checkbox1 is unchecked");
//        Assert.assertTrue(checkbox2.isSelected(), "Checkbox2 is unchecked");
//        Assert.assertTrue(checkbox3.isSelected(), "Checkbox3 is unchecked");
//        Thread.sleep(2000);
//        driver.quit();
//    }
//
//    @Test
//    void verifyUnCheckAllButtonWorkingTest() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
//        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Checkboxes"));
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[1]")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[2]/button[2]")).click();
//
//        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[1]/input"));
//        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[2]/input"));
//        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/main/div/div/div[1]/label[3]/input"));
//
//        Assert.assertFalse(checkbox1.isSelected(), "Checkbox1 is checked");
//        Assert.assertFalse(checkbox2.isSelected(), "Checkbox2 is checked");
//        Assert.assertFalse(checkbox3.isSelected(), "Checkbox3 is checked");
//        Thread.sleep(2000);
//        driver.quit();
//    }
}
