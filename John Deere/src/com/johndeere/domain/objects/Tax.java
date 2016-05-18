package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Tax extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Tax instance;
				
	public static Tax getInstance(){
			
		if (instance == null) {

			instance = new Tax();

		}

		return instance;

	}

	private Tax() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String dealerAccount;
	private String stateProvince;
	private String percentToCharge;
	private String description;
	private String country;
		
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getDealerAccount() {
		return dealerAccount;
	}

	public void setDealerAccount(String dealerAccount) {
		this.dealerAccount = dealerAccount;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getPercentToCharge() {
		return percentToCharge;
	}

	public void setPercentToCharge(String percentToCharge) {
		this.percentToCharge = percentToCharge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public Tax(String dealerAccount, String stateProvince, String percentToCharge, String description, String country){
	
		this.dealerAccount = dealerAccount;
		this.stateProvince = stateProvince;
		this.percentToCharge = percentToCharge;
		this.description = description;
		this.country = country;
		
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
		
		this.dealerAccount = reader.get(0);
		this.stateProvince = reader.get(1);
		this.percentToCharge = reader.get(2);
		this.description = reader.get(3);
		this.country = reader.get(4);
		
	}

	/**
	 * Function to reset the tax variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.dealerAccount = "";
		this.stateProvince = "";
		this.percentToCharge = "";
		this.description = "";
		this.country = "";
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
		
		//Writing header
		csvOutput.write("DealerAccount");
		csvOutput.write("StateProvince");
		csvOutput.write("PercentToCharge");
		csvOutput.write("Description");
		csvOutput.write("Country");
				
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
			
			Tax tax = (Tax)lines.get(x);
			csvOutput.write(tax.getDealerAccount());
		    csvOutput.write(tax.getStateProvince());
		    csvOutput.write(tax.getPercentToCharge());
		    csvOutput.write(tax.getDescription());
		    csvOutput.write(tax.getCountry());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}