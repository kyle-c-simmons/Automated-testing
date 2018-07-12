import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.net.URI;

import static org.junit.Assert.*;


public class DemoQATesting {

    private WebDriver driver;
    Constants constants = new Constants();

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void droppableTest() {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);

        // Go to droppable page
        driver.get(constants.URL1);
        qaHome.clickDroppable();

        DemoQADroppable qaDroppable = PageFactory.initElements(driver, DemoQADroppable.class);


        // Get the drag me element
        Actions action = new Actions(driver);
        action.moveByOffset(639,390).dragAndDrop(qaDroppable.draggable, qaDroppable.droppable).perform();

        /*
        try {
            assertEquals(qaDroppable.droppable, qaDroppable.draggable);


        } catch (Exception e) {

        } finally {

        }
        */
    }

    @Test
    public void selectableTest() {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);

        // Go to selectable
        driver.get(constants.URL1);
        qaHome.clickSelectable();

        // Select grid
        DemoQASelectable qaSelectable = PageFactory.initElements(driver, DemoQASelectable.class);
        Actions action = new Actions(driver);

        action.click(qaSelectable.displayAsGrid).perform();
        action.click(qaSelectable.selectGridElement).perform();
    }

    @Test
    public void AccordionTest() {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);

        // Go to accordion page
        driver.get(constants.URL1);
        qaHome.clickAccordion();

        DemoQAAccordion qaAccordion = PageFactory.initElements(driver, DemoQAAccordion.class);
        Actions action = new Actions(driver);

        action.click(qaAccordion.accordionSection1).perform();
        action.click(qaAccordion.getAccordionSection2).perform();

    }

    @Test
    public void AutocompleteTest() throws InterruptedException {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);
        DemoQAAutoComplete qaAutoComplete = PageFactory.initElements(driver, DemoQAAutoComplete.class);

        // Go to autocomplete
        driver.get(constants.URL1);
        qaHome.clickAutoComplete();

        Actions action = new Actions(driver);

        // Click the tag text field
        action.click(qaAutoComplete.getTags).perform();

        // Enter string into auto complete
        qaAutoComplete.enterTag("Ja");

        // Send a key
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();

    }

    @Test
    public void DatePickerTest() {
        driver.manage().window().maximize();
        DemoQAHome qaHome = PageFactory.initElements(driver, DemoQAHome.class);
        DemoQADatePicker qaDatePicker = PageFactory.initElements(driver, DemoQADatePicker.class);

        // Get url
        driver.get(constants.URL1);
        qaHome.clickDatePicker();

        Actions action = new Actions(driver);

        // Click data picker and get date
        action.click(qaDatePicker.getDatePickerField).perform();
       // action.moveByOffset()
        //action.click(qaDatePicker.getDate).perform();
    }

    @Test
    public void MenuTest() {

    }

    @Test
    public void SliderTest() {

    }

    @Test
    public void TabsTest() {

    }


    @Test
    public void TooltipTest() {

    }





}
