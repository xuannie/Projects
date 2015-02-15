public interface FractionInterface {
	public float toDecimal();
	public String toMixed();//converts to a mixed number such as 3 1/2
	public Fraction fromMixed(String mixed) throws FractionException; //converts from a String to Fraction
}
