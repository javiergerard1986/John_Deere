package com.johndeere.domain.logger;

import java.util.ArrayList;

public class Logger {

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Logger instance;

		public static Logger getInstance() {

			if (instance == null) {

				instance = new Logger();

			}

			return instance;

		}

	private Logger() {
		
		this.infoToLog = new ArrayList<String>();
		
	}
			
			
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private ArrayList<String> infoToLog;
	
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public ArrayList<String> getInfoToLog() {
		return infoToLog;
	}

	public void setInfoToLog(ArrayList<String> infoToLog) {
		this.infoToLog = infoToLog;
	}
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create log title 
	 * @param totalCount - (int) This is the count number of records that are being created
	 * @param objectTitle - (String) This is the kind of record that we are creating, example: Account, Contact
	 * @param recordName - (String) This is the name of the record that we are creating
	 */
	public void generateTitle(int totalCount, String objectTitle, String recordName){
		
		log("----------------------------------------------------------------------------------");
		log("Creating " + objectTitle +" Record " + totalCount + ": " + recordName);
		log("----------------------------------------------------------------------------------");
		
		
	}

	/**
	 * Function to create log bottom
	 * @param object - (String) This is the record type to create
	 * @param totalCount - (int) This is the count number of records that are being created
	 * @param passCount - (int) This is the total number of records successfully created
	 * @param failCount - (int) This is the total number of failed records
	 */
	public void generateBottom(String object, int totalCount, int passCount, int failCount){
		
		log("----------------------------------------");
		log("----------------------------------------");
		log("Total " + object + ": " + totalCount);
		log("Total " + object + " successfully created: " + passCount);
		log("Total " + object + " failed: " + failCount);
		log("----------------------------------------");
		log("----------------------------------------");
		
	}
	
	/**
	 * Function to log information 
	 * @param newLine - (String) Line to log
	 */
	public void log(String newLine){
		
		System.out.println(newLine);
		
		if(newLine.contains("\n")){
			
			newLine = newLine.replaceAll("\n", "\r\n");
			
		}
		
		infoToLog.add(newLine + "\r\n");	
		
	}
	
	/**
	 * Function to clear log 
	 */
	public void clearLog(){
		
		this.infoToLog.clear();
		
	}
	
}