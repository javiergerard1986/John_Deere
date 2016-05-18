package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class Dealer extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Dealer instance;
				
	public static Dealer getInstance(){
			
		if (instance == null) {

			instance = new Dealer();

		}

		return instance;

	}

	private Dealer() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String contactName;
		
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public Dealer(String contactName){
	
		this.contactName = contactName;
		
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
		
	}

	/**
	 * Function to reset the Dealer variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.contactName = "";
		
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
		
		//Writing header
		csvOutput.write("contactName");
				
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
			
			Dealer group = (Dealer)lines.get(x);
			csvOutput.write(group.getContactName());
			
		    csvOutput.endRecord();
		        
		}
		
	}
	
}