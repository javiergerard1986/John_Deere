package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Account extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Account instance;
		
	public static Account getInstance(){
	
		if (instance == null) {

			instance = new Account();

		}

		return instance;

	}

	private Account() {

		
		
	}

	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String accountType;
	private String accountName;
	private String parentAccount;
	private String region;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String supportPhone;
	private String supportEmail;
	private String billingEmail;
	private String accountOwner;
	private boolean enableAsPartner;
	private String MJDOrgId;
	private String latitude;
	private String longitude;
	private String taxExemptionCertificateId;
	
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public String getParentAccount() {
		return parentAccount;
	}
	
	public void setParentAccount(String parentAccount) {
		this.parentAccount = parentAccount;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getSupportPhone() {
		return supportPhone;
	}
	
	public void setSupportPhone(String supportPhone) {
		this.supportPhone = supportPhone;
	}
	
	public String getSupportEmail() {
		return supportEmail;
	}
	
	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}
	
	public String getBillingEmail(){
		return billingEmail;
	}
	
	public void setBillingEmail(String billingEmail){
		this.billingEmail = billingEmail;
	}
	
	public String getAccountOwner() {
		return accountOwner;
	}
	
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	
	public boolean getEnableAsPartner() {
		return enableAsPartner;
	}
	
	public void setEnableAsPartner(boolean enableAsPartner) {
		this.enableAsPartner = enableAsPartner;
	}
	
	public String getMJDOrgId(){
		return MJDOrgId;
	}
	
	public void setMJDOrgId(String MJDOrgId){
		this.MJDOrgId = MJDOrgId;
	}
	
	public String getLatitude(){
		return latitude;
	}
	
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	
	public String getLongitude(){
		return longitude;
	}
	
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
	
	public String getTaxExemptionCertificateId(){
		return taxExemptionCertificateId;
	}
	
	public void setTaxExemptionCertificateId(String taxExemptionCertificateId){
		this.taxExemptionCertificateId = taxExemptionCertificateId;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public Account (String accountType, String accountName, String parentAccount, String street, String city, String state, String postalCode, String region, String country, String supportPhone, String supportEmail, String billingEmail, String accountOwner, boolean enableAsPartner, String MJDOrgId, String latitude, String longitude, String taxExemptionCertificateId){
		
		this.accountType = accountType;
		this.accountName = accountName;
		this.parentAccount = parentAccount;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.region = region;
		this.country = country;
		this.supportPhone = supportPhone;
		this.supportEmail = supportEmail;
		this.billingEmail = billingEmail;
		this.accountOwner = accountOwner;
		this.enableAsPartner = enableAsPartner;
		this.MJDOrgId = MJDOrgId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.taxExemptionCertificateId = taxExemptionCertificateId;
		
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
			
		this.accountType = reader.get(0);
		this.accountName = reader.get(1);
		this.parentAccount = reader.get(2);
		this.street = reader.get(3);
		this.city = reader.get(4);
		this.state = reader.get(5);
		this.postalCode = reader.get(6);
		this.region = reader.get(7);
		this.country = reader.get(8);
		this.supportPhone = reader.get(9);
		this.supportEmail = reader.get(10);
		this.billingEmail = reader.get(11);
		this.accountOwner = reader.get(12);
		this.enableAsPartner =  Boolean.parseBoolean(reader.get(13));
		this.MJDOrgId = reader.get(14);
		this.latitude = reader.get(15);
		this.longitude = reader.get(16);
		this.taxExemptionCertificateId = reader.get(17);
			
	}
		
	/**
	 * Function to reset the account variable 
	 */
	@Override
	public void resetObjectVariable(){
			
		this.accountType = "";
		this.accountName = "";
		this.parentAccount = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.postalCode = "";
		this.region = "";
		this.country = "";
		this.supportPhone = "";
		this.supportEmail = "";
		this.billingEmail = "";
		this.accountOwner = "";
		this.enableAsPartner = true;
		this.MJDOrgId = "";
		this.latitude = "";
		this.longitude = "";
		taxExemptionCertificateId = "";
			
	}
	
	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception{
			
		//Writing header
		csvOutput.write("AccountType");
		csvOutput.write("AccountName");
		csvOutput.write("ParentAccount");
		csvOutput.write("Street");
		csvOutput.write("City");
		csvOutput.write("State");
		csvOutput.write("PostalCode");
		csvOutput.write("Region");
		csvOutput.write("Country");
		csvOutput.write("SupportPhone");
		csvOutput.write("SupportEmail");
		csvOutput.write("BillingEmail");
		csvOutput.write("AccountOwner");
		csvOutput.write("EnableAsPartner");
		csvOutput.write("MJDOrgId");
		csvOutput.write("Latitude");
		csvOutput.write("Longitude");
		csvOutput.write("TaxExemptionCertificateId");
		
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
				
			Account account = (Account)lines.get(x);
			csvOutput.write(account.getAccountType());
		    csvOutput.write(account.getAccountName());
		    csvOutput.write(account.getParentAccount());
		    csvOutput.write(account.getStreet());
		    csvOutput.write(account.getCity());
		    csvOutput.write(account.getState());
		    csvOutput.write(account.getPostalCode());
		    csvOutput.write(account.getRegion());
		    csvOutput.write(account.getCountry());
		    csvOutput.write(account.getSupportPhone());
		    csvOutput.write(account.getSupportEmail());
		    csvOutput.write(account.getBillingEmail());
		    csvOutput.write(account.getAccountOwner());
		    csvOutput.write(String.valueOf(account.getEnableAsPartner()));
		    csvOutput.write(account.getMJDOrgId());
		    csvOutput.write(account.getLatitude());
		    csvOutput.write(account.getLongitude());
		    csvOutput.write(account.getTaxExemptionCertificateId());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}