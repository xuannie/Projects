/**
 * Gets a string of the equation and calculates the results.
 * 
 * @author Alexis Chuah
 * @verson 2/15/2015
 * 
 * Calculates the equation using a parser. toString returns answer without unnecessary zeros. 
 */
package calculator;

public class Calculations{
	
	protected String str;
	protected Double answer;
	protected String result;
	
	public Calculations(){
		this.str = "";
		this.answer = 0.0;

	}
	
	public Calculations(String text) {
		this.str = text;
		answer = calc();
		this.result = text + " = " + answer.toString();
	}
	
	/**
	 * Calculate result of equation using a nested parser class
	 * @return
	 */
	private double calc(){
	
		class Parser{
			int pos = -1, c;
		
			void eatChar() {
				c = (++pos <str.length()) ? str.charAt(pos) : -1;
			}
		
			void eatSpace() {
				while(Character.isWhitespace(c)) eatChar();
			}
		
			double parse(){
				eatChar();
				double value = parseExpression();
				if (c != -1) 
					throw new RuntimeException("Unexpected: " + (char)c);
				return value;	
			}

			//Addition and subtraction
			private double parseExpression() {
				double value = parseTerm();
				for(;;){
					eatSpace();
					if (c == '+') {
						eatChar();
						value += parseTerm();
					} 
					else if (c == '-') {
						eatChar();
						value -= parseTerm();
					}
					else
						return value;
				}
			}

			//Division and multiplication. Handles parenthesis as well
			private double parseTerm() {
				double value = parseFactor();
				for (;;){
					eatSpace();
					if (c == '/') {
						eatChar();
						value /= parseFactor();
					}
					else if (c == '*' || c == '('){
						if (c == '*')
							eatChar();
						value *= parseFactor();
					}
					else
						return value;
				}
			}

			//Checks for negative value
			private double parseFactor() {
				double value;
				boolean negate = false;
				eatSpace();
				
				if(c == '('){
					eatChar();
					value = parseExpression();
					if (c == ')')
						eatChar();
				}
				else{
					if (c == '+' || c == '-'){
						negate = c == '-';
						eatChar();
						eatSpace();
					}
					StringBuilder sb = new StringBuilder();
					while ((c >= '0' && c <= '9') || c == '.'){
						sb.append((char)c);
						eatChar();
					}
					if (sb.length() == 0) 
						throw new RuntimeException("Unexpected: " + (char)c);
					value = Double.parseDouble(sb.toString());
				}
				if (negate)
					value = -value;
				
				return value;
			}
		
		}
		return new Parser().parse();
	}
	
	/**
	 * If answer is a whole number, remove unnecessary zeros in the back. 
	 */
	public String toString() {
		if(Math.floor(answer) == answer){
			int truncate = answer.intValue();
			return truncate + "";
		}
		else{
			return answer + "";
		}
		
	}
	

}
