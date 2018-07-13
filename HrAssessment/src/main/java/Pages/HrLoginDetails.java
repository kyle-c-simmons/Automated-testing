package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrLoginDetails {

    @FindBy (xpath = "//form[@id='pimAddEmployeeForm']/div/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement clickLoginButton;

    @FindBy (id = "username")
    private WebElement username;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy (xpath = "//*[@id=\"systemUserSaveBtn\"]")
    private WebElement saveUser;

    public String pass;

    public void clickLogin() {
        clickLoginButton.click();
    }

    public void setUsername(String user) {
        username.click();
        username.sendKeys(user);
    }

    public void setPassword(String pass) {
        password.click();
        password.sendKeys(pass);
    }

    public String getPassword() {
       return this.pass;
    }

    public void getConfirmPassword(String conpass) {
        confirmPassword.click();
        confirmPassword.sendKeys(conpass);
    }

    public void getSaveUser() {
        saveUser.click();
    }
    public String getSaveText() {
        return saveUser.getText();
    }


}
