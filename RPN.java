package lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RPN {
	public int evalRPN(List<String> tokens) {
		Stack<Integer> s = new Stack<>(); // create a new stack
		for (String token : tokens) { // loop through the array of strings called tokens, this contains our numbers
										// and operands
			if ("+-*/".contains(token)) { // if the token contains an operator
				int y = s.pop(); // pop the last operand
				int x = s.pop(); // pop the first operand

				if (token.equals("+")) // if operand is +, add the two operands
					s.push(x + y);

				else if (token.equals("-")) // if operand is -, sutract the two operands
					s.push(x - y);

				else if (token.equals("*")) // if operand is *, multiply the two operands
					s.push(x * y);

				else if (token.equals("/")) // if operand is /, divide the two operands
					s.push(x / y);

			} else { // token is a number
				s.push(Integer.parseInt(token)); // convert the token to an interger
			}
		}

		return s.pop(); // when there is one number left, that is our answer and return it

	}

	public ArrayList<String> getList(int example) throws Exception {
		if (example < 0 || example > 2) {
			throw new Exception("Three examples only!");
		}

		ArrayList<String> list = new ArrayList<String>();

		if (example == 0)
			list.addAll(List.of(new String[] { "2", "1", "+", "3", "*" }));

		else if (example == 2)
			list.addAll(List.of(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" }));

		else
			list.addAll(List.of(new String[] { "4", "13", "5", "/", "+" }));

		return list;
	}

	public static void main(String[] args) {
		RPN lab = new RPN();
		try {
			for (int example = 0; example < 3; example++) {
				System.out.println("Example " + example + " evaludates to " + lab.evalRPN(lab.getList(example)));
			}

		} catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}

	}

}
