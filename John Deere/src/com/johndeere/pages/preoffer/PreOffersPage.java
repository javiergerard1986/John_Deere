package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class PreOffersPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="new")
	private WebElement btnNew;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a new pre offer
	 */
	public void navigateIntoSelectPreOfferTypePage(){
		
		logger.log("Clicking on the new button");
		this.btnNew.click();
	}
	
}