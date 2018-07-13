package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrSearchEmployee {

    @FindBy (xpath ="//*[@id=\"menu_pim_viewEmployeeList\"]/span[2]")
    private WebElement clickEmployeeList;

    @FindBy (id = "employee_name_quick_filter_employee_list_value")
    private WebElement clickFilter;

    @FindBy (xpath = "//table[@id='employeeListTable']/tbody/tr/td[3]")
    private WebElement inspect;

    public String name;

    public void clickEmployeeList() {
        clickEmployeeList.click();
    }

    public void clickFilter(String name) {
        this.name = name;
        clickFilter.click();
        clickFilter.sendKeys(name);
    }

    public String getFilter() {
        return name;
    }

    public void inspect() {
        inspect.click();
    }

}
