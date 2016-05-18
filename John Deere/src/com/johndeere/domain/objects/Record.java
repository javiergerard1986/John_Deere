package com.johndeere.domain.objects;

import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.johndeere.domain.file.CsvFile;

public abstract class Record {

	//---------------------------------------------
	//ATTRIBUTES
	//---------------------------------------------
	protected CsvFile csvFile = CsvFile.getInstance();
	
	
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to load variables from the csv file
	 * @param reader (CsvReader) input file
	 * @throws Exception
	 */
	public abstract void loadVariables(CsvReader reader) throws Exception;
	
	/**
	 * Function to reset the account variable 
	 */
	 public abstract void resetObjectVariable();
	 
	/**
	 * Function to create header 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @throws Exception
	 */
	 public abstract void createHeader(CsvWriter csvOutput) throws Exception;
	 
	/**
	 * Function to create file lines 
	 * @param csvOutput - (CsvWriter) This is the file in which we will create the header
	 * @param lines - (ArrayList<String>) This contains all failed records
	 * @throws Exception
	 */
	 public abstract void createFileLines(CsvWriter csvOutput, @SuppressWarnings("rawtypes") ArrayList lines) throws Exception;
	 
	 /**
	  * Function to create a csv file with failed created accounts records 
	  * @param lines - (ArrayList<String>) This contains all failed records
	  * @param object - (String) This is the object record that we are creating
	  */
	 public void createFailedScenariosFile(@SuppressWarnings("rawtypes") ArrayList lines, String object){
	 
		 try{
			
			//Create folder to failed scenarios folder
			csvFile.createFailedScenariosFolder(object); 
			
			String outputFile = "C:\\\\Automation\\Input Files\\" + object + "\\Failed Scenarios\\Failed " + object + ".csv";
			
			//Check and delete existing file
			csvFile.checkFileExistence(outputFile);  
	        
	        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
         
	        //Create header
	        this.createHeader(csvOutput);
         
	        //Create lines
	        this.createFileLines(csvOutput, lines);
          
	        //Closing file
         csvOutput.close();
	        
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}
		 
	 }
	 
}