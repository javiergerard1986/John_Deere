package com.johndeere.ui;

import com.johndeere.businesslogic.Facade;

public class ConsoleInterface {

	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private static Facade facade = Facade.getInstance();
	
	
	//---------------------------------------------
	//VOIDS AND FUNCTIONS
	//---------------------------------------------
	public static void main(String[] args) {
		
		//Create pre-requisites to use this system
		//facade.createPreRequisites();
		
		//Create Accounts
	    facade.createRecords("Base Execution", "Accounts", "Javier");
	    facade.createRecords("Base Execution", "Contacts", "Javier");
	    facade.createRecords("Base Execution", "Grower Dealer Association", "Javier");
	    facade.createRecords("Base Execution", "Groups", "Javier");
	    
	}
	
}