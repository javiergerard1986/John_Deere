package com.johndeere.domain.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TxtFile {

	//------------------------------------
	//SINGLETON
	//------------------------------------
	private static TxtFile instance;
		
	public static TxtFile getInstance(){
				
		if(instance == null){
					
			instance = new TxtFile();
				
		}
				
		return instance;
				
	}
		
	private TxtFile(){
		
			
			
	}
	
	
	//------------------------------------
	//FUNCTIONS
	//------------------------------------
	/**
	 * Function to create log file
	 * @param object - (String) This is the object record that we are creating
	 * @param infoToLog - (ArrayList<String>) Contains all the lines that needs to be logged
	 * @param executionType - (String) This is the execution type, example: Test Class, Base execution
	 */
	public void createLogFile(String object, ArrayList<String> infoToLog, String executionType){
		
		try{
		
			if(!executionType.equals("Test Class")){
				
				File folder = new File("C:\\\\Automation\\Logs\\" + object + "\\"); 
				folder.mkdir(); 
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
				Date date = new Date();
				String fileDate = (String)(dateFormat.format(date).toString());
				
				String path = "C:\\\\Automation\\Logs\\" + object + "\\" + object + "Log "+ fileDate + ".txt";
						
				File logFile = new File(path);
			    
				BufferedWriter bw;
				bw = new BufferedWriter(new FileWriter(logFile));
				
				for(int x = 0; x < infoToLog.size(); x++){
					
					String line = infoToLog.get(x);
					
					bw.write(line);
					
				}
			
				bw.close();
				
			}
			
		}catch(Exception ex){
			
			System.out.println(ex.getMessage());
			
		}

	}
	
}