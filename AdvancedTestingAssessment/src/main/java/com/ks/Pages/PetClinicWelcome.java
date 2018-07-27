package com.ks.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PetClinicWelcome {
	
	@FindBy(xpath = "//a[contains(text(),'Owners')]")
    private WebElement getOwnersButton;
	
	public void clickOwnerBtn() {
		getOwnersButton.click();
	}


}
