package com.johndeere.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.pages.Page;

public class AccountTypePage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="p3")
	private WebElement cmbat;
	
	@FindBy(how=How.XPATH, using=".//*[@id='bottomButtonRow']/input[1]")
	private WebElement btnContinue;
	
	@FindBy(how=How.NAME, using="cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to select an account type
	 * @param accountType - (String)
	 */
	public void selectAccountType(String accountType){
			
		Select cmbAccountType = new Select(cmbat);
		cmbAccountType.selectByVisibleText(accountType);
		this.btnContinue.click();
				
	}
	
}