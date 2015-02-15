import java.util.*;

public class Fraction implements FractionInterface, Comparable{
	
	protected int numerator, denominator;
	
	public Fraction(){
		this.numerator = 0;
		this.denominator = 1;
	}
	
	public Fraction(int n, int d) throws FractionException{
		if(d!=0){
			this.numerator = n;
			this.denominator = d;
		}else{
			throw new FractionException("Cannot set denominator to zero.");
		}
	}
	
	public Fraction add(Fraction f)throws FractionException{
		if(!checkForValidity(f))
			throw new FractionException("Cannot add by given fraction.");
		int n=this.numerator*f.getDenominator() + this.denominator*f.getNumerator();
		int d=this.denominator*f.getDenominator();
		Fraction temp = new Fraction(n,d);
		temp.reduce();
		return temp;
	}
	
	public Fraction subtract(Fraction f)throws FractionException{
		if(!checkForValidity(f))
			throw new FractionException("Cannot subtract by given fraction.");
		int n=this.numerator*f.getDenominator() - this.denominator*f.getNumerator();
		int d=this.denominator*f.getDenominator();
		Fraction temp = new Fraction(n,d);
		temp.reduce();
		return temp;
	}
	
	public Fraction multiply(Fraction f)throws FractionException{
		if(!checkForValidity(f))
			throw new FractionException("Cannot multiply by given fraction.");
		int n=this.numerator*f.getNumerator();
		int d=this.denominator*f.getDenominator();
		Fraction temp = new Fraction(n,d);
		temp.reduce();
		return temp;
	}
	
	public Fraction divide(Fraction f) throws FractionException{
		if(!checkForValidity(f))
			throw new FractionException("Cannot divide by given fraction.");
		int n=this.numerator*f.getDenominator();
		int d=this.denominator*f.getNumerator();
		Fraction temp = new Fraction(n,d);
		temp.reduce();
		return temp;
	}

	private boolean checkForValidity(Fraction f){
		if(f == null)
			return false;
		if ((this.denominator==0) || (f.getDenominator() == 0))
			return false;
		return true;
	}
	
	public void reduce() throws FractionException{
		int gcd = gcd(this.numerator, this.denominator);
		this.numerator = this.numerator / gcd;
		this.denominator = this.denominator / gcd;
	}

	public float toDecimal() throws ArithmeticException{
			return (float)this.numerator / this.denominator;
	}
	
	public String toMixed(){
		if(this.numerator<this.denominator)
			return toString();

		int whole = this.numerator / this.denominator;
		int newNumerator = this.numerator % this.denominator;
		
		//takes out negative from denominator
		if (this.denominator<0)
			this.denominator = this.denominator * -1;
		
		if(newNumerator==0){
			return whole+"";
		}
		return whole + " " + newNumerator + "/" + this.denominator;
	}
	
	public Fraction fromMixed(String mixed) throws FractionException{
		String[] a = mixed.split(" ");

		if(a.length>1){
			int whole = Integer.parseInt(a[0]);
			if(a[1].contains("-"))
				throw new FractionException("You put a negative in the fraction...DON'T DO THAT!");
			int n = Integer.parseInt(a[1].split("/")[0]);
			int d = Integer.parseInt(a[1].split("/")[1]);
			return new Fraction((whole/(Math.abs(whole))*(Math.abs(whole)*d+n)),d);
		}else{
			if(a[0].contains("/")){
				int n = Integer.parseInt(a[0].split("/")[0]);
				int d = Integer.parseInt(a[0].split("/")[1]);
				return new Fraction(n,d);
			}else{
				return new Fraction(Integer.parseInt(a[0]),1);
			}
		}
	}
	
	private int gcd(int a, int b){
		if (b==0) 
			return a;
		else
			return gcd(b, a % b);
	}

	public String toString(){ 
		if(this.denominator<0){
			this.numerator *= -1;
			this.denominator *= -1;
		}
		return this.numerator+"/"+this.denominator;
	}
	
	public int compareTo(Object o){
		Fraction f = (Fraction) o;
		if(this.toDecimal() > f.toDecimal())
			return 1;
		if(this.toDecimal() < f.toDecimal())
			return -1;
		return 0;
	}
	
	public int getNumerator(){
		return this.numerator;
	}

	public int getDenominator(){
		return this.denominator;
	}
}
