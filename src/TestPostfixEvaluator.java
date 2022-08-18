import java.util.Scanner;


public class TestPostfixEvaluator {
	
	public static void main(String args[])
	{
		System.out.println("Please input a valid postfix expression");
		PostfixEvaluator pe = new PostfixEvaluator();
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		
		System.out.println(expression + " = " + pe.evaluate(expression));
		
	}

}
