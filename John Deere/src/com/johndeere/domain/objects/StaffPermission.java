package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class StaffPermission extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static StaffPermission instance;
				
	public static StaffPermission getInstance(){
			
		if (instance == null) {

			instance = new StaffPermission();

		}

		return instance;

	}

	private StaffPermission() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String contactName;
	private String permissionType;
	private String permissionOnAccount;
	private String role;
		
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	
	public String getPermissionOnAccount() {
		return permissionOnAccount;
	}

	public void setPermissionOnAccount(String permissionOnAccount) {
		this.permissionOnAccount = permissionOnAccount;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public StaffPermission(String contactName, String permissionType, String permissionOnAccount, String role){
	
		this.contactName = contactName;
		this.permissionType = permissionType;
		this.permissionOnAccount = permissionOnAccount;
		this.role = role;
		
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
		
		this.contactName = reader.get(0);
		this.permissionType = reader.get(1);
		this.permissionOnAccount = reader.get(2);
		this.role = reader.get(3);
		
	}

	/**
	 * Function to reset the staff permission variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.contactName = "";
		this.permissionType = "";
		this.permissionOnAccount = "";
		this.role = "";
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
		
		//Writing header
		csvOutput.write("ContactName");
		csvOutput.write("StaffPermissionType");
		csvOutput.write("PermissionOnAccount");
		csvOutput.write("Role");
				
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
			
			StaffPermission staffPermission = (StaffPermission)lines.get(x);
		    csvOutput.write(staffPermission.getContactName());
		    csvOutput.write(staffPermission.getPermissionType());
		    csvOutput.write(staffPermission.getPermissionOnAccount());
		    csvOutput.write(staffPermission.getRole());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}