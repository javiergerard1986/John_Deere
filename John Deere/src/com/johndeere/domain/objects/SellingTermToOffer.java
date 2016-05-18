package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class SellingTermToOffer extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static SellingTermToOffer instance;
		
	public static SellingTermToOffer getInstance(){
	
		if (instance == null) {

			instance = new SellingTermToOffer();

		}

		return instance;

	}

	private SellingTermToOffer() {

		
		
	}

	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String preOfferName;
	private String sellingTerm;
	private int mdpPrice;
	private int msrp;
	private String startOfQuantity;
	private String endOfQuantity;
	
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getPreOfferName() {
		return preOfferName;
	}

	public void setPreOfferName(String preOfferName) {
		this.preOfferName = preOfferName;
	}

	public String getSellingTerm() {
		return sellingTerm;
	}

	public void setSellingTerm(String sellingTerm) {
		this.sellingTerm = sellingTerm;
	}

	public int getMdpPrice() {
		return mdpPrice;
	}

	public void setMdpPrice(int mdpPrice) {
		this.mdpPrice = mdpPrice;
	}

	public int getMsrp() {
		return msrp;
	}

	public void setMsrp(int msrp) {
		this.msrp = msrp;
	}
	
	public String getStartOfQuantity() {
		return startOfQuantity;
	}

	public void setMsrp(String startOfQuantity) {
		this.startOfQuantity = startOfQuantity;
	}
	
	public String getEndOfQuantity() {
		return endOfQuantity;
	}

	public void setEndOfQuantity(String endOfQuantity) {
		this.endOfQuantity = endOfQuantity;
	}
	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public SellingTermToOffer (String preOfferName, String sellingTerm, int mdpPrice, int msrp, String startOfQuantity, String endOfQuantity){
		
		this.preOfferName = preOfferName;
		this.sellingTerm = sellingTerm;
		this.mdpPrice = mdpPrice;
		this.msrp = msrp;
		this.startOfQuantity = startOfQuantity;
		this.endOfQuantity = endOfQuantity;
		
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
			
		this.preOfferName = reader.get(0);
		this.sellingTerm = reader.get(1);
		this.mdpPrice = Integer.parseInt(reader.get(2));
		this.msrp = Integer.parseInt(reader.get(3));
		this.startOfQuantity = reader.get(4);
		this.endOfQuantity = reader.get(5);
		
	}
		
	/**
	 * Function to reset the account variable 
	 */
	@Override
	public void resetObjectVariable(){
			
		this.preOfferName = "";
		this.sellingTerm = "";
		this.mdpPrice = 0;
		this.msrp = 0;
		this.startOfQuantity = "";
		this.endOfQuantity = "";
			
	}
	
	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception{
		
		//Writing header
		csvOutput.write("PreOfferName");
		csvOutput.write("SellingTerm");
		csvOutput.write("MDPPrice");
		csvOutput.write("MSRP");
		csvOutput.write("StartOfQuantity");
		csvOutput.write("EndOfQuantity");
		
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
				
			SellingTermToOffer pdst = (SellingTermToOffer)lines.get(x);
			csvOutput.write(pdst.getPreOfferName());
		    csvOutput.write(pdst.getSellingTerm());
		    csvOutput.write((String.valueOf(pdst.getMdpPrice())));
		    csvOutput.write(pdst.getStartOfQuantity());
		    csvOutput.write(pdst.getEndOfQuantity());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}