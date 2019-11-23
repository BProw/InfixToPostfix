import java.util.Scanner;
/**
 * This program takes a infix expression from user input and 
 * converts to its postfix equivalent. 
 * @author Brian LeProwse
 * Mac OS-X Yosemite, Eclipse Java EE
 * Audacious - Intrepidly daring; recklessly bold.
 * "It's a lack of faith that makes people afraid of meeting challenges, and  
 *  I believed in myself." Muhammad Ali (1942-2016)
 *  Assignment: BrianLeProwse_05
 */
public class Driver {
	/**
	 * BrianLeProwse_05 is the driver class for this program. Main will 
	 * continually prompt the user for infix expressions and output the
	 * postfix equivalent until, "quit" is entered. 
	 * @param args
	 */
	public static void main(String[] args) {
		Postfix postfix = new Postfix();
		String input = "";				// User's infix expression.
		String quit = "quit";
		int count = 1;					// Number of expressions entered. 
		
		// Open Scanner
		Scanner in = new Scanner(System.in);
		
		// Output user instructions. 
		System.out.println("Enter infix expressions to convert to postfix " + 
						   "notation. Enter, \""+"quit"+"\" to terminate.");
												
		// First infix expression. 
		System.out.println("\nEnter " + quit + 
						   " or infix expression number: " + count);	
		
		count++;					// Increment count of expressions. 
		
		// Continue prompting for expressions while input is not, "quit".
		while(in.hasNext()) {
			
			input = in.nextLine();		// Store expression. 
			
			// End prompt for expressions, exit loop.
			if(input.equals("quit")) {
				break;
			}
			
			// Send infix expression to Stack. Output postfix expression. 
			System.out.print("\n\tPostfix: " + 
							 postfix.convertToPostfix(input) + "\n\n");
			
			// Continual prompt for expressions. 
			System.out.println("Enter " + quit + 
							   " or infix expression number: " + count);	
			
			count++;					// Increment count. 
			
		}		
		System.out.println("good bye : )");
		in.close();				// Close Scanner.	
	}
}
