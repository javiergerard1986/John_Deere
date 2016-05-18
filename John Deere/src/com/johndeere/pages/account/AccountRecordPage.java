package com.johndeere.pages.account;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class AccountRecordPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------		
	@FindBy(how=How.LINK_TEXT, using="[Change]")
	private WebElement lnkChangeAccountOwner;
	
	@FindBy(how=How.ID, using="workWithPortalLabel")
	private WebElement btnManageExternalAccount;
	
	@FindBy(how=How.XPATH, using=".//*[@id='workWithPortalMenu']/a")
	private WebElement lnkEnableAsPartner;
	
	@FindBy(how=How.NAME, using="newContact")
	private WebElement btnNewContact;

	@FindBy(how=How.NAME, using="new00N7A000000G0t3")
	private WebElement btnNewRelatedDealer;
	
	@FindBy(how=How.NAME, using="new00N7A000000Hrij")
	private WebElement btnNewTax;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to click in the Account Owner link
	 */
	public void clickOnAccountOwnerLink(){
		
		this.lnkChangeAccountOwner.click();
	
	}
	
	/**
	 * Function to enable an account as a parent account 
	 */
	public void enableAccountAsPartner(WebDriver driver){
	
		System.out.println("Enabling account as parent account");
		this.btnManageExternalAccount.click();
		this.lnkEnableAsPartner.click();
		Alert enableAsPartnerAlert = driver.switchTo().alert();
		enableAsPartnerAlert.accept();
		
	}
	
	/**
	 * Function to access into the Create Contact page
	 */
	public void clickOnNewContact(){
		
		this.btnNewContact.click();
		
	}
	
	/**
	 * Function to navigate to the Add Related Dealer page
	 */
	public void navigateToRelatedDealerAssociationPage(){
		
		this.btnNewRelatedDealer.click();
		
	}
	
	/**
	 * Function to navigate to the New Tax page
	 */
	public void navigateToNewTaxPage(){
		
		this.btnNewTax.click();
		
	}
	
}