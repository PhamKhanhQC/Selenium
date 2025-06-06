package herokuApp;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.heroku.CheckboxesPage;
import utils.Browser;

import static utils.Browser.quit;


public class CheckboxesTest {
    @Test
    void tc02() throws InterruptedException {
        Browser.openBrowser("chrome");

        CheckboxesPage checkboxesPage = new CheckboxesPage();
        checkboxesPage.open();
        Thread.sleep(5000);
        checkboxesPage.check("1");
        Assert.assertTrue(checkboxesPage.isChecked("1"), "Checkbox 1 is not checked");
        checkboxesPage.check("2");
        Assert.assertTrue(checkboxesPage.isChecked("2"), "Checkbox 2 is not checked");
        quit();
    }
}
