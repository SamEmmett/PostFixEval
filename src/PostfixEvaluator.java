
/**
 * PostfixEvaluator.java
 * 
 * Represents an evaluator of postfix expressions. Assumes the
 * operands are constants.
 */

import java.util.StringTokenizer;
import java.util.Stack;

/**
 * postfix evaluator of expressions, uses a stack internally
 * 
 * @author Samuel Emmett
 * @version XXXXXXX
 */
public class PostfixEvaluator {
	private static final char ADD = '+', SUBTRACT = '-';
	private static final char MULTIPLY = '*', DIVIDE = '/';

	private Stack stack;

	/**
	 * Sets up this evaluator by creating a new stack.
	 */
	public PostfixEvaluator() {
		stack = new Stack();
	}

	/**
	 * evaluates a postfix expresssion
	 * 
	 * @param expr expression in string format tokens separated by space
	 * @return integer results of expression evaluation
	 * @precondition expression must be valid (isValid() == true)
	 */
	public int evaluate(String expr) {

		// declare an empty stack
		Stack dump = new Stack();

		// declare operands: op1 and op2 both integer
		// declare result variable
		int op1;
		int op2;
		int result = 0;

		// declare next token as String
		String token;
		String nextToken;

		// declare a StringTokenizer

		StringTokenizer tokenizer = new StringTokenizer(expr);

		// while loop: loop through the expression, as long as there are more tokens
		// then
		// step into the while loop
		while (tokenizer.hasMoreTokens()) {
			token = tokenizer.nextToken();

			// if it is an operator then first pop the right operand and pop the left oprand
			// then push the evaluation result back into the stack

			if (this.isOperator(token) == true) {
				op1 = (int) dump.pop();
				op2 = (int) dump.pop();
				char oper = token.charAt(0);
				result = evalSingleOp(oper, op1, op2);
				dump.push(result);
				if (tokenizer.hasMoreTokens() == false) {
					break;
				}

			}

			// else the stack will push the token into the stack (you might want to convert
			// string to integer object)
			else {

				int recast = Integer.parseInt(token);
				dump.push(recast);
			}

		}

		// pop the only value from the stack and return the result

		result = (int) dump.pop();
		return result;
	}

	/**
	 * Determines if the specified token is an operator.
	 */
	private boolean isOperator(String token) {

		// if the token is "+" or "-" or "*" or "/" then return true
		char parsed = token.charAt(0);

		switch (parsed) {

		case '+':
			return true;

		case '-':
			return true;

		case '*':
			return true;

		case '/':
			return true;

		default:
			return false;
		}
	}

	/**
	 * Evaluates a single expression consisting of the specified operator and
	 * operands.
	 */
	private int evalSingleOp(char operation, int op1, int op2) {
		// declare a variable to hold the final result
		int result = 0;
		// use switch statement to calculate the results
		switch (operation) {

		case '+':
			result = op2 + op1;
			break;

		case '-':
			result = op2 - op1;
			break;

		case '*':
			result = op2 * op1;
			break;

		case '/':
			result = op2 / op1;
			break;

		}

		return result;
	}
}