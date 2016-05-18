package com.johndeere.businesslogic;

import com.johndeere.domain.CreateRecords;

public class RecordsServices {

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static RecordsServices instance;

	public static RecordsServices getInstance() {

		if (instance == null) {

			instance = new RecordsServices();

		}

		return instance;

	}

	private RecordsServices() {
		
		cr = CreateRecords.getInstance();
		
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private CreateRecords cr;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create records
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 * @param object - (String) This is the object record that we are creating
	 * @param person - (String) QA that is executing the test data generator
	 * @return - (String) General execution status message
	 */
	public String createRecords(String executionType, String object, String person){
		
		return cr.createRecords(executionType, object, person);
			
	}
	
}