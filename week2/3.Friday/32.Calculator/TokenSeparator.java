import java.util.Vector;

public class TokenSeparator {

	public static Vector<String> separateTokens(String input) {
		Vector<String> result = new Vector<>();
		String number = "";

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' && (i == 0 || input.charAt(i - 1) == '(')) {
				number += '-';
				
			} else if ((Character.isDigit(input.charAt(i))) || input.charAt(i) == '.') {
				number += input.charAt(i);
				
			} else if ((!(Character.isDigit(input.charAt(i)))) && input.charAt(i) != '.'
					&& number.length() != 0) {
				result.add(number);
				number = "";
				i--;
				
			} else if (Check.brackets(input.charAt(i)) > -1) {
				result.add(String.valueOf(input.charAt(i)));
				
			} else if (Check.arithmeticOperations( input.charAt(i)) > -1) {
				result.add(String.valueOf(input.charAt(i)));
				
			} else if (i + 3 < input.length() && input.substring(i, i+4).equals("sqrt")) {
				result.add("sqrt");
				i += 3;
				
			} else if (input.charAt(i) == '^') {
				result.add(String.valueOf(input.charAt(i)));
				
			} else {
				// TODO:throw invalid argument
			}
		}

		if (number.length() != 0) {
			result.add(number);
		}
		return result;
	}

}
