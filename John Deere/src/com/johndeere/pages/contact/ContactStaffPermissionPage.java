package com.johndeere.pages.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.pages.Page;

public class ContactStaffPermissionPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="CF00N7A000000G12M")
	WebElement txtAccount;
	
	@FindBy(how=How.NAME, using="CF00N7A000000G12N")
	WebElement txtContact;
	
	@FindBy(how=How.NAME, using="00N7A000000G12O")
	WebElement cmbRo;
	
	@FindBy(how=How.NAME, using="save")
	WebElement btnSave;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create new staff Permission
	 * @param permissionOnAccount - (String) This is the account in which we will give permission
	 * @param contactName - (String) This is the contact that we will give permission
	 * @param role - (String) This is the role-permission that we will give to the contact
	 */
	public void createStaffPermission(String permissionOnAccount, String contactName, String role){
		
		logger.log("Providing Grower Account");
		this.txtAccount.clear();
		this.txtAccount.sendKeys(permissionOnAccount);
		
		logger.log("Providing Contact Name");
		this.txtContact.clear();
		this.txtContact.sendKeys(contactName);
		
		logger.log("Selecting Role Permission");
		Select cmbRole = new Select(cmbRo);
		cmbRole.selectByVisibleText(role);
		this.btnSave.click();
		
	}
	
	/**
	 * Function to return to the Contact Record page
	 * @param - (String) ContactName
	 * @param - (WebDriver) WebDriver
	 */
	public void returnToContactRectordPage(String contactName, WebDriver driver){
		
		WebElement lnkContactRecord = driver.findElement(By.linkText(contactName));
		lnkContactRecord.click();
		
	}
	
}