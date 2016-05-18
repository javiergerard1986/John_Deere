package com.johndeere.pages.group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.johndeere.pages.Page;

public class GroupsPage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="newGroup")
	private WebElement btnNewGroup;
	
	@FindBy(how=How.LINK_TEXT, using="Next Page>")
	private WebElement lnkNextPage;
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to navigate to the Create Group page
	 */
	public void navigateToCreateGroupPage(){
		
		this.logger.log("Clicking on New Group button");
		this.btnNewGroup.click();
		
	}
	
	/**
	 * Function to search and click on a group in page
	 * @param groupName - (String) This is the name of the group to search
	 */
	public void searchAndClickInGroup(String groupName, WebDriver driver){
		
		boolean elementPresent = this.isElementInPage(groupName, driver);
		int x = 0;
		
		while(!elementPresent){
			
			x += 1;
			
			logger.log("Clicking for the " + x + " time in the next page link");
			this.lnkNextPage.click();
			
			elementPresent = this.isElementInPage(groupName, driver);
			
		}
		
		this.logger.log("Clicking on searched record link");
		WebElement lnkRecord = driver.findElement(By.linkText(groupName));
		lnkRecord.click();
		
	}
	
}