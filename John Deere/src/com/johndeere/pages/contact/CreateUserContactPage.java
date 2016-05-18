package com.johndeere.pages.contact;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.domain.objects.Contact;
import com.johndeere.pages.Page;

public class CreateUserContactPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="name_firstName")
	private WebElement txtFirstName;
	
	@FindBy(how=How.ID, using="name_lastName")
	private WebElement txtLastName;
	
	@FindBy(how=How.ID, using="Email")
	private WebElement txtEmail;
	
	@FindBy(how=How.ID, using="Username")
	private WebElement txtUsername;
	
	@FindBy(how=How.ID, using="CommunityNickname")
	private WebElement txtNickname;
	
	@FindBy(how=How.ID, using="user_license_id")
	private WebElement cmbUserLi;
	
	@FindBy(how=How.ID, using="Profile")
	private WebElement cmbProfile;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
		
		
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to create user contact
	 * @param contact - (Contact) Contact
	 */
	public void createUser(Contact contact){
		
		logger.log("Providing first name");
		this.txtFirstName.clear();
		this.txtFirstName.sendKeys(contact.getFirstName());
		
		logger.log("Providing last name");
		this.txtLastName.clear();
		this.txtLastName.sendKeys(contact.getLastName());
		
		logger.log("Providing email");
		this.txtEmail.clear();
		this.txtEmail.sendKeys(contact.getEmail());
		
		logger.log("Providing username");
		this.txtUsername.clear();
		this.txtUsername.sendKeys(contact.getUsername());
		
		logger.log("Providing nickname");
		this.txtNickname.clear();
		this.txtNickname.sendKeys(contact.getNickname());
		
		if(!contact.getUserLicense().equals("")){
			
			logger.log("Selecting User License");
			Select cmbUserLicense = new Select(this.cmbUserLi);
			cmbUserLicense.selectByVisibleText(contact.getUserLicense());
			
		}
		
		logger.log("Selecting profile");
		Select cmbProfile = new Select(this.cmbProfile);
		cmbProfile.selectByVisibleText(contact.getProfile());
		
		logger.log("Saving user contact");
		this.btnSave.click();
		
	}
	
}