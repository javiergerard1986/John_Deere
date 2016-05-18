package com.johndeere.domain.file;

import java.io.File;

public class CsvFile {

	//------------------------------------
	//SINGLETON
	//------------------------------------
	private static CsvFile instance;
	
	public static CsvFile getInstance(){
			
		if(instance == null){
				
			instance = new CsvFile();
			
		}
			
		return instance;
			
	}
	
	private CsvFile(){
	
		
		
	}
	
	
	//------------------------------------
	//ATTRIBUTES
	//------------------------------------
	/**
	 * Function to load input file
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 * @param object - (String) This is the object record that we are creating
	 * @param person - (String) QA that is executing the test data generator
	 * @return String with the proper file path, considering the executionType and object
	 * @throws Exception
	 */
	public String loadInputFile(String executionType, String object, String person) throws Exception{
		
		String path = "";
		
		if(executionType.equals("Base Execution")){
			
			if(person.equals("Javier")){
			
				path = "C:\\\\Automation\\Input Files\\" + object + "\\Base Execution\\" + object + ".csv";
				
			}else{
				
				path = "C:\\\\Automation\\Input Files\\" + object + "\\Base Execution\\Vinod - " + object + ".csv";
				
			}
		
		}
		
		if(executionType.equals("Failed Execution")){
		
			path = "C:\\\\Automation\\Input Files\\" + object + "\\Failed Scenarios\\Failed " + object + ".csv";
		
		}
		
		if(executionType.equals("Test Class")){
			
			path = "C:\\\\Automation\\Input Files\\" + object + "\\Test Class\\" + object + ".csv";
			
		}
		
		return path;
		
	}
	
	/**
	 * Function to create failed scenarios folder
	 * @param object - (String) Object record that we are trying to create, this will be used to define the path to the failed scenarios csv file
	 */
	public void createFailedScenariosFolder(String object){
		
		String path = "C:\\\\Automation\\Input Files\\" + object + "\\Failed Scenarios";
	
		File file = new File(path);
		file.mkdir();
		
	}
	
	/**
	 * Function to check and delete an existing file
	 * @param outputFile - (String) This is the path of the file to check
	 */
	public void checkFileExistence(String outputFile){
		
		boolean alreadyExists = new File(outputFile).exists();
		
	    if(alreadyExists){
	       
	    	File failedScenariosFile = new File(outputFile);
	        failedScenariosFile.delete();
	    
	    }
		
	}
	
}