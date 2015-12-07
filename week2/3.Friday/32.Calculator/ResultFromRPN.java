import java.util.LinkedList;
import java.util.Stack;

public class ResultFromRPN {
	public static double getResultFromRPN(LinkedList<String> queue) {
	
		Stack<Double> myStack = new Stack<>();

		while (queue.size() != 0) {
			String currentToken = queue.pop();

			if ((Check.arithmeticOperations(currentToken.charAt(0)) != -1 && currentToken.length() > 1)
					|| (Character.isDigit(currentToken.charAt(0)))) {
				double number = Double.parseDouble(currentToken);
				myStack.push(number);
			}

			else if (Check.arithmeticOperations(currentToken.charAt(0)) > -1
					|| Check.functions( currentToken) > -1) {
				if (currentToken.equals("+")) {
					if (myStack.size() < 2) {
						// TODO: ("Invalid expression");
					}

					double firstValue = myStack.peek();
					myStack.pop();
					double secondValue = myStack.peek();
					myStack.pop();
					myStack.push(firstValue + secondValue);
					
				} else if (currentToken.equals("-")) {
					if (myStack.size() < 2) {
						// TODO: ("Invalid expression");
					}

					double firstValue = myStack.peek();
					myStack.pop();
					double secondValue = myStack.peek();
					myStack.pop();
					myStack.push(secondValue - firstValue);
					
				} else if (currentToken.equals("*")) {
					if (myStack.size() < 2) {
						// TODO: ("Invalid expression");
					}

					double firstValue = myStack.peek();
					myStack.pop();
					double secondValue = myStack.peek();
					myStack.pop();
					myStack.push(secondValue * firstValue);
					
				} else if (currentToken.equals("/")) {
					if (myStack.size() < 2) {
						// TODO: ("Invalid expression");
					}

					double firstValue = myStack.peek();
					myStack.pop();
					double secondValue = myStack.peek();
					myStack.pop();
					myStack.push(secondValue / firstValue);
					
				} else if (currentToken.equals("^")) {
					if (myStack.size() < 2) {
						// TODO: ("Invalid expression");
					}

					double firstValue = myStack.peek();
					myStack.pop();
					double secondValue = myStack.peek();
					myStack.pop();
					myStack.push(Math.pow(secondValue, firstValue));
					
				} else if (currentToken.equals("sqrt")) {
					if (myStack.size() < 1) {
						// TODO: ("Invalid expression");
					}

					double value = myStack.peek();
					myStack.pop();
					myStack.push(Math.sqrt(value));
				}
			}
		}

		if (myStack.size() == 1) {
			return myStack.peek();
		} else {
			return 0;
			// TODO: ("Invalid expression");
		}
	}
}
