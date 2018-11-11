/*-----------------------------------------------------------------------------------
 * 
 *	sum( n ) is a summation algorithm defined as follows:
 *				
 *	(1)		sum( n ) =  n + (n-1) + (n-2) + ... + 1
 * 	(1a) 	sum( 1 ) = 1
 *
 * and from this definition, we can rewrite this formula in terms of itself, such that:
 *			
 *	(2)	    sum( n ) = n + sum( n - 1 ) 
 *
 * and we can do this again
 *
 *	(3)    	sum( n ) = n + ( n - 1) + sum( n - 2 ) 
 *
 * and so on, and so forth, we finally end up with the same as above
 *
 *	(1)	    sum( n ) = n + (n-1) + (n-2) + ... + 1 
 *
 *----------------------------------------------------------------------------------- */ 

import java.awt.Dimension;

import javax.swing.*;

/**
 * Class Description:
 * @author Ian Bryan
 * @version 11/04/2018
 * 
 * <p>
 * This is a long class with lots of methods in it that are all examples of where and how
 * to implement some basic recursive use. The methods are built to example the efficiency 
 * and some pitfalls to using recursion on logic programatically.
 * </p>
 */
public class RecursionLab {
	/*Class level data members and statics*/
	/*
	 * var JTextArea - Generates a new canvas.
	 * var static count - Used primarily in the updateDisplay methods.
	 * */
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;

