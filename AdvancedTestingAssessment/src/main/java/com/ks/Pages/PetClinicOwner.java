package com.ks.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicOwner {

	@FindBy(id = "firstName")
    private WebElement getFirstName;
	
	@FindBy(id = "lastName")
    private WebElement getLastName;
	
	@FindBy(id = "address")
    private WebElement getAddress;
	
	@FindBy(id = "city")
    private WebElement getCity;
	
	@FindBy(id = "telephone")
    private WebElement getTelephone;
	
	@FindBy(id = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement addNewOwner;
		
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a")
	private WebElement findUser;
	
	

	public void setFirstName(String firstname) {
		getFirstName.click();
	    getFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		getLastName.click();
		getLastName.sendKeys(lastname);
	}
	
	public void setAddress(String address) {
		getAddress.click();
		getAddress.sendKeys(address);
	}
	
	public void setCity(String city) {
		getCity.click();
		getCity.sendKeys(city);
	}
	
	public void setTelephone(String telephone) {
		getTelephone.click();
		getTelephone.sendKeys(telephone);
	}
	
	public void clickAddOwner() {
		addNewOwner.click();
	}
	
	public String getOwnerName() {
        return findUser.getText();
	}
	
}