/**
 * Convert infix expression to its postfix equivalent. 
 * @author Brian LeProwse
 *
 */
public class Postfix extends Stack {
	/*
	 *  Converts an infix expression (inputExpression) to it's postfix 
	 *  equivalent. Postfix class extends the Stack class to make use of 
	 *  push(), pop(), peek(), and isEmpty().
	 */
	public String convertToPostfix(String inputExpression) {
		
		// Remove white space in infix String.
		inputExpression = inputExpression.replaceAll("\\s", "");
		String postfix = "";				// Infix to postfix String. 
		char token = ' ';				// Current token being parsed.
		int valueOf;						// Numerical value of the token.
		
		for(int i = 0; i < inputExpression.length(); i++) {
			
			// Find numeric value of the character at the ith position of the
			// input expression.
			token = inputExpression.charAt(i);			
			valueOf = Character.getNumericValue(token);
			
			// Add character to postfix String if an operator.
			if (valueOf >= 0) {
				postfix += token + " ";
				
			} else if (token == '(') {
				// Push opening parenthesis onto stack.
				push(token);	
				
			} else if (token == ')') {
				
				// Pop entries in stack until empty or '(' is found. 
				while(!isEmpty() && peek() != '(') {
					
					postfix += pop() + " ";			// Append to postfix.
				
				}
				pop();   // Pop opening parenthesis from stack. 
			
			} else {
				// Calculate precedence of operators in expression. 
				int precedent1, precedent2;
				
				// Push operator to empty stack.
				if (isEmpty()) {
					push(token);
				} else {
					
					/*
					 *  Case # 1: token is less than top token in stack.
					 *  Case # 2: token and top token in stack is + or -.
					 *  Case # 3: token and top token in stack is * or /.
					 *  Case # 4: token is, '^' and thus greater than all 
					 *  tokens in the stack. 
					 */
					if ((token == '+' || token == '-') &&		// Case # 1.
						(peek() == '*' || peek() == '/') ||  	// Case # 1.
						(token == '*' || token == '/') &&		// Case # 2.
						(peek() == '*' || peek() == '/') ||		// Case # 2.
						(token == '+' || token == '-') &&		// Case # 3.
						(peek() == '+' || peek() == '-') ||		// Case # 3.
						((token == '+' || token == '-') ||		// Case # 4.
						(token == '*' || token == '/')) &&		// Case # 4.
						(peek() == '^' || token == '^')) {
						
						// Current token is less than or equal to top token
						// in stack.
						precedent1 = 1;
						precedent2 = 2;
					
					// Current token is greater than top token in stack.
					} else {
						precedent1 = 2;
						precedent2 = 1;
					}
					// Current token is higher in precedence than top token in
					// stack. Push current token to stack. 
					if (precedent1 > precedent2) {
						push(token);
					
					} else {
						// Append higher precedence token to expression. 
						postfix += pop() + " ";
						// Push lower precedence token to top of stack.
						push(token);
					}
				}
			} 
		}

		// Empty remaining stack and append to postfix output.
		while(!isEmpty()) {
			postfix += pop() + " ";
		}
		return postfix;					// Return converted postfix expression. 
	}
}
