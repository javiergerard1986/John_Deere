package com.johndeere.pages.community;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class CommunityHomePage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.XPATH, using=".//span[contains(text(), 'Hello,')]")
	private WebElement ddContactName;
	
	@FindBy(how=How.LINK_TEXT, using="Seller Community")
	private WebElement lnkSellerCommunity;
	
	@FindBy(how=How.LINK_TEXT, using="Logout")
	private WebElement lnkLogout;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Navigate to the John Deere Community
	 * @Param driver - (WebDriver)
	 */
	public void navigateToJohnDeereCommunity (WebDriver driver){

		logger.log("Clicking on Contact Name drop down button");
		this.ddContactName.click();

		boolean present = isElementInPage("Seller Community", driver);
		while(!present){
			
			present = isElementInPage("Seller Community", driver);
			
		}
		
		logger.log("Clicking on Seller Community option");
		this.lnkSellerCommunity.click();
		
	}
	
	/**
	 * Function to logout from the John Deere Community
	 * @Param driver - (WebDriver)
	 */
	public void logout(WebDriver driver){
		
		logger.log("Clicking on Contact Name drop down button");
		this.ddContactName.click();

		boolean present = isElementInPage("Logout", driver);
		while(!present){
			
			present = isElementInPage("Logout", driver);
			
		}
		
		logger.log("Clicking on Logout");
		this.lnkLogout.click();
		
	}
	
}