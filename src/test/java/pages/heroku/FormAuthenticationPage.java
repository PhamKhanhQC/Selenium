package pages.heroku;

import org.openqa.selenium.By;

import static utils.Browser.*;

public class FormAuthenticationPage {

    public FormAuthenticationPage open(){
        visit("https://the-internet.herokuapp.com/login");
        return this;
    }

    public void login(String username, String password) {
        fill(By.id("username"), username);
        fill(By.id("password"), password);
        click(By.cssSelector("[type=submit]"));
    }

    public String getWelcomeMessage() {
        return getText(By.id("flash-messages"));
    }
}
