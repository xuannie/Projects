public class Demo{
	public static void main(String[] args)throws FractionException{
      Formula a = new Formula("1/2 + 1/4 * 2 - 2/8");
      Formula b = new Formula("1/4 * 1/2 / 1/3 + 1 1/2");
      Formula c = new Formula("2 1/2 * 2/8 / -1/8 + -2 3/2");

      System.out.println("Formula a is ("+a+")"); // prints "Formula a is (1/2 + 1/4 * 2 - 2/8)" to the screen
      System.out.println("As fraction a = "+a.getFraction()); // prints "As fraction a = 3/4" to the screen
      System.out.println("As mixed number a = "+a.getMixedNumber()); // prints "As mixed number a = 3/4" to the screen

      System.out.println("Formula c is ("+c+")"); // prints "Formula a is (1/2 + 1/4 * 2 - 2/8)" to the screen
      System.out.println("As fraction c = "+c.getFraction()); // prints "As fraction a = 3/4" to the screen
      System.out.println("As mixed number c = "+c.getMixedNumber()); // prints "As mixed number a = 3/4" to the screen

      System.out.println("Formula b is ("+b+")"); // prints "Formula b is (1/4 * 1/2 / 1/6 + 1 2/3 )" to the screen 
      System.out.println("As fraction b = "+b.getFraction()); // prints "As fraction b = 9/4" to the screen
      System.out.println("As mixed number b = "+b.getMixedNumber()); // prints "As mixed number b = 2 1/4" to the screen  
 
  //the section below should print "a is less than b"
  if(a.compareTo(b)>0)
    System.out.println("a is greater than b");
  else
    if(a.compareTo(b)<0)
      System.out.println("a is less than b");
    else
      System.out.println("a is equal to b");

}}