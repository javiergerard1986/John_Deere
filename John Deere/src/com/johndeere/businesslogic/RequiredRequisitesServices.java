package com.johndeere.businesslogic;

import java.io.File;
import java.util.ArrayList;

public class RequiredRequisitesServices {

	
	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static RequiredRequisitesServices instance;
			
	public static RequiredRequisitesServices getInstance(){
				
		if(instance == null){
					
			instance = new RequiredRequisitesServices();
				
		}
				
		return instance;
				
	}
		
	private RequiredRequisitesServices(){
	
		
		
	}
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create required pre-requisites to be able to use this system
	 * @param objects - (ArrayList<String>) - List of objects that will be created
	 * @return String with instructions to finish to set the environment
	 */
	public String createPreRequisites(ArrayList<String> objects){
		
		//Create required folders
		this.createRequiredFolders(objects);
		
		return "";
		
		//Provide instruction about libraries to copy
		//return libraryToCopyInstructions();
		
	}
	
	/**
	 * Function to create required folders 
	 * @param objects - (ArrayList<String>) - List of objects that will be created
	 */
	public void createRequiredFolders(ArrayList<String> objects){
		
		for(int x = 0; x < objects.size(); x++){
			
			String object = objects.get(x);
			
			//Folder to upload input Account files
			File baseExecutionRecordFolder = new File("C:\\\\Automation\\Input Files\\" + object + "\\Base Execution");
			File failedExecutionRecordFolder = new File("C:\\\\Automation\\Input Files\\" + object + "\\Failed Scenarios");
			File testRecordFolder = new File("C:\\\\Automation\\Input Files\\" + object + "\\Test Class");
			
			//Folder where the logs will be saved
			File logsFolder = new File("C:\\\\Automation\\Logs\\" + object);
			
			baseExecutionRecordFolder.mkdirs();
			failedExecutionRecordFolder.mkdirs();
			testRecordFolder.mkdirs();
			logsFolder.mkdirs();
			
		}
				
	}
	
	/**
	 * Function to specify libraries to copy in the system 
	 * @return String with instruction to finish to set the environment
	 */
	public String libraryToCopyInstructions(){
		
		String instructions = "---------------------------------------------\n";
		instructions += "---------------------------------------------\n";
		instructions += "---              INSTRUCTIONS             ---\n";
		instructions += "---------------------------------------------\n";
		instructions += "---------------------------------------------\n\n";
		instructions += "1. Copy inside the following path: \n\n";
		instructions += "\"C:\\\\Automation libs\"\n\n";
		instructions += "the javacsv-2.0.jar file \n\n\n";
		instructions += "2. Copy inside the following path: \n\n";
		instructions += "\"C:\\\\Automation libs\" \n\n";
		instructions += "the \"selenium-2.48.2\" folder with all the selenium jar files  \n\n\n";
		instructions += "3. Create inside the following path: \n\n";
		instructions += "\"C:\\\\Automation\\Input Files\\<objectToCreateRecords>\"\n\n";
		instructions += "the csv files that you will you to create your object records \n\n\n";
		instructions += "4. Execute the program and have fun!!!";
		return instructions;
		
	}

}