/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 *      Implement interfaces: FractionInterface and Comparable (i.e. compareTo())
 *      Implement methods equals() and toString() from class Object
 *      Should work for both positive and negative fractions
 *      Must always reduce fraction to lowest term 
 *      Must throw excpetion in case of errors
 *      Must not add new or modify existing data fields
 *      Must not add new public methods
 *      May add private methods
 *      For number such as 10/-3, it is same as -3/10 (see hints 2. below)
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive algorithm which finds the greatest common denominator of
 *    two positive integers is implemnted (see code)
 *       
 * 2. It will be easier to determine the correct sign of a fraction if you force
 *    the fraction's denominator to be positive. However, your implementation must 
 *    handle negative denominators that the client might provide.
 *           
 * 3. You need to downcast reference parameter FractionInterface to Fraction if  
 *    you want to use it as Fraction. See add, subtract, multiply and divide methods
 *
 ************************************************************************************/

package PJ1;

public class Fraction implements FractionInterface, Comparable<Fraction>
{
	private	int num;	// Numerator	
	private	int den;	// Denominator	

	public Fraction()
	{
		// set fraction to default = 0/1
		setFraction(0, 1);
	}	// end default constructor

	public Fraction(int numerator, int denominator)
	{
		setFraction(numerator,denominator);
	}	// end constructor

	public void setFraction(int numerator, int denominator) throws ArithmeticException
	{

			num = numerator;
			den = denominator;
			
			if (den == 0)
			{
				throw new ArithmeticException("Cannot divide by 0.");
			}
			
			//if den is negative and num is +
			//or den and num are -
			//switch sign
			//NORMALIZE
			//denominator will never be negative
			if ((den < 0 && num >= 0)||(den < 0 && num < 0))
			{
				den = -den;
				num = -num;
			}
			//if both num and den are -
			
			//change - in denom to numerator
			// return ArithmeticException if initialDenominator is 0
			// implement this method!


	}	// end setFraction

	public int getNumerator()
	{
		// implement this method!
		return num;
	}	// end getNumerator

	public int getDenominator()
	{
		// implement this method!
		return den;
	}	// end getDenominator

	public char getSign()
	{
		char sign = '\0';
		// implement this method!
		//because of normalize, den will never be negative
		if (num < 0)
			sign = '-';
		else
		{
			sign = '+';
		}
		
		return sign;

	}	// end getSign

	public void switchSign()
	{
		// implement this method!
		num = -num;
		//num = -num;
	}	// change setSign

	public FractionInterface add(FractionInterface secondFraction)
	{
		 Fraction secondOperand = (Fraction) secondFraction;
		
		 Fraction result = new Fraction();
		 
		 result.setFraction((this.num*secondOperand.den) + 
				 (secondOperand.num*this.den),(this.den*secondOperand.den));
		 
		result.reduceToLowestTerms();
		// a/b + c/d is (ad + cb)/(bd)
		return result;
	}	// end add

	public FractionInterface subtract(FractionInterface secondFraction)
	{
		// a/b - c/d is (ad - cb)/(bd)
		// implement this method!
		 Fraction secondOperand = (Fraction) secondFraction;
		 
		 Fraction result = new Fraction();
		 
		 result.setFraction((this.num*secondOperand.den) - 
				 (secondOperand.num*this.den),(this.den * secondOperand.num));
		
		result.reduceToLowestTerms();
		return result;
	}	// end subtract

	public FractionInterface multiply(FractionInterface secondFraction)
	{
		// a/b * c/d is (ac)/(bd)
		// implement this method!
		 Fraction secondOperand = (Fraction) secondFraction;
			
		 Fraction result = new Fraction();
		 
		 result.setFraction(this.num * secondOperand.num,this.den * secondOperand.den);
		 
		result.reduceToLowestTerms();
		return result;
	}	// end multiply

