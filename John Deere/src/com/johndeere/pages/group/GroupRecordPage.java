package com.johndeere.pages.group;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class GroupRecordPage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="edit")
	private WebElement btnEdit;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to navigate to the create edit group page
	 */
	public void navigateToCreateEditGroupPage(){
		
		this.logger.log("Clicking on the Edit button");
		this.btnEdit.click();
		
	}
	
}