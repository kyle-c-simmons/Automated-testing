import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAAutoComplete {

    @FindBy(xpath = "//input[@id='tagss']")
    public WebElement getTags;

    @FindBy(id = "ui-id-7")
    public WebElement getAutoComplete;

    public void enterTag(String tag) {
        getTags.sendKeys(tag);
    }


}