	public FractionInterface divide(FractionInterface secondFraction)
	{
		// return ArithmeticException if secondFraction is 0
		// a/b / c/d is (ad)/(bc)
		// implement this method!
		 Fraction secondOperand = (Fraction) secondFraction;
			
		 int firstnum = this.getNumerator();
		 int firstden = this.getDenominator();
		 int secnum = secondOperand.num;
		 int secden = secondOperand.den;
		 Fraction result = new Fraction();
		 
		 if (secnum == 0)
		 {
			 throw new ArithmeticException("Second Fraction is 0. Cannot divide by 0.");
		 }
		 

		result.num = firstnum * secden;
		result.den = (firstden * secnum);
		
		result.reduceToLowestTerms();
		return result;
	}	// end divide

	public FractionInterface getReciprocal() 
	{
		// return ArithmeticException if secondFraction is 0
		
		//int temp = 0;
		//temp = num;
		//num = den;
		//den = temp;
		
		//Fraction reciprocal = new Fraction();
		//reciprocal.setFraction(num, den);
		
		Fraction reciprocal = new Fraction(this.den,this.num);
		
		
		// implement this method!
		return reciprocal;
	} // end getReciprocal


	public boolean equals(Object other)
	{
		 Fraction secondFraction = (Fraction) other;
		
		//double fraction1 = 0;
		//double fraction2 = 0;
		
		//dvide fractions so that you know their decimal value then compare
		//fraction1 = (double)this.num / this.den;
		//fraction2 = (double)secondFraction.num / secondFraction.den;
		
		return (this == secondFraction);
		
		// implement this method!
		
		
		//divide fraction then compare results
		//return false;
	} // end equals


	public int compareTo(Fraction other)
	{
		// implement this method!
		
		int result = 0;
		if (this.equals(other))
		{
			result = 0;
		}
		else
		{
			
		}
		return result;
	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString


	/** Task: Reduces a fraction to lowest terms. */

        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

	private void reduceToLowestTerms()
	{
		int GDC = 0;
		if (num < 0)
		{
			//remove negative
			num = num * -1;
			
			GDC = greatestCommonDivisor(this.num,this.den);
                
			//this.setFraction(this.num/GDC , this.den/GDC);
			num = num / GDC;
			den = den / GDC;
            
			//put back negative
            num = num * -1;
		}
		else
		{
			GDC = greatestCommonDivisor(this.num,this.den);
			num = num / GDC;
			den = den / GDC;
		}
                
	}	// end reduceToLowestTerms

  	/** Task: Computes the greatest common secondFraction of two integers.
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int greatestCommonDivisor(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = greatestCommonDivisor(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end greatestCommonDivisor


	//-----------------------------------------------------------------
	//  Simple test is provided here 

	public static void main(String[] args)
	{
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;

		Fraction nineSixteenths = new Fraction(9, 16);	// 9/16
		Fraction oneFourth = new Fraction(1, 4);        // 1/4

		// 7/8 + 9/16
		firstOperand = new Fraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new Fraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// 15/-2 * 1/4
		firstOperand.setFraction(15, -2);
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);

		// (-21/2) / (3/7)
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(3, 7);
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// -21/2 + 7/8
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(7, 8);
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);

		System.out.println();

		// equality check
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand.setFraction(-42, 4);
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		Fraction first  = (Fraction)firstOperand;
		Fraction second = (Fraction)secondOperand;
		
		if (first.compareTo(second) == 0)
			System.out.println("Fractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second.setFraction(7, 8);
		if (first.compareTo(second) < 0)
			System.out.println("Fractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		if (second.compareTo(first) > 0)
			System.out.println("Fractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println();

		try {
			Fraction a1 = new Fraction(1, 0);		    
		}
		catch ( ArithmeticException arithmeticException )
           	{
              		System.err.printf( "\nException: %s\n", arithmeticException );
           	} // end catch

		try {
			Fraction a2 = new Fraction();		    
			Fraction a3 = new Fraction(1, 2);		    
			a3.divide(a2);
		}
		catch ( ArithmeticException arithmeticException )
           	{
              		System.err.printf( "\nException: %s\n", arithmeticException );
           	} // end catch



	}	// end main
} // end Fraction

