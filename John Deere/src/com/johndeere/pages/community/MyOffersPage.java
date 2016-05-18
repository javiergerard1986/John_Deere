package com.johndeere.pages.community;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.johndeere.pages.Page;

public class MyOffersPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Navigate into the Publish Pre Offer page
	 * @param driver - (Driver)
	 * @param preOfferName - (String) Pre Offer to publish
	 */
	public void navigateIntoPublishPreOfferPage (WebDriver driver, String preOfferName){

		logger.log("Clicking on the ADD TO MARKETPLACE > button of the " + preOfferName + " pre offer");
		WebElement btnAddToMarketplace = driver.findElement(By.xpath("//div[contains(text(),'" + preOfferName + "')]/../../following::div//div[contains(text(),'Add To MarketPlace')]"));
		btnAddToMarketplace.click();
		
	}
	
}