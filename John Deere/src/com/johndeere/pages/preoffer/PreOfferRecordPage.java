package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class PreOfferRecordPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="edit")
	private WebElement btnEdit;

	@FindBy(how=How.NAME, using="share")
	private WebElement btnShare;
	
	@FindBy(how=How.NAME, using="new00N7A000000G0sY")
	private WebElement btnNewPreDefinedSellTerm;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to navigate to the create new price selling term
	 */
	public void navigateToCreatePriceSellingTerm (){
		
		logger.log("Clicking on the New Pre Defined Price Selling Term button");
		this.btnNewPreDefinedSellTerm.click();
	}
	
	/**
	 * Function to navigate to the create/edit pre offer page
	 */
	public void navigateToCreateEditPreOfferPage(){
		
		logger.log("Clicking on Edit button");
		this.btnEdit.click();
		
	}
	
	/**
	 * Function to navigate to the Share Pre Offer page
	 */
	public void navigateToSharePreOfferPage(){
		
		logger.log("Navigating to the Share Pre Offer page");
		this.btnShare.click();
		
	}
	
}