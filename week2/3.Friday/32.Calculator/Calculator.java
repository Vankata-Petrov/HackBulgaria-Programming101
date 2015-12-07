import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Calculator {
	
	public double calculate(String input) {
	
		Vector<String> separated = TokenSeparator.separateTokens(input);
		Queue<String> converted = PolishNotation.convertToReversePolishNotation(separated);
		return ResultFromRPN.getResultFromRPN((LinkedList<String>) converted);
		
	}
	
}
