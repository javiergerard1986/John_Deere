package com.johndeere.pages.community;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class CommunityLoginPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.LINK_TEXT, using=" Login ")
	private WebElement lnkLogin;
	
	@FindBy(how=How.NAME, using="j_id0:j_id1:j_id16:j_id17:j_id18:j_id22")
	private WebElement txtUsername;
	
	@FindBy(how=How.NAME, using="j_id0:j_id1:j_id16:j_id17:j_id18:j_id24")
	private WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="j_id0:j_id1:j_id16:j_id17:j_id18:j_id26")
	private WebElement btnLogin;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to login into the John Deere Community
	 * @param username - (String)
	 * @param password - (String)
	 */
	public void changeAccountOwner (String username, String password){

		logger.log("Clicking on the Login button");
		this.lnkLogin.click();
		
		logger.log("Providing username");
		this.txtUsername.clear();
		this.txtUsername.sendKeys(username);
		
		logger.log("Providing password");
		this.txtPassword.clear();
		this.txtPassword.sendKeys(password);
		
		logger.log("Clicking on the Login button");
		this.btnLogin.click();
		
	}
	
}