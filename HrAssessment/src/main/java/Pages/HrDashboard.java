package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrDashboard {

    @FindBy(xpath = "//div[@id='dashboard-navbar']/nav/div")
    private WebElement getDashboardText;

    @FindBy(id =  "menu_pim_viewPimModule")
    private WebElement getPimTab;

    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    private WebElement getAddEmployee;

    public String getDashboardName() {
        return getDashboardText.getText();
    }

    public void clickPimTab() {
        getPimTab.click();
    }

    public String getPimTabText() {
        return getPimTab.getText();
    }

    public void clickAddEmployee() {
        getAddEmployee.click();
    }

    public String getAddEmployee() {
        return getAddEmployee.getText();
    }
}
