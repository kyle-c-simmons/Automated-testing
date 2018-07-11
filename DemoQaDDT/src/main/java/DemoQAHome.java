import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoQAHome {

    @FindBy(xpath = "//li[@id='menu-item-141']/a")
    private WebElement droppable;

    @FindBy(id = "menu-item-142")
    private WebElement selectable;


    @FindBy(id = "menu-item-144")
    private WebElement getAccordion;

    @FindBy(id = "menu-item-145")
    private WebElement getAutoComplete;

    @FindBy(id = "menu-item-146")
    private WebElement getDatePicker;


    public void clickDroppable() {

        droppable.click();
    }

    public void clickSelectable() {

        selectable.click();
    }

    public void clickAccordion() {

        getAccordion.click();
    }

    public void clickAutoComplete() {

        getAutoComplete.click();
    }

    public void getDatePicker() {

        getDatePicker.click();
    }
}
