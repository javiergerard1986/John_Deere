package com.johndeere.pages.community;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class DealerAccountWorkflowPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.XPATH, using=".//button[contains(text(), 'Looks Good,')]")
	private WebElement btnGoToStepTwo;
	
	@FindBy(how=How.XPATH, using=".//input[@ng-model='resellAgree']")
	private WebElement chkAgree;
	
	@FindBy(how=How.XPATH, using=".//button[contains(text(), 'I Agree To The Terms And Conditions')]")
	private WebElement btnGoToStepThree;
	
	@FindBy(how=How.XPATH, using=".//button[contains(text(),'All Set,')]")
	private WebElement btnGoToStepFour;
	
	@FindBy(how=How.XPATH, using=".//a[contains(text(),'Click Here To Start Using PayPal On The MarketPlace')]")
	private WebElement btnValidatePayPalAccount;
			
	@FindBy(how=How.XPATH, using=".//input[@ng-model='acceptFarmPlan']")
	private WebElement chkFarmPlan;
	
	@FindBy(how=How.XPATH, using=".//button[contains(text(),'Finished With Payment Collection Options. I Am Ready To Setup My First Offering For The MarketPlace.')]")
	private WebElement btnCompleteAccountWorkflow;
	
	@FindBy(how=How.XPATH, using=".//img[@id='nav-h']")
	private WebElement btnExpandLeftMenuBar;
	
	@FindBy(how=How.XPATH, using=".//a[contains(text(), 'My Offers')]")
	private WebElement lnkMyOffers;
	
	@FindBy(how=How.XPATH, using=".//a[contains(text(), 'Tax Management')]")
	private WebElement lnkTaxManagement;

	@FindBy(how=How.XPATH, using=".//input[@name='default-option']")
	private WebElement rbDefaultTaxRate;
	
	@FindBy(how=How.XPATH, using=".//input[@class='form-control ng-pristine ng-untouched ng-valid']")
	private WebElement txtDefaultTaxRate;
	
	@FindBy(how=How.XPATH, using=".//a[contains(text(), 'Preview')]")
	private WebElement lnkPreview;
	
	@FindBy(how=How.XPATH, using=".//input[@class='disable-marketplace-button']")
	private WebElement btnEnableMarketPlace;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to complete the Dealer Account Setup Workflow
	 * @param (WebDriver) driver
	 */
	public void completeDealerAccountSetupWorkflow(WebDriver driver){

		logger.log("Clicking on the Go to Step 2 button");
		this.btnGoToStepTwo.click();
		
		logger.log("Checking the I Agree checkbox");
		this.chkAgree.click();
		
		logger.log("Clicking on the Go to Step 3 button");
		this.btnGoToStepThree.click();
		
		logger.log("Clicking on the Go to Step 4 button");
		this.btnGoToStepFour.click();
		
		logger.log("Checking the Accept Farm Plan checkbox");
		this.chkFarmPlan.click();
		
		logger.log("Clicking on Complete Dealer Account Setup Workflow button");
		this.btnCompleteAccountWorkflow.click();
		
		boolean present = isElementInPage("My Offers", driver);
		while(!present){
			
			present = isElementInPage("My Offers", driver);
			
		}
		
		logger.log("Accessing into Tax Management page");
		this.accessIntoTaxManagementPage(driver);
		
		present = isElementInPage("Defer Tax on Transactions", driver);
		while(!present){
			
			present = isElementInPage("Defer Tax on Transactions", driver);
			
		}
		
		logger.log("Checking the Defaul Tax Rate radio button");
		this.rbDefaultTaxRate.click();
		
		present = isElementInPage("Defer Tax on Transactions", driver);
		while(!present){
			
			present = isElementInPage("Defer Tax on Transactions", driver);
			
		}
		
		logger.log("Providing Default Tax Rate");
		this.txtDefaultTaxRate.click();
		this.txtDefaultTaxRate.clear();
		this.txtDefaultTaxRate.sendKeys("30");
		
		logger.log("Accessing again into the My Offers page to save changes");
		this.accessIntoMyOffersPage(driver);
		
		present = isElementInPage("My Offers", driver);
		while(!present){
			
			present = isElementInPage("My Offers", driver);
			
		}
		
		logger.log("Accessing again to save changes into Tax Management page");
		this.accessIntoTaxManagementPage(driver);
		
		present = isElementInPage("Defer Tax on Transactions", driver);
		
	}
	
	/**
	 * Function to enable the Dealer user MarketPlace
	 * @param (WebDriver) driver 
	 */
	public void enableDealerUserMarketPlace(WebDriver driver){
		
		logger.log("Accessing into Preview page");
		this.accessIntoPreviewPage(driver);
		
		
		boolean present = isElementInPage("My MarketPlace Preview", driver);
		while(!present){
			
			present = isElementInPage("My MarketPlace Preview", driver);
			
		}
		
		logger.log("Enabling Dealer user MarketPlace, clicking on Enable button");
		this.btnEnableMarketPlace.click();
		
	}
	
	/**
	 * Void to access into the Tax Management page
	 * @param (WebDriver) driver
	 */
	public void accessIntoTaxManagementPage(WebDriver driver){
		
		logger.log("Clicking on Expand Left Menu Bar button");
		this.btnExpandLeftMenuBar.click();
		
		boolean present = isElementInPage("Tax Management", driver);
		while(!present){
			
			present = isElementInPage("Tax Management", driver);
			
		}
		
		logger.log("Clicking on Tax Management option");
		this.lnkTaxManagement.click();
		
	}
	
	/**
	 * Void to access into the Preview page
	 * @param (WebDriver) driver
	 */
	public void accessIntoPreviewPage(WebDriver driver){
		
		logger.log("Clicking on Expand Left Menu Bar button");
		this.btnExpandLeftMenuBar.click();
		
		boolean present = isElementInPage("Preview", driver);
		while(!present){
			
			present = isElementInPage("Preview", driver);
			
		}
		
		logger.log("Clicking on Preview option");
		this.lnkPreview.click();
		
	}
		
	
	/**
	 * Void to access into the My Offers page
	 * @param (WebDriver) driver
	 */
	public void accessIntoMyOffersPage (WebDriver driver){
		
		logger.log("Clicking on Expand Left Menu Bar button");
		this.btnExpandLeftMenuBar.click();
		
		boolean present = isElementInPage("My Offers", driver);
		while(!present){
			
			present = isElementInPage("My Offers", driver);
			
		}
		
		logger.log("Clicking on My Offers");
		this.lnkMyOffers.click();
		
	}
	
}