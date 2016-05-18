package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.domain.objects.GrowerDealerAssociation;
import com.johndeere.pages.Page;

public class GrowerDealerAssociationPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="CF00N7A000000G0t2")
	private WebElement txtDealerAccount;
	
	@FindBy(how=How.NAME, using="CF00N7A000000G0t3")
	private WebElement txtGrowerAccount;
	
	@FindBy(how=How.NAME, using="00N7A000000G0t4")
	private WebElement cmbRT;
	
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
	 * Function to create a Grower - Dealer association 
	 * @param dealerAccount - (String) Dealer Account
	 * @param growerAccount - (String) Grower Account
	 */
	public void createGrowerDealerAssociation (GrowerDealerAssociation gda){

		this.logger.log("Providing Dealer Account");
		this.txtDealerAccount.clear();
		this.txtDealerAccount.sendKeys(gda.getDealerAccountName());
		
		this.logger.log("Providing Grower Account");
		this.txtGrowerAccount.clear();
		this.txtGrowerAccount.sendKeys(gda.getGrowerAccountName());
		
		this.logger.log("Selecting Relationship Type");
		Select cmbRelationshipType = new Select(cmbRT);
		cmbRelationshipType.selectByVisibleText(gda.getRelationshipType());
		
		this.logger.log("Clicking on Save button");
		this.btnSave.click();
		
	}
	
}