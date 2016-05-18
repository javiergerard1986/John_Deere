package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.domain.objects.Account;
import com.johndeere.pages.Page;

public class CreateAccountPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="acc2")
	private WebElement txtAccountName;
		
	@FindBy(how=How.ID, using="acc3")
	private WebElement txtParentAccount;
	
	@FindBy(how=How.ID, using="00N7A000000G0p7")
	private WebElement txtLogoUrl;
	
	@FindBy(how=How.NAME, using="acc17street")
	private WebElement txtStreet;
			
	@FindBy(how=How.NAME, using="acc17city")
	private WebElement txtCity;
					
	@FindBy(how=How.NAME, using="acc17state")
	private WebElement txtState;
							
	@FindBy(how=How.NAME, using="acc17zip")
	private WebElement txtPostalCode;
	
	@FindBy(how=How.ID, using="00N7A000000G0pO")
	private WebElement cmbr;
	
	@FindBy(how=How.ID, using="acc17country")
	private WebElement txtCountry;
	
	@FindBy(how=How.NAME, using="00N7A000000G0pd")
	private WebElement txtSupportPhone;
			
	@FindBy(how=How.NAME, using="00N7A000000G0pc")
	private WebElement txtSupportEmail;
	
	@FindBy(how=How.NAME, using="00N7A000000G0og")
	private WebElement txtBillingEmail;
	
	@FindBy(how=How.NAME, using="00N7A000000G0p9")
	private WebElement txtMJDOrgId;
	
	@FindBy(how=How.NAME, using="0BC7A000000CaZk")
	private WebElement txtLatitude;
	
	@FindBy(how=How.NAME, using="0BC7A000000CaZl")
	private WebElement txtLongitude;
	
	@FindBy(how=How.NAME, using="00N7A000000SZeh")
	private WebElement txtTaxExemptionCertificateId;
	
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
	 * Function to create an account 
	 * @param account (Account) Account to create
	 */
	public void createAccount(Account account){
		
		Select cmbRegion = new Select(cmbr);
		
		logger.log("Providing AccountName");
		this.txtAccountName.sendKeys(account.getAccountName());
		
		logger.log("Setting Parent Account");
		if (!account.getParentAccount().equals("")){
			
			this.txtParentAccount.sendKeys(account.getParentAccount());
			
		}
		
		logger.log("Selecting region");
		if (!account.getRegion().equals("")){
			
			cmbRegion.selectByVisibleText(account.getRegion());
			
		}
		
		logger.log("Providing country");
		if (!account.getCountry().equals("")){
			
			this.txtCountry.sendKeys(account.getCountry());
		
		}
		
		logger.log("Providing street");
		if (!account.getStreet().equals("")){
			
			this.txtStreet.sendKeys(account.getStreet());
		
		}
		
		logger.log("Providing city");
		if (!account.getCity().equals("")){
			
			this.txtCity.sendKeys(account.getCity());
		
		}
		
		logger.log("Providing state");
		if (!account.getState().equals("")){
			
			this.txtState.sendKeys(account.getState());
		
		}
		
		logger.log("Providing postal code");
		if (!account.getPostalCode().equals("")){
			
			this.txtPostalCode.sendKeys(account.getPostalCode());
		
		}
		
		logger.log("Providing Support Phone");
		if (!account.getSupportPhone().equals("")){
			
			this.txtSupportPhone.sendKeys(account.getSupportPhone());
		
		}
		
		logger.log("Providing Support Email");
		if (!account.getSupportEmail().equals("")){
			
			this.txtSupportEmail.sendKeys(account.getSupportEmail());
		
		}
		
		logger.log("Providing Billing Email");
		if(!account.getBillingEmail().equals("")){
			
			this.txtBillingEmail.sendKeys(account.getBillingEmail());
			
		}
		
		logger.log("Providing MJD Org Id");
		if(!account.getMJDOrgId().equals("")){
			
			this.txtMJDOrgId.sendKeys(account.getMJDOrgId());
			
		}
		
		logger.log("Providing Latitude");
		if(!account.getLatitude().equals("")){
			
			this.txtLatitude.sendKeys(util.setFormatLatitudeOrLongitude(account.getLatitude()));
			
		}
		
		logger.log("Providing Longitude");
		if(!account.getLongitude().equals("")){
			
			this.txtLongitude.sendKeys(util.setFormatLatitudeOrLongitude(account.getLongitude()));
			
		}
		
		logger.log("Providing Tax Exemption Certificate Id");
		if(!account.getTaxExemptionCertificateId().equals("")){
			
			this.txtTaxExemptionCertificateId.sendKeys(account.getTaxExemptionCertificateId());
			
		}
		
		logger.log("Clicking on save button");
		this.btnSave.click();
		
	}
	
}