public static boolean brackets(String input) {

		short flag = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				flag++;
			} else if (input.charAt(i) == ')') {
				flag--;
			}
			if (flag < 0) {
				return false;
			}
		}
		
		if (flag == 0) {
			return true;
		} else {
			return false;
		}
		
	}

	public static boolean brackets2(String input) {
	
		Deque<Character> stack = new ArrayDeque<>();
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '(') {
				stack.add('(');
			} else if (input.charAt(i) == ')' && !stack.isEmpty()) {
				if (stack.peek() == '(') {
					stack.poll();
				} else if (stack.peek() == ')') {
					stack.add(')');
				}
			} else
				return false;
		}
		
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
		
	}
