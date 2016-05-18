package com.johndeere.pages.preoffer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.johndeere.domain.objects.PreOffer;
import com.johndeere.pages.Page;

public class PreOfferAddUsersPage extends Page{

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	@FindBy(how=How.NAME, using="sharing_search")
	private WebElement cmbSearchTy;
	
	@FindBy(how=How.NAME, using="searchValue_sharing_search")
	private WebElement txtSearch;
	
	@FindBy(how=How.NAME, using="go_duel_select_0")
	private WebElement btnSearch;
	
	@FindBy(how=How.ID, using="duel_select_0")
	private WebElement cmbGro;
	
	@FindBy(how=How.ID, using="duel_select_0_right")
	private WebElement btnAddGroup;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement btnSave;
	
	@FindBy(how=How.NAME, using="cancel")
	private WebElement btnCancel;
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to share pre offer to users, groups
	 * @param driver (WebDriver)
	 * @param preOffer (PreOffer)
	 */
	public void sharePreOfferWithUsersGroups (WebDriver driver, PreOffer preOffer){
		
		logger.log("Selecting the Groups option in the search dropdown");
		Select cmbSearchType = new Select(cmbSearchTy);
		cmbSearchType.selectByVisibleText("Public Groups");
		
		logger.log("Providing Group to search");
		this.txtSearch.clear();
		this.txtSearch.sendKeys(preOffer.getGroupName());
		
		logger.log("Clicking on Search button");
		this.btnSearch.click();
		
		this.logger.log("Clicking on searched option");
		Select cmbGroups = new Select(cmbGro);
		cmbGroups.selectByVisibleText("Group: " + preOffer.getGroupName());
		
		this.logger.log("Clicking on Add User / Group button");
		this.btnAddGroup.click();
		
		this.logger.log("Clicking on Save button");
		this.btnSave.click();
		
	}
	
}