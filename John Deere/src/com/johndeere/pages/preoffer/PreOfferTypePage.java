package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.pages.Page;

public class PreOfferTypePage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="p3")
	private WebElement cmbTy;
	
	@FindBy(how=How.XPATH, using=".//*[@id='bottomButtonRow']/input[1]")
	private WebElement btnContinue;
	
	@FindBy(how=How.NAME, using="cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to select preOffer type
	 */
	public void selectPreOfferType (String preOfferType){
		
		this.logger.log("Selecting Pre Offer type");
		Select cmbPreOfferType = new Select(cmbTy);
		cmbPreOfferType.selectByVisibleText(preOfferType);
		
		this.logger.log("Clicking on the Continue button");
		this.btnContinue.click();
		
	}
	
}