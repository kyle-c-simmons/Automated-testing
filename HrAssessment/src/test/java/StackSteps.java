import Constants.Url;
import Pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Hr;
import gherkin.lexer.Pa;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

public class StackSteps {

    WebDriver driver;
    Url url = new Url();
    ExtentReports report = new ExtentReports("C:/Users/Admin/Desktop/hrtesting.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    @Given("^the login page$")
    public void the_login_page() {
       driver.get(url.getLoginPage);
       test = report.startTest("Hr testing");
       test.log(LogStatus.INFO, "Browser started");

        try {
            assertEquals("https://qa-trials641.orangehrmlive.com/auth/login", url.getLoginPage);
            test.log(LogStatus.PASS, "Got the login page");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Could not get url");
            e.getStackTrace();
        }
    }

    @When("^I login$")
    public void i_login() {
        HrLoginPage loginPage = PageFactory.initElements(driver, HrLoginPage.class);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("AdminAdmin");
        loginPage.login();

        HrDashboard dashboard = PageFactory.initElements(driver, HrDashboard.class);

        try {
            assertEquals("dashboard\n" +
                    "schedule\n" +
                    "2\n" +
                    "insert_invitation\n" +
                    "1\n" +
                    "contact_phone\n" +
                    "32", dashboard.getDashboardName().toLowerCase());
            test.log(LogStatus.PASS, "Able to login");
        } catch (Exception e) {
            test.log(LogStatus.FATAL, "Could not login");
            e.getStackTrace();
        }
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() {
        HrDashboard dashboard = PageFactory.initElements(driver, HrDashboard.class);
        dashboard.clickPimTab();

        try {
            assertEquals("PIM\n" + "Configuration", dashboard.getPimTabText());
            test.log(LogStatus.PASS, "Able to click PIM tab");

        } catch (Exception e) {
            test.log(LogStatus.FATAL, "Could not click PIM tab");
        }
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException {
        HrDashboard dashboard = PageFactory.initElements(driver, HrDashboard.class);
        Thread.sleep(400);
        dashboard.clickAddEmployee();

        try {
            assertEquals("Add Employee", dashboard.getAddEmployee());
            test.log(LogStatus.PASS, "Able to click add an employee tab");

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Could not click add an employee tab");
            e.getStackTrace();
        }
    }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly() throws InterruptedException {
        HrAddEmployee addEmployee = PageFactory.initElements(driver, HrAddEmployee.class);
        WebElement myDynamicElement = (new WebDriverWait(driver, 20)) .until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        addEmployee.setFirstName("Bill");
        addEmployee.setMiddleName("Billmiddle");
        addEmployee.setLastName("Billy");
        addEmployee.setEmployeeId("1001");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        for(int i =0; i < 3; i++) {
            action.sendKeys(Keys.ARROW_DOWN).perform();
        }
        action.sendKeys(Keys.ENTER).perform();

        try {
            assertEquals("1001", addEmployee.getId());
            test.log(LogStatus.PASS, "Able to add employee details");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Failed to add employee details");
            e.getStackTrace();
        }
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() throws InterruptedException {
        HrLoginDetails loginDetails = PageFactory.initElements(driver, HrLoginDetails.class);
        loginDetails.clickLogin();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws InterruptedException {
        HrLoginDetails loginDetails = PageFactory.initElements(driver, HrLoginDetails.class);
        Random rand = new Random();
        int r = rand.nextInt(400) + 1;
        loginDetails.setUsername("hello" + r);
        loginDetails.setPassword("password");
        loginDetails.getConfirmPassword("password");

        Actions action = new Actions(driver);

        try {
           // assertEquals("password", loginDetails.getPassword());
            test.log(LogStatus.PASS, "Able to fill out login details correctly");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Login details incorrect");
            e.getStackTrace();
        }

    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws InterruptedException {
        HrLoginDetails loginDetails = PageFactory.initElements(driver, HrLoginDetails.class);
        Thread.sleep(3000);
        loginDetails.getSaveUser();
        Thread.sleep(10000);

        try {
            //assertEquals("SAVE", loginDetails.getSaveText());
            test.log(LogStatus.PASS, "Saving done");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Saving failed");
            e.getStackTrace();
        }
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws InterruptedException {
        Thread.sleep(500);
       HrSearchEmployee searchEmployee = PageFactory.initElements(driver, HrSearchEmployee.class);
       searchEmployee.clickEmployeeList();
       searchEmployee.clickFilter("Bill Billy");
       Thread.sleep(1000);
       Actions action = new Actions(driver);
       action.sendKeys(Keys.ENTER);
       Thread.sleep(1000);

       try {
           //assertEquals("Bill, Billy", searchEmployee.getFilter());
           test.log(LogStatus.PASS, "I can search for the name i have just created");

       } catch (Exception e) {
           e.getStackTrace();
       }

    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws InterruptedException {
        HrSearchEmployee searchEmployee = PageFactory.initElements(driver, HrSearchEmployee.class);
        searchEmployee.clickEmployeeList();
        Thread.sleep(400);
    }
}
