package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class TableTest {
    @Test
    void tc05(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$","")))
                .toList();

        double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue) + 1; // +1 because xpath is 1-based index

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", rowIndex))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", rowIndex))).getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
        driver.quit();
    }
}
