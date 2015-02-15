/*
 *@author Alexis Chuah
 *
 *Write a class called Formula that parses a formula. 
 *Allow the user to retrieve the original formula as a String, 
 *the value of the calculated formula as a fraction , 
 *the value of the calculated formula as a mixed number, and compare to formulas based on 
 *the value they equal. All fractions, even part of a mixed number, should be reduced. 
 *Therefore the code below would act according to the comments.
 */
import java.util.*;
import java.util.Scanner;

public class Formula implements Comparable{
   
	public static Scanner kb = new Scanner(System.in);
	protected ArrayList<String> al = new ArrayList<String>();
	protected String form; //stores the formula string
	protected Fraction f = new Fraction(); //store the calculated fraction from the formula
	private boolean hasFraction = false; //to check if there's already a value stored
   
	public Formula(){
		System.out.println("Enter a formula: "); 
		form = kb.nextLine();
		new Formula(form);
	}
   
	public Formula(String a){
		String[]b = a.split(" ");
		String temp;
          
		for(int i=0; i<b.length; i++)
			al.add(b[i]);
         
		for(int i=1; i<al.size(); i=i+2){
			//use regex to see if there's a fraction in the odd elements
			String pattern = "^\\d.*"; 
			if((al.get(i)).matches(pattern)){
				temp = al.get(i-1) + " " + al.get(i);
				al.remove(i);
				al.set(i-1,temp);
			}
		}
        
		//For checking what's loaded in the array
		//System.out.println(al);
	
		this.form = a;
	}
	
	//calculate fraction and store it in a variable for using with other methods
	private void calcFraction() throws FractionException{
		hasFraction = true;
		
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		
		while(al.contains("*")){
			int x = al.indexOf("*");			
			f1 = f.fromMixed(al.get(x-1));
			f2 = f.fromMixed(al.get(x+1));
			
			this.f = f1.multiply(f2);
			
			al.set(x-1,f.toMixed());
			al.remove(x);
			al.remove(x);				 		
		}
		
		while(al.contains("/")){
			int x = al.indexOf("/");			
			f1 = f.fromMixed(al.get(x-1));
			f2 = f.fromMixed(al.get(x+1));
			
			this.f = f1.divide(f2);
			
			al.set(x-1,f.toMixed());
			al.remove(x);
			al.remove(x);				 		
		}
		
		while(al.contains("+")){
			int x = al.indexOf("+");			
			f1 = f.fromMixed(al.get(x-1));
			f2 = f.fromMixed(al.get(x+1));
			
			this.f = f1.add(f2);
			
			al.set(x-1,f.toMixed());
			al.remove(x);
			al.remove(x);				 		
		}
		
		while(al.contains("-")){
			int x = al.indexOf("-");			
			f1 = this.f.fromMixed(al.get(x-1));
			f2 = this.f.fromMixed(al.get(x+1));
			
			this.f = f1.subtract(f2);
			
			al.set(x-1,this.f.toMixed());
			al.remove(x);
			al.remove(x);				 		
		}
	}
   
	public String getFraction() throws FractionException{
		
		if(!hasFraction)
			calcFraction();
		
		//For checking what's left in the array
		//System.out.println(al); 
			
		return (""+this.f);
	}
	
	public String getMixedNumber() throws FractionException{
		
		if(!hasFraction)
			calcFraction();
		
		return(this.f.toMixed());
		
	}
   
	//to string
	public String toString(){
		return this.form;
	}

	//Compare to method
	public int compareTo(Object o) {
		
		Formula b = (Formula) o;
		
		if (this.f.toDecimal() > b.f.toDecimal())
			return 1;
		if (this.f.toDecimal() < b.f.toDecimal())
			return -1;
				// TODO Auto-generated method stub
		return 0;
	}

	
}