package com.johndeere.utils;

public class Util {

	//---------------------------------------------
	//SINGLETON
	//---------------------------------------------
	private static Util instance;
			
	public static Util getInstance(){
		
		if (instance == null) {

			instance = new Util();

		}

		return instance;

	}

	private Util() {

			
			
	}

		
	//---------------------------------------------
	//FUNCTIONS
	//---------------------------------------------
	/**
	 * Function to return a random String
	 * @return - (String) random String
	 */
	public String generateRandomString(){
		
		return Long.toHexString(Double.doubleToLongBits(Math.random()));
		
	}
	
	/**
	 * Function to remove points and comas
	 * @return - (String) string without points and comas
	 */
	public String setFormatLatitudeOrLongitude(String in){
		
		String out = "";
		in = in.replace(".", "");
		
		if(in.contains("-")){
			
			for(int x = 0; x < in.length(); x++){
				
				out += in.charAt(x);
				
				if(x == 2){
					
					out += ".";
					
				}
				
			}
			
		}else{
		
			for(int x = 0; x < in.length(); x++){
				
				out += in.charAt(x);
				
				if(x == 1){
					
					out += ".";
					
				}
				
			}
			
		}
			
		return out;
	}
	
}