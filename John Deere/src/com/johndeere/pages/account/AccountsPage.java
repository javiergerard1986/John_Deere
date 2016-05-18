package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class AccountsPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="new")
	private WebElement btnNew;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create an Account
	 */
	public void accessIntoNewAccountPage (){
		
		logger.log("Clicking on the new button");
		this.btnNew.click();
		
	}
	
}