package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class SampleTest1 {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite");
    }

        @BeforeTest
        void beforeTest() {
            System.out.println("Before Test");
        }

        @BeforeClass

        void beforeClass() {
            System.out.println("Before Class");
        }

        @BeforeMethod

        void beforeGroups() {
            System.out.println("Before Method");
        }

        @Test
        void testMethod1() {
            System.out.println("Test method 1");
        }

        @Test
        void testMethod2() {
            System.out.println("Test method 2");
        }

        @Test
        void testMethod3() {
            System.out.println("Test method 3");
        }

        @Test
        void testMethod4() {
            System.out.println("Test method 4");
        }

        @Test
        void testMethod5() {
            System.out.println("Test method 5");
        }

        @AfterMethod

        void afterMethod() {
            System.out.println("After Method");
        }

        @AfterTest

        void afterTest() {
            System.out.println("After Test");
        }

        @AfterClass

        void afterClass() {
            System.out.println("After Class");
        }

    @AfterSuite

    void afterSuite() {
        System.out.println("After Suite");
    }


}
