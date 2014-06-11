//Juan Sanchez
//CSC 220

/************************************************************************************
 *
 *  		CSC220 Programming Project#2
 *  
 * Due Date: Mid-night, 4/9/2013, upload SimpleLispExpressionEvaluator.java to ilearn
 *
 * Specification: 
 *
 * Taken from Project 6, Chapter 5, Page 137
 * I have modified specification and requirements of this project
 *
 * Ref: http://www.gigamonkeys.com/book/        (see chap. 10)
 *      http://joeganley.com/code/jslisp.html   (GUI)
 *
 * In the language Lisp, each of the four basic arithmetic operators appears 
 * before an arbitrary number of operands, which are separated by spaces. 
 * The resulting expression is enclosed in parentheses. The operators behave 
 * as follows:
 *
 * (+ a b c ...) returns the sum of all the operands, and (+ a) returns a.
 *
 * (- a b c ...) returns a - b - c - ..., and (- a) returns -a. 
 *
 * (* a b c ...) returns the product of all the operands, and (* a) returns a.
 *
 * (/ a b c ...) returns a / b / c / ..., and (/ a) returns 1 / a. 
 *
 * Note: each operator must have at least one operand
 *
 * You can form larger arithmetic expressions by combining these basic 
 * expressions using a fully parenthesized prefix notation. 
 * For example, the following is a valid Lisp expression:
 *
 * 	(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)))
 *
 * This expression is evaluated successively as follows:
 *
 *	(+ (- 6) (* 2 3 4) (/ 3 1 -2))
 *	(+ -6 24 -1.5)
 *	16.5
 *
 * Requirements:
 *
 * - Design and implement an algorithm that uses Java API stacks to evaluate a 
 *   Valid Lisp expression composed of the four basic operators and integer values. 
 * - Valid tokens in an expression are '(',')','+','-','*','/',and positive integers (>=0)
 * - In case of errors, your program must throw SimpleLispExpressionEvaluatorException.
 * - Display result as floting point number with at 2 decimal places
 * - Negative number is not a valid "input" operand, e.g. (+ -2 3) 
 *   However, you may create a negative number using parentheses, e.g. (+ (-2)3)
 * - There may be any number of blank spaces, >= 0, in between tokens
 *   Thus, the following expressions are valid:
 *   	(+   (-6)3)
 *   	(/(+20 30))
 *
 * - Must use Java API Stack class in this project.
 *   Ref: http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * - Must throw SimpleLispExpressionEvaluatorException to indicate errors
 * - Must not add new or modify existing data fields
 * - Must implement these public methods : 
 *
 *   	public SimpleLispExpressionEvaluator()
 *   	public SimpleLispExpressionEvaluator(String inputExpression) 
 *      public void reset(String inputExpression) 
 *      public double evaluate()
 *      private void evaluateCurrentOperation()
 *
 * - You may add new private methods
 *
 *************************************************/

package PJ2;

import java.util.*;

public class SimpleLispExpressionEvaluator {
	// Current input Lisp expression
	private String inputExpr;
	// Main expression stack & current operation stack, see algorithm in
	// evaluate()
	private Stack<Object> exprStack;
	private Stack<Double> currentOpStack;

	// default constructor
	// set inputExpr to ""
	// create stack objects
	public SimpleLispExpressionEvaluator() 
	{
		// add statements
		inputExpr = "";
		exprStack = new Stack<Object>();
		currentOpStack = new Stack<Double>();
	}

	// default constructor
	// set inputExpr to inputExpression
	// create stack objects
	public SimpleLispExpressionEvaluator(String inputExpression) 
	{
		// add statements
		inputExpr = inputExpression;
		exprStack = new Stack<Object>();
		currentOpStack = new Stack<Double>();
	}

	// set inputExpr to inputExpression
	// clear stack objects
	public void reset(String inputExpression) 
	{
		// add statements
		inputExpr = inputExpression;
		exprStack.clear();
		currentOpStack.clear();
	}

	// This function evaluate current operator with its operands
	// See complete algorithm in evaluate()
	//
	// Main Steps:
	// Pop operands from exprStack and push them onto
	// currentOpStack until you find an operator
	// Apply the operator to the operands on currentOpStack
	// Push the result into exprStack
	//
	private void evaluateCurrentOperation() 
	{
		// add statements
		if (exprStack.size() <=1) 
		{
			throw new SimpleLispExpressionEvaluatorException("Missing parenthesis");
		}

		char operator = '0';
		double total = 0;

		while (!exprStack.isEmpty()) 
		{
			String operandTest= exprStack.pop().toString();
			try 
			{
				Double.parseDouble(operandTest);
				currentOpStack.push(Double.valueOf(operandTest));
			} 
			//this detects if it is an operator
			catch (NumberFormatException e) 
			{
				operator = operandTest.charAt(0);
				break;
			}
		}

		if (operator == '+') 
		{
			while (!currentOpStack.isEmpty()) 
			{
				double currentOperand = currentOpStack.pop();
				total = (total + currentOperand);
			}
			exprStack.push(total);
		}

		else if (operator == '-') 
		{
			if (currentOpStack.size() <= 1) 
			{
				double currentOperand = currentOpStack.pop();
				total = total - currentOperand;
			} 
			else 
			{
				total = currentOpStack.pop();
				while (!currentOpStack.isEmpty()) 
				{
					double currentOperand = currentOpStack.pop();
					total = total - currentOperand;
				}
			}
			exprStack.push(total);
		}

		else if (operator == '*') 
		{
			total = currentOpStack.pop();
			while (!currentOpStack.isEmpty()) 
			{
				double currentOperand = currentOpStack.pop();
				total = (total * currentOperand);
			}
			exprStack.push(total);
		}

		else if (operator == '/') 
		{
			if (currentOpStack.size() <= 1) 
			{
				double currentOperand = currentOpStack.pop();
				if (currentOperand == 0) 
				{
					throw new SimpleLispExpressionEvaluatorException("Division by zero cannot be done.");
				} else 
				{
					total = 1 / currentOperand;
				}
			} 
			else 
			{
				total = currentOpStack.pop();
				while (!currentOpStack.isEmpty()) 
				{
					double currentOperand = currentOpStack.pop();
					if (currentOperand == 0) 
					{
						throw new SimpleLispExpressionEvaluatorException("Division by zero cannot be done.");
					} else 
					{
						total = (total / currentOperand);
					}
				}
			}

			exprStack.push(total);

		} 
		else 
		{
			throw new SimpleLispExpressionEvaluatorException("Cannot read.");
		}
	}

