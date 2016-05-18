package com.johndeere.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.johndeere.domain.logger.Logger;
import com.johndeere.utils.Util;

public abstract class Page {

	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	protected Logger logger = Logger.getInstance();
	protected Util util = Util.getInstance();
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to search an element on the page
	 * @param recordName - (String) This is the record to search	
	 * @param driver - (WebDriver driver)
	 * @return boolean - If the element is in page returns true, otherwise returns false
	 */
	protected boolean isElementInPage(String recordName, WebDriver driver){
	
		try{
		
			Thread.sleep(2500);
			WebElement bodyTag = driver.findElement(By.tagName("body")); 
		
			if (bodyTag.getText().contains(recordName)){ 
		
				return true; 
		
			} 
		
		}catch(Exception ex){
		
			System.out.println(ex.getMessage());
		
		}
	
		return false;
		
	}
	
}