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
 * 
 * </p>
 */
public class RecursionLab {
	/*Class level data members and statics*/
	/*
	 * JTextArea creates a new canvas
	 * static count 
	 * */
	private static JTextArea myArea = new JTextArea();
	private static int count = 0;


	@SuppressWarnings("javadoc")
	public static void main(String args[]) {
		// Calls to both functions. Both produce the same result but one is recursive
		// while the other is iterative.
		//int solution = iterativeSum( 20 );
		int solution = recursiveSum( 20 );

		//Some GUI details
		myArea.setText(("Result is : " + solution + "\n" + myArea.getText()));
		JScrollPane myPane = new JScrollPane( myArea );
		myPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myPane.setPreferredSize(new Dimension(600,300));
		JOptionPane.showMessageDialog( null, myPane );
		System.exit(0);
	}//end main

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
	 * is always 1, so return 1.
	 */
	public static int recursiveExponent(int base, int n) {
		updateDisaplyForExpRec(base, n);
		if(n == 0) {
			return base;
		}else if(n < 0) {
			return -1;
		}else {
			return(base*recursiveExponent(n-1,base));
		}
	}                                                                                                                                                                                                                                                                                                                                                     
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

		if( count == 1 )  {
			text += "\n       return ( n + recursiveExponent( n - 1 ) ) \n\n";
			text += "       CALL STACK IN MAIN MEMORY                ";
		}


		text += "\n/*******************Method invocation " + count + "*********************";


		text += "\n Calling exponentialRecursion( int n = " + n +" ). ";
		text += "\n The return statement from this function will resolve in " + (n-1) + " more recursive method calls...";

		if( n != 1 ) {
			text += "\n The return statement which invokes the recursive call is \"return ( " + n + " * exponentialRecursion( "+ (n - 1) +","+base+"));";
		} else {
			text += "\n The base case has been hit.\nThe return statement is \"return 1;\" which is the value returned to the expression above. ";
			text += "\n Notice how hitting the base case will provide a solid, known piece of information from which we will construct more known ";
			text += "\n information by bubbling up through all of the other, yet-to-be-determined return expressions";
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





