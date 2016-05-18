package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.pages.Page;

public class ContactTypePage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="p3")
	private WebElement cmbct;
	
	@FindBy(how=How.XPATH, using=".//*[@id='bottomButtonRow']/input[1]")
	private WebElement btnContinue;
	
	@FindBy(how=How.NAME, using="btnCancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to select an account type
	 * @param accountType - (String)
	 */
	public void selectContactType(String contactType){
			
		Select cmbContactType = new Select(cmbct);
		cmbContactType.selectByVisibleText(contactType);
		this.btnContinue.click();
				
	}
	
}