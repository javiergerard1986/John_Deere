package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class ContactsPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="new")
	private WebElement btnNew;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a contact
	 */
	public void acessIntoCreateContact (){
		
		logger.log("Clicking on the new button");
		this.btnNew.click();
	}
	
}