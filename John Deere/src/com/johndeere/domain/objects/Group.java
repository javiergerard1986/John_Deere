package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Group extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Group instance;
				
	public static Group getInstance(){
			
		if (instance == null) {

			instance = new Group();

		}

		return instance;

	}

	private Group() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String groupLabel;
	private String groupName;
	private String user;
	private boolean synch;
		
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getGroupLabel() {
		return groupLabel;
	}

	public void setGroupLabel(String groupLabel) {
		this.groupLabel = groupLabel;
	}

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
	
	public boolean getSynch() {
		return synch;
	}

	public void setSynch(boolean synch) {
		this.synch = synch;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public Group(String groupLabel, String groupName, String user, boolean synch){
	
		this.groupLabel = groupLabel;
		this.groupName = groupName;
		this.user = user;
		this.synch = synch;
		
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
		
		this.groupLabel = reader.get(0);
		this.groupName = reader.get(1);
		this.user = reader.get(2);
		this.synch = Boolean.parseBoolean(reader.get(3));
		
	}

	/**
	 * Function to reset the Group variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.groupLabel = "";
		this.groupName = "";
		this.user = "";
		this.synch = true;
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
		
		//Writing header
		csvOutput.write("GroupLabel");
		csvOutput.write("GroupName");
		csvOutput.write("User");
		csvOutput.write("Synchronized");
				
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
			
			Group group = (Group)lines.get(x);
			csvOutput.write(group.getGroupLabel());
		    csvOutput.write(group.getGroupName());
		    csvOutput.write(group.getUser());
		    csvOutput.write(String.valueOf(group.getSynch()));
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}