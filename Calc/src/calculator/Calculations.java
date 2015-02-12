package calculator;

import java.util.ArrayList;

public class Calculations {
	
	protected ArrayList<String> al = new ArrayList<String>();
	
	public Calculations(){
		
	}
	
	public Calculations(String formula){
		String[]sep = formula.split(" ");
		String temp;
		
        //TODO modify formula  
		for(int i=0; i<sep.length; i++)
			al.add(sep[i]);
	}
	
	private void calc(){
		
	}
	
	private double add(double num){
		
		return 0;
	}

}
