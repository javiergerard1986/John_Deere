package com.johndeere.domain.objects;

import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class PreOffer extends Record{

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static PreOffer instance;
		
	public static PreOffer getInstance(){
	
		if (instance == null) {

			instance = new PreOffer();

		}

		return instance;

	}

	private PreOffer() {

		
		
	}

	
	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	private String preOfferType;
	private String preOfferName;
	private String country;
	private String region;
	private String startDate;
	private String endDate;
	private String iconUrl;
	private String screenshot1;
	private String screenshot2;
	private String screenshot3;
	private String product;
	private String cost;
	private String frequency;
	private String sellingTerm;
	private int mdpPrice;
	private int msrp;
	private String startOfQuantity;
	private String endOfQuantity;
	private String groupName;
	
	
	//---------------------------------------------
	//PROPERTIES
	//---------------------------------------------
	public String getPreOfferType() {
		return preOfferType;
	}

	public void setPreOfferType(String preOfferType) {
		this.preOfferType = preOfferType;
	}

	public String getPreOfferName() {
		return preOfferName;
	}

	public void setPreOfferName(String preOfferName) {
		this.preOfferName = preOfferName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getScreenshot1() {
		return screenshot1;
	}

	public void setScreenshot1(String screenshot1) {
		this.screenshot1 = screenshot1;
	}

	public String getScreenshot2() {
		return screenshot2;
	}

	public void setScreenshot2(String screenshot2) {
		this.screenshot2 = screenshot2;
	}

	public String getScreenshot3() {
		return screenshot3;
	}

	public void setScreenshot3(String screenshot3) {
		this.screenshot3 = screenshot3;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
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

	public void setStartOfQuantity(String startOfQuantity) {
		this.startOfQuantity = startOfQuantity;
	}
	
	public String getEndOfQuantity() {
		return endOfQuantity;
	}

	public void setEndOfQuantity(String endOfQuantity) {
		this.endOfQuantity = endOfQuantity;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	
	
	//---------------------------------------------
	//CONSTRUCTORS
	//---------------------------------------------
	public PreOffer (String preOfferName, String preOfferType, String country, String region, String startDate, String endDate, String iconUrl, String screenshot1, String screenshot2, String screenshot3, String product, String cost, String frequency, String sellingTerm, int mdpPrice, int msrp, String startOfQuantity, String endOfQuantity, String groupName){
		
		this.preOfferType = preOfferType;
		this.preOfferName = preOfferName;
		this.country = country;
		this.region = region;
		this.startDate = startDate;
		this.endDate = endDate;
		this.iconUrl = iconUrl;
		this.screenshot1 = screenshot1;
		this.screenshot2 = screenshot2;
		this.screenshot3 = screenshot3;
		this.product = product;
		this.cost = cost;
		this.frequency = frequency;
		this.sellingTerm = sellingTerm;
		this.mdpPrice = mdpPrice;
		this.msrp = msrp;
		this.startOfQuantity = startOfQuantity;
		this.endOfQuantity = endOfQuantity;
		this.groupName = groupName;
		
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
			
		this.preOfferType = reader.get(0);
		this.preOfferName = reader.get(1);
		this.country = reader.get(2);
		this.region = reader.get(3);
		this.startDate = reader.get(4);
		this.endDate = reader.get(5);
		this.iconUrl = reader.get(6);
		this.screenshot1 = reader.get(7);
		this.screenshot2 = reader.get(8);
		this.screenshot3 = reader.get(9);
		this.product = reader.get(10);
		this.cost = reader.get(11);
		this.frequency = reader.get(12);
		this.sellingTerm = reader.get(13);
		this.mdpPrice = Integer.parseInt(reader.get(14));
		this.msrp = Integer.parseInt(reader.get(15));
		this.startOfQuantity = reader.get(16);
		this.endOfQuantity = reader.get(17);
		this.groupName = reader.get(18);
		
	}
		
	/**
	 * Function to reset the account variable 
	 */
	@Override
	public void resetObjectVariable(){
			
		this.preOfferType = "";
		this.preOfferName = "";
		this.country = "";
		this.region = "";
		this.startDate = "";
		this.endDate = "";
		this.iconUrl = "";
		this.screenshot1 = "";
		this.screenshot2 = "";
		this.screenshot3 = "";
		this.product = "";
		this.cost = "";
		this.frequency = "";
		this.sellingTerm = "";
		this.mdpPrice = 0;
		this.msrp = 0;
		this.startOfQuantity = "";
		this.endOfQuantity = "";
		this.groupName = "";
			
	}
	
	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	@Override
	public void createHeader(CsvWriter csvOutput) throws Exception{
			
		//Writing header
		csvOutput.write("PreOfferType");
		csvOutput.write("PreOfferName");
		csvOutput.write("Country");
		csvOutput.write("Region");
		csvOutput.write("StartDate");
		csvOutput.write("EndDate");
		csvOutput.write("IconUrl");
		csvOutput.write("Screenshot1");
		csvOutput.write("Screenshot2");
		csvOutput.write("Screenshot3");
		csvOutput.write("Product");
		csvOutput.write("Cost");
		csvOutput.write("Frequency");
		csvOutput.write("SellingTerm");
		csvOutput.write("MDPPrice");
		csvOutput.write("MSRP");
		csvOutput.write("StartOfQuantity");
		csvOutput.write("EndOfQuantity");
		csvOutput.write("GroupName");
		
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
			
			PreOffer preOffer = (PreOffer)lines.get(x);
			
			csvOutput.write(preOffer.getPreOfferType());
		    csvOutput.write(preOffer.getPreOfferName());
		    csvOutput.write(preOffer.getCountry());
		    csvOutput.write(preOffer.getRegion());
		    csvOutput.write(preOffer.getStartDate());
		    csvOutput.write(preOffer.getEndDate());
		    csvOutput.write(preOffer.getIconUrl());
		    csvOutput.write(preOffer.getScreenshot1());
		    csvOutput.write(preOffer.getScreenshot2());
		    csvOutput.write(preOffer.getScreenshot3());
		    csvOutput.write(preOffer.getProduct());
		    csvOutput.write(preOffer.getCost());
		    csvOutput.write(preOffer.getFrequency());
		    csvOutput.write(preOffer.getSellingTerm());
		    csvOutput.write(String.valueOf(preOffer.getMdpPrice()));
		    csvOutput.write(String.valueOf(preOffer.getMsrp()));
		    csvOutput.write(preOffer.getStartOfQuantity());
		    csvOutput.write(preOffer.getEndOfQuantity());
		    csvOutput.write(preOffer.getGroupName());
		    
		    csvOutput.endRecord();
		        
		}
		
	}
	
}