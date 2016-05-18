package com.johndeere.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.johndeere.domain.logger.Logger;

public abstract class GeneralTest{
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	protected WebDriver driver;

	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to prepare the environment 
	 */
	public abstract void prepareEnvironment();
	
	/**
	 * Initialize
	 */
	public void Initialize(){
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	/**
	 * Function to verify the result of the test
	 * @param text - (String) text to check that is appearing in page
	 * @return
	 */
	public boolean checkResult(String text){ 

		try{
			
			Thread.sleep(5000);
			WebElement bodyTag = driver.findElement(By.tagName("body")); 
			
			if (bodyTag.getText().contains(text)){ 
			
				return true; 
			
			} 
			
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}
		
		return false;

	}
	
	/**
	 * Function to close driver
	 */
	public void closeDriver(Logger logger){
			
		logger.log("Closing browser \n");
		driver.close();
				
	}
	
}