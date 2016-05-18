package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.domain.objects.Contact;
import com.johndeere.pages.Page;

public class CreateContactPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="name_firstcon2")
	private WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="name_lastcon2")
	private WebElement txtLastName;
	
	@FindBy(how=How.ID, using="con4")
	private WebElement txtAccount;
	
	@FindBy(how=How.ID, using="con15")
	private WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a contact
	 * @param contact - (Contact) Contact to create
	 */
	public void createContact (Contact contact){
		
		logger.log("Providing first name");
		this.txtFirstName.sendKeys(contact.getFirstName());
			
		logger.log("Providing last name");
		this.txtLastName.sendKeys(contact.getLastName());
		
		logger.log("Providing account");
		this.txtAccount.clear();
		this.txtAccount.sendKeys(contact.getAccountName());
			
		logger.log("Providing email");
		this.txtEmail.sendKeys(contact.getEmail());
		
		logger.log("Clicking on saving contact");
		this.btnSave.click();
		
	}
	
}