package com.johndeere.domain;

public class CreateRecords extends GeneralRecord{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static CreateRecords instance;

	public static CreateRecords getInstance() {

		if (instance == null) {

			instance = new CreateRecords();

		}

		return instance;

	}

	private CreateRecords() {
	
		
		
	}
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create records
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 * @param object - (String) This is the object record that we are creating
	 * @param person - (String) QA that is executing the test data generator
	 * @return - (String) Message with execution status
	 */
	public String createRecords(String executionType, String object, String person){
		
		String message = "";
		
		try{
			
			//Load accounts Input File
			this.loadInputFile(executionType, object, person);
			
			//Read rows
			while(reader.readRecord()){
		
				totalCount++;
				
				try{
					
					//Load contact
					this.loadRecordVariables(object);		
					
					//Create accounts
					if(this.createRecord(object)){
							
						logger.log("\nCREATION SUCCESS\n");
						passCount++;
						
					}else{
						
						logger.log("\nCREATION FAIL\n");
						
						//Adding failed record to Array that will be converted to the failed scenarios file
						this.addFailedRecordToArray(object);
						
						failCount++;
						
					}
					
					//Close driver
					this.closeBrowser(object);
					
				}catch(Exception ex){
					
					logger.log("\nCREATION FAIL\n");
					logger.log("Error: " + ex.getMessage() + "\n");
					
					//Close driver
					this.closeBrowser(object);
					
					//Adding failed record to Array that will be converted to the failed scenarios file
					this.addFailedRecordToArray(object);
					
					failCount++;
					
				}
										
			}
		
		}catch(Exception ex){
			
			logger.log("Problem loading the input file. Please contact the administrator");
			
			logger.log("Closing driver");
			this.closeBrowser(object);
			
		}finally{
			
			//Close input file
			reader.close();
			
			logger.log("\nCreating Failed " + object + " Records file");
			this.createFailedScenariosFile(object);
			logger.log("File created\n");
			
			//Create log bottom
			logger.generateBottom(object, totalCount, passCount, failCount);
		
			//Create Log file
			txtFile.createLogFile(object, logger.getInfoToLog(), executionType);
			
			//Clear log
			logger.clearLog();
			
			//Generate message
			message = this.generateMessage(object);
			
			//Reset variables
			resetVariables(object);
			
		}
		
		return message;
		
	}
	
}