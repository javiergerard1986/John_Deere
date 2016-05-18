package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.domain.objects.Tax;
import com.johndeere.pages.Page;

public class CreateTaxPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="CF00N7A000000Hrij")
	private WebElement txtDealerAccount;
		
	@FindBy(how=How.NAME, using="CF00N7A000000Hrik")
	private WebElement txtStateProvince;
	
	@FindBy(how=How.NAME, using="00N7A000000HrjX")
	private WebElement txtPercentToCharge;

	@FindBy(how=How.NAME, using="00N7A000000HrjY")
	private WebElement txtTaxDescription;
	
	@FindBy(how=How.NAME, using="00N7A000000HrjW")
	private WebElement cmbCo;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	@FindBy(how=How.NAME, using="save_new")
	private WebElement btnSaveNew;
	
	@FindBy(how=How.NAME, using="cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a tax
	 * @param tax (Tax) Tax to create
	 */
	public void createTax(Tax tax){
		
		logger.log("Providing Dealer Account");
		this.txtDealerAccount.clear();
		this.txtDealerAccount.sendKeys(tax.getDealerAccount());
		
		logger.log("Providing state / province");
		this.txtStateProvince.clear();
		this.txtStateProvince.sendKeys(tax.getStateProvince());
		
		logger.log("Providing percent to charge");
		this.txtPercentToCharge.clear();
		this.txtPercentToCharge.sendKeys(tax.getPercentToCharge());
		
		logger.log("Providing tax description");
		this.txtTaxDescription.clear();
		this.txtTaxDescription.sendKeys(tax.getDescription());
		
		logger.log("Selecting country");
		Select cmbCountry = new Select(cmbCo);
		cmbCountry.selectByVisibleText(tax.getCountry());
		
		logger.log("Clicking on the Save button");
		this.btnSave.click();
		
	}
	
}