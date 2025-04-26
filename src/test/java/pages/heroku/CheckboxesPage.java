package pages.heroku;

import org.openqa.selenium.By;

import utils.Browser;

import static utils.Browser.*;

public class CheckboxesPage {
    public void openPage(){
        Browser.visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public boolean checkText() {
        return getText(By.tagName("h3")).contains("Checkboxes");
    }

    public void clickCheckbox1() {
        click(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    }
    public void clickCheckbox2() {
        click(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
    }

    public boolean isCheckbox1Selected(){
        return isSelected(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    }
    public boolean isCheckbox2Selected(){
        return isSelected(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
    }
}
