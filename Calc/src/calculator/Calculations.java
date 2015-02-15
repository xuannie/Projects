package calculator;

public class Calculations{
	
	String str;
	
	protected String result;
	protected Double answer;
	
	public Calculations(){

	}
	
	public Calculations(String text) {
		this.str = text;
		answer = calc();
	}
	
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
				if (c != -1) throw new RuntimeException("Unexpected: " + (char)c);
				return value;	
			}

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
	
	public String toString() {
		return this.answer + "";
		
	}
	

}
