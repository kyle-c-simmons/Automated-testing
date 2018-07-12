package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaHomePage {

    @FindBy (id = "wsb-nav-00000000-0000-0000-0000-000450914915")
    private WebElement getMenu;

    public void clickGetMenu() {
        getMenu.click();
    }


}
