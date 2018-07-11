import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQADatePicker {

    @FindBy(id = "datepicker1")
    public WebElement getDatePickerField;

    @FindBy(xpath = "xpath=(//a[contains(@href, '#')])[14]")
    public WebElement getDate;

}
