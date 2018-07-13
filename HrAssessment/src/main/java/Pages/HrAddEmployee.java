package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HrAddEmployee {

    @FindBy (xpath = "//*[@id=\"firstName\"]")
    private WebElement firstName;

    @FindBy (id = "middleName")
    private WebElement middleName;

    @FindBy (id = "lastName")
    private WebElement lastName;

    @FindBy (id = "employeeId")
    private WebElement employeeId;

    @FindBy (xpath = "//ul[@id='select-options-3cf7e343-88e9-a758-04f1-9e2d454b6c09']/li[3]/span")
    private WebElement location;

    @FindBy (xpath = "//ul[@id='select-options-53dc7b3c-2576-5f31-9101-4ef4fcdc3857']/li[5]/span")
    private WebElement assertLocation;

    private String employeeid;

    public void setFirstName(String firstname) {
        firstName.click();
        firstName.sendKeys(firstname);
    }

    public void setMiddleName(String middlename) {
        middleName.click();
        middleName.sendKeys(middlename);
    }

    public void setLastName(String lastname) {
        lastName.click();
        lastName.sendKeys(lastname);
    }

    public void setEmployeeId(String employeeid) {
        this.employeeid = employeeid;
        employeeId.click();
        employeeId.sendKeys(employeeid);
    }

    public String getId() {
        return employeeid;
    }

    public void getLocation() {
        location.click();
    }

    public String checkLocation() {
        return location.getText();
    }
}
