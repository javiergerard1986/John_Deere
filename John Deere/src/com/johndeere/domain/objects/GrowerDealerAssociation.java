package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class GrowerDealerAssociation extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static GrowerDealerAssociation instance;
			
	public static GrowerDealerAssociation getInstance(){
		
		if (instance == null) {

			instance = new GrowerDealerAssociation();

		}

		return instance;

	}

	private GrowerDealerAssociation() {

			
			
	}

		
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String associationType;
	private String growerAccountName;
	private String dealerAccountName;
	private String relationshipType;
	
		
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getAssociationType() {
		return associationType;
	}
		
	public void setAssociationType(String associationType) {
		this.associationType = associationType;
	}
	
	public String getGrowerAccountName() {
		return growerAccountName;
	}
		
	public void setGrowerAccountName(String growerAccountName) {
		this.growerAccountName = growerAccountName;
	}
		
	public String getDealerAccountName() {
		return dealerAccountName;
	}
		
	public void setDealerAccountName(String dealerAccountName) {
		this.dealerAccountName = dealerAccountName;
	}
		
	public String getRelationshipType() {
		return relationshipType;
	}
		
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public GrowerDealerAssociation (String associationType, String growerAccountName, String dealerAccountName, String relationshipType){
			
			this.associationType = associationType;
			this.growerAccountName = growerAccountName;
			this.dealerAccountName = dealerAccountName;
			this.relationshipType = relationshipType;
			
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
		
		this.associationType = reader.get(0);
		this.dealerAccountName = reader.get(1);
		this.growerAccountName = reader.get(2);
		this.relationshipType = reader.get(3);	
		
	}

	/**
	 * Function to reset the account variable 
	 */
	@Override
	public void resetObjectVariable() {
	
		this.associationType = "";
		this.dealerAccountName = "";
		this.growerAccountName = "";
		this.relationshipType = "";
			
	}

	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception {
	
		//Writing header
		csvOutput.write("AssociationType");
		csvOutput.write("DealerAccountName");
		csvOutput.write("GrowerAccountName");	
		csvOutput.write("RelationshipType");
		
		csvOutput.endRecord();
		
	}

	/**
	 * Function to create file lines 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @param lines - (ArrayList<String>) This contains all failed records
	 * @throws Exception
	 */
	@Override
	public void createFileLines(CsvWriter csvOutput, @SuppressWarnings("rawtypes") ArrayList lines) throws Exception {
		
		for(int x = 0; x < lines.size(); x++){
			
			GrowerDealerAssociation gda = (GrowerDealerAssociation)lines.get(x);
			csvOutput.write(gda.getAssociationType());
			csvOutput.write(gda.getDealerAccountName());
		    csvOutput.write(gda.getGrowerAccountName());
		    csvOutput.write(gda.getRelationshipType());
		    csvOutput.endRecord();
		        
		}
			
	}

}