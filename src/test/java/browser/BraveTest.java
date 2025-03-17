package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BraveTest {
    public static void main(String[] args) {

        // Create an object of ChromeOptions class
        ChromeOptions options = new ChromeOptions();
        // Set the path of the Brave browser executable file
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        // Run url in Brave browser
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/");

        // Get the current URL and title of the page
        String url = driver.getCurrentUrl();
        System.out.println("The current url is : " + url);

        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("The title of the page is : " + title);

        // Close the browser
        driver.quit();
    }

}
