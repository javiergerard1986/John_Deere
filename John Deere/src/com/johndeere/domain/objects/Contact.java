package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.johndeere.constants.Constants;

public class Contact extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Contact instance;
			
	public static Contact getInstance(){
		
		if (instance == null) {

			instance = new Contact();

		}

		return instance;

	}

	private Contact() {

			
			
	}
	
	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String accountName;
	private String contactType;
	private String firstName;
	private String lastName;
	private String email;
	private String partnerType;
	private String username ;
	private String nickname;
	private String userLicense;
	private String profile;
	private boolean apptusCpqMarkPermission;
	private boolean apttusCpqUserPermission;
	private boolean apptusCpqMarkV1Permission;
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getContactType() {
		return contactType;
	}
	
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPartnerType() {
		return partnerType;
	}
	
	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getUserLicense(){
		return userLicense;
	}
	
	public void setUserLicense(String userLicense){
		this.userLicense = userLicense;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public boolean getApptusCpqMarkPermission() {
		return apptusCpqMarkPermission;
	}

	public void setApptusCpqMarkPermission(boolean apptusCpqMarkPermission) {
		this.apptusCpqMarkPermission = apptusCpqMarkPermission;
	}

	public boolean getApttusCpqUserPermission() {
		return apttusCpqUserPermission;
	}

	public void setApttusCpqUserPermission(boolean apttusCpqUserPermission) {
		this.apttusCpqUserPermission = apttusCpqUserPermission;
	}
	
	public boolean getApptusCpqMarkV1Permission() {
		return apptusCpqMarkV1Permission;
	}

	public void setApptusCpqMarkV1Permission(boolean apptusCpqMarkV1Permission) {
		this.apptusCpqMarkV1Permission = apptusCpqMarkV1Permission;
	}
	

	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public Contact (String accountName, String contactType, String firstName, String lastName, String email, String partnerType, String username, String nickname, String userLicense, String profile, boolean apptusCpqMarkPermission, boolean apttusCpqUserPermission, boolean apptusCpqMarkV1Permission){
		
		this.accountName = accountName;
		this.contactType = contactType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.partnerType = partnerType;
		this.username = username;
		this.nickname = nickname;
		this.userLicense = userLicense;
		this.profile = profile;
		this.apptusCpqMarkPermission = apptusCpqMarkPermission;
		this.apttusCpqUserPermission = apttusCpqUserPermission;
		this.apptusCpqMarkV1Permission = apptusCpqMarkV1Permission;
		
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
	public void loadVariables(CsvReader reader) throws Exception{
		
		this.accountName = reader.get(0);
		this.contactType = reader.get(1);
		this.firstName = reader.get(2);
		this.lastName = reader.get(3);
		this.email = reader.get(4);
		this.partnerType = reader.get(5);
		this.username = reader.get(6) + Constants.QABUILD;
		this.nickname = reader.get(7) + Constants.QABUILD;;
		this.userLicense = reader.get(8);
		this.profile = reader.get(9);
		this.apptusCpqMarkPermission = Boolean.parseBoolean(reader.get(10));
		this.apttusCpqUserPermission = Boolean.parseBoolean(reader.get(11));
		this.apptusCpqMarkV1Permission = Boolean.parseBoolean(reader.get(12));
		
	}

	/**
	 * Function to reset the contact variable 
	 */
	@Override
	public void resetObjectVariable(){
		
		this.accountName = "";
		this.contactType = "";
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.partnerType = "";
		this.username = "";
		this.nickname = "";
		this.userLicense = "";
		this.profile = "";
		this.apptusCpqMarkPermission = true;
		this.apttusCpqUserPermission = true;
		this.apptusCpqMarkV1Permission = true;		
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception{
			
		//Writing header
		csvOutput.write("AccountName");
		csvOutput.write("ContactType");
		csvOutput.write("FirstName");
		csvOutput.write("LastName");
		csvOutput.write("Email");
		csvOutput.write("PartnerType");
		csvOutput.write("Username");
		csvOutput.write("Nickname");
		csvOutput.write("UserLicense");
		csvOutput.write("Profile");
		csvOutput.write("ApttusCPQMarketplacePermission");
		csvOutput.write("ApttusCPQUserPermission");
		csvOutput.write("ApttusCPQMarketplaceV1Permission");
		
	    csvOutput.endRecord();
		
	}
	
	/**
	 * Function to create file lines 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @param lines - (ArrayList<String>) This contains all failed records
	 * @throws Exception
	 */
	@Override
	public void createFileLines(CsvWriter csvOutput, @SuppressWarnings("rawtypes") ArrayList lines) throws Exception{
		
		for(int x = 0; x < lines.size(); x++){
				
			Contact contact = (Contact)lines.get(x);
		    csvOutput.write(contact.getAccountName());
		    csvOutput.write(contact.getContactType());
		    csvOutput.write(contact.getFirstName());
		    csvOutput.write(contact.getLastName());
		    csvOutput.write(contact.getEmail());
		    csvOutput.write(contact.getPartnerType());
		    csvOutput.write(contact.getUsername().replaceAll(Constants.QABUILD, ""));
		    csvOutput.write(contact.getNickname().replaceAll(Constants.QABUILD, ""));
		    csvOutput.write(contact.getUserLicense());
		    csvOutput.write(contact.getProfile());
		    csvOutput.write(String.valueOf(contact.getApptusCpqMarkPermission()));
		    csvOutput.write(String.valueOf(contact.getApttusCpqUserPermission()));
		    csvOutput.write(String.valueOf(contact.getApptusCpqMarkV1Permission()));
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}