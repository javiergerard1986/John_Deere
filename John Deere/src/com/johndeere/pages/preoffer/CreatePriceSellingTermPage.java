package com.johndeere.pages.preoffer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class CreatePriceSellingTermPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="Name")
	private WebElement txtName;
	
	@FindBy(how=How.NAME, using="00N7A000000G0sX")
	private WebElement txtMSRP;
	
	@FindBy(how=How.NAME, using="00N7A000000G0sW")
	private WebElement txtMDPPrice;
	
	@FindBy(how=How.NAME, using="CF00N7A000000G0sY")
	private WebElement txtPreOffer;
	
	@FindBy(how=How.NAME, using="00N7A000000Gemw")
	private WebElement txtStartOfQuantity;
	
	@FindBy(how=How.NAME, using="00N7A000000Gems")
	private WebElement txtEndOfQuantity;
	
	@FindBy(how=How.NAME, using="00N7A000000Gemq")
	private WebElement txtDiscountPercent;
	
	@FindBy(how=How.NAME, using="00N7A000000Gemp")
	private WebElement txtDiscountAmmount;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	

	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a new pre defined price selling term
	 * @param driver - (WebDriver)
	 * @param sellingTerm - (String) Selling Term Name
	 * @param suggestedRetailPrice - (int) Suggested Retail Price
	 * @param preOfferName - (String) PreOffer to add the new pre defined selling term and conditions
	 * @param mdpPrice - (int) MDP Price
	 * @param msrp - (int) MSRP price
	 * @param startOfQuantity - (String) number of start of quantity to apply discounts
	 * @param endOfQuantity - (String) number of end of quantity to apply discounts
	 */
	public void createPreDefinedPriceSellingTerm(WebDriver driver, String sellingTerm, String preOfferName, int mdpPrice, int msrp, String startOfQuantity, String endOfQuantity){
		
		this.logger.log("Providing Selling name");
		this.txtName.sendKeys(sellingTerm);
		
		this.logger.log("Providing MSRP");
		this.txtMSRP.sendKeys(String.valueOf(String.valueOf(msrp)));
		
		this.logger.log("Providing MDP Price");
		this.txtMDPPrice.sendKeys(String.valueOf(String.valueOf(mdpPrice)));
			
		this.logger.log("Providing pre offer");
		this.txtPreOffer.clear();
		this.txtPreOffer.sendKeys(preOfferName);
		
		this.logger.log("Providing Start of Quantity");
		this.txtStartOfQuantity.clear();
		this.txtStartOfQuantity.sendKeys(startOfQuantity);
		
		this.logger.log("Providing End of Quantity");
		this.txtEndOfQuantity.clear();
		this.txtEndOfQuantity.sendKeys(endOfQuantity);
		
		this.logger.log("Clicking on Save button");
		this.btnSave.click();
		
		this.logger.log("Clicking on the preoffer name link to return to the Pre Offer Record page");
		WebElement lnkPreOfferName = driver.findElement(By.linkText(preOfferName));
		lnkPreOfferName.click();
		
	}
	
}