package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class AccountOwnerPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="newOwn")
	private WebElement txtOwner;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	@FindBy(how=How.NAME, using="cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to navigate to the AccountOwnerPage 
	 * @param accountOwner - (String) accountOwner
	 */
	public void changeAccountOwner (String accountOwner){

		txtOwner.sendKeys(accountOwner);
		this.btnSave.click();
		
	}
	
}