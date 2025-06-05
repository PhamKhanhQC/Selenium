package herokuApp;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TableTest {
    WebDriver driver;
    List<Person> personList;

    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chromeProfile");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        personList = new ArrayList<>();
        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    String lastName = row.findElement(By.xpath("./td[1]")).getText();
                    String firstName = row.findElement(By.xpath("./td[2]")).getText();
                    double due = Double.parseDouble(row.findElement(By.xpath("./td[4]")).getText().replace("$", ""));
                    personList.add(new Person(firstName, lastName, due));
                });
    }

    @Test
    void tc05() {
        List<Double> dueList = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.valueOf(cell.getText().replace("$", "")))
                .toList();

        double maxDue = Collections.max(dueList);
        int rowIndex = dueList.indexOf(maxDue) + 1; // +1 because xpath is 1-based index

        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]", rowIndex))).getText();
        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]", rowIndex))).getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }

    @Test
    void tc06() {
        double maxDue = personList.stream().max(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMaxDue = personList.stream()
                .filter(p -> p.getDue() == maxDue)
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(listPersonHaveMaxDue, List.of("Jason Doe"));
    }

    @Test
    void tc07() {
        double minDue = personList.stream().min(Comparator.comparing(Person::getDue)).get().getDue();
        List<String> listPersonHaveMinDue = personList.stream()
                .filter(p -> p.getDue() == minDue)
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(listPersonHaveMinDue, List.of("John Smith", "Tim Conway"));
    }

    @AfterMethod(alwaysRun = true)
    void captureScreenshot(ITestResult testResult){
        if(!testResult.isSuccess()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy'-'MM'-'dd'T'HH':'mm':'ss"));
            File destFile = new File(String.format("target/screenshot-%s-%s.png", testResult.getName(), timestamp));
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterClass(alwaysRun = true)
    void tearDown() {
        driver.quit();
    }
}
