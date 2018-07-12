import Constants.Constants;
import Pages.TeaCheckoutPage;
import Pages.TeaHomePage;
import Pages.TeaMenuPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import static junit.framework.Assert.assertEquals;


public class StackSteps {

    Constants constant = new Constants();
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address() {
       driver.get(constant.HOME_URL);

    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page() {
        TeaHomePage home = PageFactory.initElements(driver, TeaHomePage.class);
        home.clickGetMenu();
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() {
        TeaMenuPage menuPage = PageFactory.initElements(driver, TeaMenuPage.class);
        try {
            assertEquals("Green Tea", menuPage.getGeenTea());
            assertEquals("Red Tea", menuPage.getRedTea());
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        TeaHomePage home = PageFactory.initElements(driver, TeaHomePage.class);
        home.clickGetMenu();
        TeaCheckoutPage checkoutPage = PageFactory.initElements(driver, TeaCheckoutPage.class);
        checkoutPage.clickCheckoutButton();
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() {
        TeaCheckoutPage checkoutPage = PageFactory.initElements(driver, TeaCheckoutPage.class);
        try {
            assertEquals("Check Out", driver.getTitle());
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
