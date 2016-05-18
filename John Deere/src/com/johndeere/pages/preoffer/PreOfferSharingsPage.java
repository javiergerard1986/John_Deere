package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class PreOfferSharingsPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="new")
	private WebElement btnAdd;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to navigate to the Add Users to Pre Offer page
	 */
	public void navigatToAddUsersToPreOfferPage (){
		
		logger.log("Navigating to the Add Users to Pre Offer page");
		this.btnAdd.click();
		
	}
	
}