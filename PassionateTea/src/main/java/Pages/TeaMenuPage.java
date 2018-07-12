package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaMenuPage {

    @FindBy(xpath = "//div[@id='wsb-element-00000000-0000-0000-0000-000453230000']/div/p")
    private WebElement getGreenTea;

    @FindBy(xpath = "//div[@id='wsb-element-00000000-0000-0000-0000-000453231072']/div/p")
    private WebElement getRedTea;

    public String getGeenTea() {
        return getGreenTea.getText();
    }

    public String getRedTea() {
        return getRedTea.getText();
    }
}
