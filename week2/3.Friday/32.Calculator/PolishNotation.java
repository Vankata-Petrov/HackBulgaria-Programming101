import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class PolishNotation {

	public static Queue<String> convertToReversePolishNotation(Vector<String> tokens) {
	
		Stack<String> myStack = new Stack<>();
		Queue<String> myQueue = new LinkedList<>();
		short leftBracket = 0;
		
		for (int i = 0; i < tokens.size(); i++) {
			String currentToken = tokens.elementAt(i);

			if ((Check.arithmeticOperations(currentToken.charAt(0)) != -1 && currentToken.length() > 1)
					|| (currentToken.charAt(0) >= '0' && currentToken.charAt(0) <= '9')) {
				myQueue.add(currentToken);
			} else if (currentToken.equals("sqrt")) {
				myStack.push(currentToken);
			} else if (Check.arithmeticOperations(currentToken.charAt(0)) > -1 || currentToken.equals("^")) {
				while (myStack.size() != 0
						&& (Check.arithmeticOperations(myStack.peek().charAt(0)) > -1 || myStack.peek().equals("^"))
						&& Check.precedence(currentToken) <= Check.precedence(myStack.peek())) {
					myQueue.add(myStack.peek());
					myStack.pop();
				}

				myStack.push(currentToken);
			} else if (currentToken.equals("(")) {
				myStack.push("(");
				leftBracket++;
			} else if (currentToken.equals(")")) {
			
				if (leftBracket == 0 || myStack.size() == 0) {
					// TODO: "Invalid brackets position/number");
				}
				
				while (!myStack.peek().equals("(")) {
					myQueue.add(myStack.peek());
					myStack.pop();
				}
				
				if (myStack.peek().equals("(")) {
					leftBracket--;
				}
				
				myStack.pop();
				
				if (myStack.size() != 0 && Check.functions( myStack.peek()) > -1) {
					myQueue.add(myStack.peek());
					myStack.pop();
				}
			}
		}

		while (myStack.size() != 0) {
			if (Check.brackets( myStack.peek().charAt(0)) > -1) {
				// TODO: ("Invalid brackets position/number");
			}

			myQueue.add(myStack.peek());
			myStack.pop();
		}

		return myQueue;
	}
}