	@SuppressWarnings("javadoc")
	public static void main(String args[]) {
		// Calls to both functions. Both produce the same result but one is recursive
		// while the other is iterative.
		//int solution = iterativeSum( 20 );
		//int solution = recursiveSum( 20 );

		/***********************************************/
		/* Some method calls for modules that use recursion to solve problems.*/
		//int solution = expSumRule(2,6);
		//int solution  = expSumRuleV2(2,11);
		int solution = fib(5);
		//int solution = factorial(5);
		//int solution = combinations(10,5);
		/***********************************************/

		//Some GUI details.
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );
		System.exit(0);
	}

	/*			MODULES THAT USE RECURSION.			*/
	/** 
	 * @param n
	 * @return recursiveSum() function holds the details of what each suspended
	 * call will use to produce an output to be handed back to the same method. 
	 */
	public static int recursiveSum(int n) {
		//overhead for nice output, not required
		updateRecursiveDisplay(n);
		if(n == 1) {
			return 1;
		}else {
			return (n + recursiveSum(n - 1));
		}		
	}

	/**
	 * @param n
	 * @param base
	 * @return
	 * Recursively calls for an integer 'n' which represents the base, and then
	 * an integer 'base' which is the base to raise from.
	 * 
	 * Base Case: When n==0, this is to say "when any number raised to it's 0th power"
	 * is always the base, so return the base.
	 */
	public static int expSumRule(int base, int n) {
		updateDisaplyForExpRec(base, n);
		if(n == 0 || n == 1) {
			return base;
		}else{
			return(base * expSumRule(base, n-1));
		}
	}     

	/**
	 * @param base
	 * @param n
	 * @return Returns the same value as the module expSumRule(int,int) but with
	 * a different, more efficient routine.
	 */
	public static int expSumRuleV2(int base, int n) {
		updateDisaplyForExpRecV2(base,n);
		if(n == 0 || n == 1) {
			return base;
		}else if (n % 2 == 0){
			return (int) Math.pow(base * expSumRuleV2(base,n/2), 2);
		}else {
			return (int) Math.pow(base * expSumRuleV2(base, (n-1)/2), 2);
		}
	}

	/**
	 * @param n
	 * @return Returns the value of the integer provided after processing it by
	 * the Fibonacci sequence.
	 */
	public static int fib(int n){
		updateFib(n);
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			return fib(n-1) + fib(n-2);
		}
	}

	/**
	 * @param n
	 * @return Returns integer value of 'n' factorial (n!)
	 */
	public static int factorial(int n){
		updateFactorial(n);
		if(n == 1){
			return 1;
		}else if(n==0) {
			return n;
		}else{
			return (n * factorial(n-1));
		}
	}

	/**
	 * @param n
	 * @param r
	 * @return Returns the integer value of the number of ways R elements
	 * can be picked from N.
	 * */
	/*public static int combinations(int n, int r) {
		updateCombinationsDisplay(n,r);
		if(r == 1) {
			return 1;
		}else if(n == 0){
			return 0;
		}else if(n==r){
			System.out.println("n and r cannot be equal, division by zero error occurs.");
			return 0;
		}else {
			int fR = factorial(r);
			int fN = factorial(n);
			int fNMinusR = factorial(n-r);
			int denominator = fR * fNMinusR; 
			return combinations(fN,fN/denominator);
		}
	}*/

	/**
	 * @param i
	 * @return Returns the same value as the recursive function.
	 */
	public static int iterativeSum(int i) {
		int total = 0;

		for( int n = i; n >= 1; n--) {
			updateIterativeDisplay(n);
			total = total + n;
		}
		return total;
	}						

	/*		DISPLAY METHODS FOR ABOVE MODULES.		*/
	/**
	 * @param n
	 * A given method for printing all the data to the screen in a formatted way.
	 */
	public static void updateIterativeDisplay(int n) {
		count++;
		String text = myArea.getText();

		text += "\n/*******************Loop iteration " + count + "**************************************";
		text += "\n Calling iterativeSum( int n = " + n +" ). Total += " + n;
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param base
	 * @param n 
	 * 
	 * Update method for display on JTextArea
	 */
	public static void updateDisaplyForExpRec(int base, int n){
		count++;
		String text = myArea.getText();

		if(count == 1)  {
			text += "\n       return ( base * expSumRule( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";
		text += "\n Calling expSumRule( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + base + " * expSumRule( "+ base +"," + (n-1) + "));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return base;\" which is the value returned to the expression above. ";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param base
	 * @param n
	 * 
	 * Updates display for the 2nd version of the module expRuleRum()
	 */
	public static void updateDisaplyForExpRecV2(int base, int n){
		count++;
		String text = myArea.getText();

		if(count == 1)  {
			text += "\n       (int) Math.pow(base * expSumRuleV2(base,n/2), 2) || "
					+ " return (int) Math.pow(base * expSumRuleV2(base, (n-1)/2), 2) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";
		text += "\n Calling expSumRuleV2( int n = " + n +" ). ";

		if( n != 1 ) {
			text += "\n The return statement, when n ="+n+" which invokes the recursive call is " + "return (int) Math.pow("+base+" * expSumRuleV2("+base+","+n/2+")"+",2)";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return base;\" which is the value returned to the expression above. ";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param n
	 * Updates display for the static method fib(int)
	 */
	public static void updateFib(int n) {
		count++;
		String text = myArea.getText();

		if(count == 1)  {
			text += "\n       return fib(n-1) + fib(n-2)) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";
		text += "\n Calling expSumRule( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + n + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is return fib("+(n-1)+") + "+"fib("+(n-2)+")";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 0 | 1;\" which is the value returned to the expression above. ";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param n
	 * Updates display for the static method factorial(int)
	 */
	public static void updateFactorial(int n) {
		count++;
		String text = myArea.getText();

		if(count == 1)  {
			text += "\n       return (n * factorialSum(n-1)) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";
		text += "\n Calling expSumRule( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is return factorialSum("+(n-1)+")";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above.";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param n
	 * @param r
	 * 
	 * Updates display for the static method combinations(int,int).
	 */
	public static void updateCombinationsDisplay(int n, int r) {
		count++;
		String text = myArea.getText();

		int fR = factorial(r);
		int fN = factorial(n);
		int fNMinusR = factorial(n-r);
		int denominator = fR * fNMinusR;

		if(count == 1)  {
			text += "\n       return combinations(fN,fN/denominator); \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}

		text += "\n/*******************Method invocation " + count + "*********************";
		text += "\n Calling expSumRule( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + n + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is return combinations("+fN+","+denominator+")";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 0 | 1;\" which is the value returned to the expression above.";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );
	}

	/**
	 * @param n
	 * Building the String of combined data for output processing.
	 */
	public static void updateRecursiveDisplay(int n) {

		count++;
		String text = myArea.getText();


		if( count == 1 )  {
			text += "\n       return ( n + recursiveSum( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling recursiveSum( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " + recursiveSum( "+ (n - 1) +" ));";
		} else {
			text += "\n The base case has been hit.  The return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
		}
		text += "\n***************************************************************************/";

		myArea.setText( text );

	}
}