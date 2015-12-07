
public class Check {

	private static char[] arithmeticOperations = { '+', '-', '*', '/' };
	private static char[] brackets = { '(', ')' };
	private static String[] functions = { "sqrt", "^" };
	
	public static int arithmeticOperations(char item) {
	
		for (int i = 0; i < arithmeticOperations.length; i++)
			if (arithmeticOperations[i] == item) {
				return i;
			}
		return -1;
		
	}
	
	public static int brackets(char item) {
		for (int i = 0; i < brackets.length; i++)
			if (brackets[i] == item) {
				return i;
			}
		return -1;
	}
	
	public static int functions(String item) {
		for (int i = 0; i < functions.length; i++)
			if (functions[i].equals(item)) {
				return i;
			}
		return -1;
	}

	public static int precedence(String arithmeticOperator) {
		if (arithmeticOperator.equals("+") || arithmeticOperator.equals("-"))
			return 1;
		else if (arithmeticOperator.equals("^"))
			return 3;
		else
			return 2;
	}
	
}
