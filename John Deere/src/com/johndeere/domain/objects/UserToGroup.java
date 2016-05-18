package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class UserToGroup extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static UserToGroup instance;
				
	public static UserToGroup getInstance(){
			
		if (instance == null) {

			instance = new UserToGroup();

		}

		return instance;

	}

	private UserToGroup() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String groupName;
	private String user;
	
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getUser(){
		return this.user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public UserToGroup(String groupName, String user){
	
		this.groupName = groupName;
		this.user = user;
		
	}
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to load variables from the csv file
	 * @param reader (CsvReader) input file
	 * @throws Exception
	 */
	@Override
	public void loadVariables(CsvReader reader) throws Exception {
		
		this.groupName = reader.get(0);
		this.user = reader.get(1);
		
	}

	/**
	 * Function to reset the UserToGroup variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.groupName = "";
		this.user = "";
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
		
		//Writing header
		csvOutput.write("GroupName");
		csvOutput.write("User");
				
		csvOutput.endRecord();
	
	}
	
	/**
	 * Function to create file lines 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @param lines - (ArrayList<String>) This contains all failed records
	 * @throws Exception
	 */
	@Override
	public void createFileLines(CsvWriter csvOutput, @SuppressWarnings("rawtypes")ArrayList lines) throws Exception {
		
		for(int x = 0; x < lines.size(); x++){
			
			UserToGroup group = (UserToGroup)lines.get(x);
		    csvOutput.write(group.getGroupName());
		    csvOutput.write(group.getUser());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}