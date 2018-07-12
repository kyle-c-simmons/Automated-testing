package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaCheckoutPage {

    @FindBy (id = "wsb-button-00000000-0000-0000-0000-000451955160")
    private WebElement getCheckoutButton;

    public void clickCheckoutButton() {
        getCheckoutButton.click();
    }
}
