package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.domain.objects.PreOffer;
import com.johndeere.pages.Page;

public class CreatePreOfferPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="Name")
	private WebElement txtPreOfferName;
	
	@FindBy(how=How.NAME, using="00N7A000000G0sL")
	private WebElement cmbRe;
	
	@FindBy(how=How.XPATH, using=".//*[@id='00N7A000000G0sC_unselected']")
	private WebElement cmbCo;
	
	@FindBy(how=How.XPATH, using=".//*[@id='00N7A000000G0sC_right_arrow']")
	private WebElement btnAddCountries;
	
	@FindBy(how=How.ID, using="00N7A000000G0sP")
	private WebElement txtStartDate;
	
	@FindBy(how=How.ID, using="00N7A000000G0sF")
	private WebElement txtEndDate;
	
	@FindBy(how=How.ID, using="00N7A000000Geml")
	private WebElement cmbFreq;
	
	@FindBy(how=How.ID, using="CF00N7A000000G0sJ")
	private WebElement txtProduct;
	
	@FindBy(how=How.ID, using="00N7A000000G0sG")
	private WebElement txtIconUrl;
	
	@FindBy(how=How.ID, using="00N7A000000G0sM")
	private WebElement txtScreenshot1;
	
	@FindBy(how=How.ID, using="00N7A000000G0sN")
	private WebElement txtScreenshot2;
	
	@FindBy(how=How.ID, using="00N7A000000G0sO")
	private WebElement txtScreenshot3;
	
	@FindBy(how=How.ID, using="00N7A000000G0sB")
	private WebElement txtCost;
	
	//Pending Confirmation
	@FindBy(how=How.ID, using="00N7A000000G0sK")
	private WebElement ckbPublished;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a preOffer
	 * @param preOffer - (PreOffer)
	 */
	public void createPreOffer(PreOffer preOffer){
	
		this.logger.log("Providing name");
		this.txtPreOfferName.sendKeys(preOffer.getPreOfferName());
		
		this.logger.log("Selecting region");
		Select cmbPreOfferRegion = new Select(cmbRe);
		cmbPreOfferRegion.selectByVisibleText(preOffer.getRegion());
		
		this.logger.log("Selecting country");
		Select cmbPreOfferCountry = new Select(cmbCo);
		cmbPreOfferCountry.selectByVisibleText(preOffer.getCountry());
		this.btnAddCountries.click();
			
		this.logger.log("Providing start date");
		this.txtStartDate.sendKeys(preOffer.getStartDate());
		
		if (!preOffer.getEndDate().equals("")){
		
			this.logger.log("Providing end date");
			this.txtEndDate.sendKeys(preOffer.getEndDate());
		
		}
		
		this.logger.log("Selecting frequency");
		Select cmbFrequency = new Select(cmbFreq);
		cmbFrequency.selectByVisibleText(preOffer.getFrequency());
		
		this.logger.log("Providing product");
		this.txtProduct.sendKeys(preOffer.getProduct());
		
		if (!preOffer.getIconUrl().equals("")){
			
			this.logger.log("Providing icon url");
			this.txtIconUrl.sendKeys(preOffer.getIconUrl());
			
		}
		
		if (!preOffer.getScreenshot1().equals("")){
			
			this.logger.log("Providing screenshot1");
			this.txtScreenshot1.sendKeys(preOffer.getScreenshot1());
		
		}
		
		if (!preOffer.getScreenshot2().equals("")){
		
			this.logger.log("Providing screenshot2");
			this.txtScreenshot2.sendKeys(preOffer.getScreenshot2());
		
		}
		
		if (!preOffer.getScreenshot3().equals("")){
		
			this.logger.log("Providing screenshot3");
			this.txtScreenshot3.sendKeys(preOffer.getScreenshot3());
		
		}
			
		this.logger.log("Providing cost");
		this.txtCost.sendKeys(preOffer.getCost());
				
		this.logger.log("Clicking on save button");
		this.btnSave.click();
		
	}
	
	/**
	 * Function to publish preoffer
	 */
	public void publishPreOffer(){
		
		this.logger.log("Checking published checkbox");
		this.ckbPublished.click();
		
		this.logger.log("Saving published pre offer");
		this.btnSave.click();
		
	}
	
}