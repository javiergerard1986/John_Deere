package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class DealerPreOffer extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static DealerPreOffer instance;
				
	public static DealerPreOffer getInstance(){
			
		if (instance == null) {

			instance = new DealerPreOffer();

		}

		return instance;

	}

	private DealerPreOffer() {

				
				
	}
		
		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String contactName;
	private String preOfferName;
		
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPreOfferName() {
		return preOfferName;
	}

	public void setPreOfferName(String preOfferName) {
		this.preOfferName = preOfferName;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public DealerPreOffer(String contactName, String preOfferName){
	
		this.contactName = contactName;
		this.preOfferName = preOfferName;
		
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
		this.preOfferName = reader.get(1);
		
	}

	/**
	 * Function to reset the DealerPreOffer variable 
	 */
	@Override
	public void resetObjectVariable() {
		
		this.contactName = "";
		this.preOfferName = "";
		
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
		csvOutput.write("PreOfferName");
				
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
			
			DealerPreOffer group = (DealerPreOffer)lines.get(x);
			csvOutput.write(group.getContactName());
		    csvOutput.write(group.getPreOfferName());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}