	/**
	 * This funtion evaluates current Lisp expression in inputExpr It return
	 * result of the expression
	 * 
	 * The algorithm:
	 * 
	 * Step 1 Scan the tokens in the string. Step 2 If you see an operand, push
	 * operand object onto the exprStack Step 3 If you see "(", next token
	 * should be an operator Step 4 If you see an operator, push operator object
	 * onto the exprStack Step 5 If you see ")" // steps in
	 * evaluateCurrentOperation() : Step 6 Pop operands and push them onto
	 * currentOpStack until you find an operator Step 7 Apply the operator to
	 * the operands on currentOpStack Step 8 Push the result into exprStack Step
	 * 9 If you run out of tokens, the value on the top of exprStack is is the
	 * result of the expression.
	 */
	public double evaluate() 
	{
		// only outline is given...
		// you need to add statements/local variables
		// you may delete or modify any statements in this method
		// use scanner to tokenize inputExpr
		//@SuppressWarnings("resource")
		Scanner inputExprScanner = new Scanner(inputExpr);

		// Use zero or more white space as delimiter,
		// which breaks the string into single character tokens
		inputExprScanner = inputExprScanner.useDelimiter("\\s*");
		int operandcounter = 0;
		int maxNumOperands = 0;
        int openParenthesisCount = 0;

		// Step 1: Scan the tokens in the string.
		while (inputExprScanner.hasNext()) 
		{
			if (operandcounter > maxNumOperands) 
			{
				throw new SimpleLispExpressionEvaluatorException("Too many operators in expression."); //
			}

			// Step 2: If you see an operand, push operand object onto the
			// exprStack
			if (inputExprScanner.hasNextInt()) 
			{
				// This force scanner to grab all of the digits
				// Otherwise, it will just get one char
				String dataString = inputExprScanner.findInLine("\\d+");
				exprStack.push(dataString);
				// more ...
			} 
			else 
			{
				// Get next token, only one char in string token
				String aToken = inputExprScanner.next();
				char item = aToken.charAt(0);

				switch (item) 
				{
				// Step 3: If you see "(", next token should an operator
                
				case '(':
					maxNumOperands++;
                    openParenthesisCount++;
					break;
				// Step 4: If you see an operator, push operator object onto the
				// exprStack
				case '+':
					exprStack.push(item);
					operandcounter++;
					break;
				case '-':
					exprStack.push(item);
					operandcounter++;
					break;
				case '*':
					exprStack.push(item);
					operandcounter++;
					break;
				case '/':
					exprStack.push(item);
					operandcounter++;
					break;
				// Step 5: If you see ")" do steps 6,7,8 in
				// evaluateCurrentOperation()
				case ')':
                
                    operandcounter = 0;
                    evaluateCurrentOperation();
                    break;
                    
				default: // error
					throw new SimpleLispExpressionEvaluatorException(item
							+ " is an invalid expression operator.");
				} // end switch
			} // end else
		} // end while
			// Step 9: If you run out of tokens, the value on the top of
			// exprStack is
		// is the result of the expression.
		// return result
		if (exprStack.size() >1) 
		{
			throw new SimpleLispExpressionEvaluatorException("A number is outside the parenthesis.");
		}
		String buffer = exprStack.pop().toString();
		double result = Double.parseDouble(buffer);
		return result;
	}

	// This static method is used by main() only
	private static void evaluateExprTest(String s, SimpleLispExpressionEvaluator expr) {
		Double result;
		System.out.println("Expression " + s);
		expr.reset(s);
		result = expr.evaluate();
		System.out.printf("Result %.2f\n", result);
		System.out.println("-----------------------------");
	}

	public static void main(String args[]) {
		SimpleLispExpressionEvaluator expr = new SimpleLispExpressionEvaluator();
		String test1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)))";
		String test2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (* 1) (- 21 3 1)))";
		String test3 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 1) (- 2 1 )))";
		String test4 = "(+ (/2))";
		String test5 = "(+ (/2 3 0))";
		String test6 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 3) (- 2 1 ))))";
		evaluateExprTest(test1, expr);
		evaluateExprTest(test2, expr);
		evaluateExprTest(test3, expr);
		evaluateExprTest(test4, expr);
		evaluateExprTest(test5, expr);
		evaluateExprTest(test6, expr);
	}
}
