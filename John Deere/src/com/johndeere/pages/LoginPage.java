package com.johndeere.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="username")
	private WebElement txtUsername;
	
	@FindBy(how=How.ID, using="password")
	private WebElement txtPassword;
	
	@FindBy(how=How.ID, using="Login")
	private WebElement btnLogin;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Method to login into the system
	 * @param username - (String) username
	 * @param password - (String) password
	 */
	public void login(String username, String password){
		
		this.logger.log("Providing username");
		this.txtUsername.sendKeys(username);
		
		this.logger.log("Providing password");
		this.txtPassword.clear();
		this.txtPassword.sendKeys(password);
		
		this.logger.log("Clicking on login button");
		this.btnLogin.click();
		
	}

}