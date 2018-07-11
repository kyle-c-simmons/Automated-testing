import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQASelectable {

    @FindBy(id = "selectable")
    public WebElement selectable;

    @FindBy(xpath = "//a[contains(text(),'Display as grid')]")
    public WebElement displayAsGrid;

    @FindBy(xpath = "//ol[@id='selectable_grid']/li")
    public WebElement selectGridElement;
}
