package com.johndeere.pages.group;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.johndeere.domain.objects.Group;
import com.johndeere.pages.Page;

public class CreateGroupPage extends Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.ID, using="p2")
	private WebElement txtGroupLabel;
	
	@FindBy(how=How.ID, using="dn")
	private WebElement txtGroupName;
	
	@FindBy(how=How.NAME, using="sharing_search")
	private WebElement cmbSe;
	
	@FindBy(how=How.NAME, using="searchValue_sharing_search")
	private WebElement txtSearch;
	
	@FindBy(how=How.NAME, using="go_duel_select_0")
	private WebElement btnSearch;
	
	@FindBy(how=How.NAME, using="duel_select_0")
	private WebElement cmbUs;
	
	@FindBy(how=How.ID, using="duel_select_0_right")
	private WebElement btnAddContacts;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create a new Group
	 * @param - (group) Group to create
	 */
	public void createGroup(Group group){
		
		this.logger.log("Providing Group Label");
		this.txtGroupLabel.clear();
		this.txtGroupLabel.sendKeys(group.getGroupLabel());
		
		this.logger.log("Providing Group Name");
		this.txtGroupName.clear();
		this.txtGroupName.sendKeys(group.getGroupName());
		
		this.logger.log("Adding user into the group");
		this.addUsers(group.getUser());
		
		this.logger.log("Clicking on Save button");
		this.saveGroup();
		
	}
	
	/**
	 * Function to add an user into the group
	 * @param userName - (String) name of user to add into the group
	 */
	public void addUsers(String userName){
		
		this.logger.log("Selecting type of search of user selection");
		Select cmbSearch = new Select(this.cmbSe);
		cmbSearch.selectByVisibleText("Partner Users");
		
		this.logger.log("Adding users to the group");
		Select cmbUsers = new Select(this.cmbUs);
		
		this.logger.log("Searching user to add");
		this.txtSearch.clear();
		this.txtSearch.sendKeys(userName);
			
		this.logger.log("Clicking on Find button");
		this.btnSearch.click();
		
		this.logger.log("Adding user 1");
		cmbUsers.selectByVisibleText("Partner User: " + userName);
				
		this.logger.log("Clicking on Add Contacts button");
		this.btnAddContacts.click();
		
	}
	
	/**
	 * Function to save the group
	 */
	public void saveGroup(){
		
		this.btnSave.click();
		
	}
	
}