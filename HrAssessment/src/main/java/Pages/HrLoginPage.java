package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrLoginPage {

    @FindBy(id = "txtUsername")
    private WebElement getUsername;

    @FindBy(id = "txtPassword")
    private WebElement getPassword;

    @FindBy(id = "btnLogin")
    private WebElement login;

    public void enterUsername(String username) {
        getUsername.click();
        getUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        getPassword.click();
        getPassword.sendKeys(password);
    }

    public void login() {
        login.click();
    }

}
