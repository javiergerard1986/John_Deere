package com.johndeere.pages.community;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.johndeere.pages.Page;

public class PublishPreOfferPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.XPATH, using=".//button[text()='Publish Offer']")
	private WebElement btnPublishPreOffer;
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to publish a pre offer
	 */
	public void publishPreOffer (){

		logger.log("Clicking on the Publish Offer button");
		this.btnPublishPreOffer.click();
		
	}
	
}