package com.ks.Selenium;
import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.ks.Constant.*;
import com.ks.Pages.PetClinicOwner;
import com.ks.Pages.PetClinicWelcome;


public class PetClinic {
	
	WebDriver driver;
    Url url = new Url();
    ExtentReports report = new ExtentReports("C:/Users/Admin/Desktop/PetClinicReport.html", true);
    ExtentTest test;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        report.endTest(test);
        report.flush();
        driver.quit();
    }
    
    @Test
    public void addOwner() {
    	 driver.get(url.welcomePage);
         test = report.startTest("Testing Add owner");
         test.log(LogStatus.INFO, "Browser started");
         
         try {

        	 PetClinicWelcome newOwner = PageFactory.initElements(driver, PetClinicWelcome.class);
        	 newOwner.clickOwnerBtn();
        	 
             Actions action = new Actions(driver);

             for(int i =0; i < 2; i++) { 
                 action.sendKeys(Keys.TAB).perform();

             }
             action.sendKeys(Keys.ENTER).perform();
             Thread.sleep(500);
             
             PetClinicOwner owner = PageFactory.initElements(driver, PetClinicOwner.class);
             owner.setFirstName("Bob");
             owner.setLastName("bobby");
             owner.setAddress("manchester");
             owner.setCity("manchester");
             owner.setTelephone("302546");

             action.sendKeys(Keys.TAB).perform();
             action.sendKeys(Keys.TAB).perform();
             owner.clickAddOwner();
             
             Thread.sleep(1000);

             action.sendKeys(Keys.ENTER).perform();
             
             newOwner.clickOwnerBtn();
             
             for(int i =0; i < 2; i++) { 
                 action.sendKeys(Keys.TAB).perform();

             }
             action.sendKeys(Keys.ENTER).perform();
             Thread.sleep(500);
             
             System.out.println(owner.getOwnerName());
             
             assertEquals("George Franklin", owner.getOwnerName());
             test.log(LogStatus.PASS, "Sucessfully added a OWNER");
             
         } catch (Exception e) {
             test.log(LogStatus.FAIL, "Failed to add a OWNER");
             e.getStackTrace();
         }
    } 
}
