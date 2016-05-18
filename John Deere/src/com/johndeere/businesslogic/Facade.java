package com.johndeere.businesslogic;

import java.util.ArrayList;

public class Facade {

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Facade instance;
		
	public static Facade getInstance(){
			
		if(instance == null){
				
			instance = new Facade();
			
		}
			
		return instance;
			
	}
	
	private Facade(){
	
		this.recordServices = RecordsServices.getInstance();
		this.rRequisitesServices = RequiredRequisitesServices.getInstance();
		
	}
	
	
	//---------------------------------------------
	//ATRIBUTES
	//---------------------------------------------
	private RecordsServices recordServices;
	private RequiredRequisitesServices rRequisitesServices;
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to create required pre-requisites in the system before start to use this application
	 * @param objects - (ArrayList<String>) - List of objects that will be created
	 * @return String with instructions to finish to set the environment
	 */
	public String createPreRequisites(ArrayList<String> objects){
		
		return rRequisitesServices.createPreRequisites(objects);
		
	}
	
	/**
	 * * Function to create records
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 * @param object - (String) This is the object record that we are creating
	 * @param person - (String) QA that is executing the test data generator
	 * @return - (String) General execution status message
	 */
	public String createRecords(String executionType, String object, String person){
		
		return this.recordServices.createRecords(executionType, object, person);
		
	}
	
}